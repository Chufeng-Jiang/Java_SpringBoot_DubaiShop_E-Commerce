package com.dushop.admin;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.order
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-27  17:01
 *@Description: TODO
 *@Version: 1.0
 */
import java.util.List;

import com.dushop.common.entity.OrderNotFoundException;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.dushop.common.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.dushop.admin.setting.SettingService;
import com.dushop.common.entity.Setting;
import com.dushop.common.entity.Order;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import org.springframework.web.bind.annotation.PostMapping;
import com.dushop.common.entity.OrderDetail;
import com.dushop.common.entity.OrderStatus;
import com.dushop.common.entity.OrderTrack;
import com.dushop.common.entity.Product;

@Controller
public class OrderController {
    private String defaultRedirectURL = "redirect:/orders/page/1?sortField=orderTime&sortDir=desc";

    @Autowired private OrderService orderService;
    @Autowired private SettingService settingService;

    /*self-code, but adapted from user module*/
    @GetMapping("/orders")
    public String listFirstPage() {
        return defaultRedirectURL;
    }

    /***************************************************************************************
     *    Title: mediCare
     *    Author: Bhardwaj-Abh
     *    Availability: https://github.com/Bhardwaj-Abh/medi/blob/32f56a6712eec42f688d93b1de83de0efb96f702/MediCareCommon/src/main/java/com/medicare
     ***************************************************************************************/
    @GetMapping("/orders/page/{pageNum}")
    public String listByPage(@PagingAndSortingParam(listName = "listOrders", moduleURL = "/orders") PagingAndSortingHelper helper, @PathVariable(name = "pageNum") int pageNum,
            HttpServletRequest request, @AuthenticationPrincipal DuShopUserDetails loggedUser) {

        orderService.listByPage(pageNum, helper);
        loadCurrencySetting(request);

        if (!loggedUser.hasRole("Admin") && !loggedUser.hasRole("Salesperson") && loggedUser.hasRole("Shipper")) {
            return "orders/orders_shipper";
        }
        return "orders/orders";
    }

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    private void loadCurrencySetting(HttpServletRequest request) {
        List<Setting> currencySettings = settingService.getCurrencySettings();

        for (Setting setting : currencySettings) {
            request.setAttribute(setting.getKey(), setting.getValue());
        }
    }

    /***************************************************************************************
     *    Title: mediCare
     *    Author: Bhardwaj-Abh
     *    Availability: https://github.com/Bhardwaj-Abh/medi/blob/32f56a6712eec42f688d93b1de83de0efb96f702/MediCareCommon/src/main/java/com/medicare
     ***************************************************************************************/
    @GetMapping("/orders/detail/{id}")
    public String viewOrderDetails(@PathVariable("id") Integer id, Model model,RedirectAttributes ra, HttpServletRequest request,
                                   @AuthenticationPrincipal DuShopUserDetails loggedUser) {
        try {
            Order order = orderService.get(id);
            loadCurrencySetting(request);
            boolean isVisibleForAdminOrSalesperson = false;

            if (loggedUser.hasRole("Admin") || loggedUser.hasRole("Salesperson")) {
                isVisibleForAdminOrSalesperson = true;
            }

            model.addAttribute("isVisibleForAdminOrSalesperson", isVisibleForAdminOrSalesperson);
            model.addAttribute("order", order);

            return "orders/order_details_modal";
        } catch (OrderNotFoundException ex) {
            ra.addFlashAttribute("message", ex.getMessage());
            return defaultRedirectURL;
        }

    }

    /*self-code, but adapted from user module*/
    @GetMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            orderService.delete(id);;
            ra.addFlashAttribute("message", "The order ID " + id + " has been deleted.");
        } catch (OrderNotFoundException ex) {
            ra.addFlashAttribute("message", ex.getMessage());
        }
        return defaultRedirectURL;
    }

    /***************************************************************************************
     *    Title: mediCare
     *    Author: Bhardwaj-Abh
     *    Availability: https://github.com/Bhardwaj-Abh/medi/blob/32f56a6712eec42f688d93b1de83de0efb96f702/MediCareCommon/src/main/java/com/medicare
     ***************************************************************************************/
    @GetMapping("/orders/edit/{id}")
    public String editOrder(@PathVariable("id") Integer id, Model model, RedirectAttributes ra, HttpServletRequest request) {
        try {
            Order order = orderService.get(id);;
            List<Country> listCountries = orderService.listAllCountries();

            model.addAttribute("pageTitle", "Edit Order (ID: " + id + ")");
            model.addAttribute("order", order);
            model.addAttribute("listCountries", listCountries);
            return "orders/order_form";
        } catch (OrderNotFoundException ex) {
            ra.addFlashAttribute("message", ex.getMessage());
            return defaultRedirectURL;
        }
    }
    /***************************************************************************************
     *    Title: mediCare
     *    Author: Bhardwaj-Abh
     *    Availability: https://github.com/Bhardwaj-Abh/medi/blob/32f56a6712eec42f688d93b1de83de0efb96f702/MediCareCommon/src/main/java/com/medicare
     ***************************************************************************************/
    @PostMapping("/order/save")
    public String saveOrder(Order order, HttpServletRequest request, RedirectAttributes ra) {
        String countryName = request.getParameter("countryName");
        order.setCountry(countryName);
        updateProductDetails(order, request);
        updateOrderTracks(order, request);
        orderService.save(order);
        ra.addFlashAttribute("message", "The order ID " + order.getId() + " has been updated successfully");

        return defaultRedirectURL;
    }

    /*self-code, but adapted from user module*/
    private void updateProductDetails(Order order, HttpServletRequest request) {
        String[] detailIds = request.getParameterValues("detailId");
        String[] productIds = request.getParameterValues("productId");
        String[] productPrices = request.getParameterValues("productPrice");
        String[] productDetailCosts = request.getParameterValues("productDetailCost");
        String[] quantities = request.getParameterValues("quantity");
        String[] productSubtotals = request.getParameterValues("productSubtotal");
        String[] productShipCosts = request.getParameterValues("productShipCost");

        Set<OrderDetail> orderDetails = order.getOrderDetails();

        for (int i = 0; i < detailIds.length; i++) {
            OrderDetail orderDetail = new OrderDetail();
            Integer detailId = Integer.parseInt(detailIds[i]);
            if (detailId > 0) {
                orderDetail.setId(detailId);
            }

            orderDetail.setOrder(order);
            orderDetail.setProduct(new Product(Integer.parseInt(productIds[i])));
            orderDetail.setProductCost(Float.parseFloat(productDetailCosts[i]));
            orderDetail.setSubtotal(Float.parseFloat(productSubtotals[i]));
            orderDetail.setShippingCost(Float.parseFloat(productShipCosts[i]));
            orderDetail.setQuantity(Integer.parseInt(quantities[i]));
            orderDetail.setUnitPrice(Float.parseFloat(productPrices[i]));

            orderDetails.add(orderDetail);
        }
    }

    /***************************************************************************************
     *    Title: mediCare
     *    Author: Bhardwaj-Abh
     *    Availability: https://github.com/Bhardwaj-Abh/medi/blob/32f56a6712eec42f688d93b1de83de0efb96f702/MediCareCommon/src/main/java/com/medicare
     ***************************************************************************************/
    private void updateOrderTracks(Order order, HttpServletRequest request) {
        String[] trackIds = request.getParameterValues("trackId");
        String[] trackStatuses = request.getParameterValues("trackStatus");
        String[] trackDates = request.getParameterValues("trackDate");
        String[] trackNotes = request.getParameterValues("trackNotes");

        List<OrderTrack> orderTracks = order.getOrderTracks();
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");

        for (int i = 0; i < trackIds.length; i++) {
            OrderTrack trackRecord = new OrderTrack();

            Integer trackId = Integer.parseInt(trackIds[i]);
            if (trackId > 0) {
                trackRecord.setId(trackId);
            }

            trackRecord.setOrder(order);
            trackRecord.setStatus(OrderStatus.valueOf(trackStatuses[i]));
            trackRecord.setNotes(trackNotes[i]);

            try {
                trackRecord.setUpdatedTime(dateFormatter.parse(trackDates[i]));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            orderTracks.add(trackRecord);
        }
    }


}