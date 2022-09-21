package com.dushop;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dushop.common.entity.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.UnsupportedEncodingException;
import com.dushop.paypal.PayPalApiException;
import com.dushop.paypal.PayPalService;
import java.text.DateFormat;
import com.dushop.setting.PaymentSettingBag;
import java.text.SimpleDateFormat;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.dushop.common.entity.Address;
import com.dushop.common.entity.CartItem;
import com.dushop.common.entity.Customer;
import com.dushop.common.entity.ShippingRate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import com.dushop.common.entity.Order;
import com.dushop.setting.CurrencySettingBag;
import com.dushop.setting.EmailSettingBag;
import com.dushop.setting.SettingService;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.checkout
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-28  14:42
 *@Description: TODO
 *@Version: 1.0
 */


@Controller
public class CheckoutController {

    @Autowired private CheckoutService checkoutService;
    @Autowired private CustomerService customerService;
    @Autowired private AddressService addressService;
    @Autowired private ShippingRateService shipService;
    @Autowired private ShoppingCartService cartService;

    @Autowired private OrderService orderService;
    @Autowired private SettingService settingService;

    @Autowired private PayPalService paypalService;

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    @GetMapping("/checkout")
    public String showCheckoutPage(Model model, HttpServletRequest request) {
        Customer customer = getAuthenticatedCustomer(request);

        Address defaultAddress = addressService.getDefaultAddress(customer);
        ShippingRate shippingRate = null;

        if (defaultAddress != null) {
            model.addAttribute("shippingAddress", defaultAddress.toString());
            shippingRate = shipService.getShippingRateForAddress(defaultAddress);
        } else {
            model.addAttribute("shippingAddress", customer.toString());
            shippingRate = shipService.getShippingRateForCustomer(customer);
        }

        if (shippingRate == null) {
            return "redirect:/cart";
        }

        List<CartItem> cartItems = cartService.listCartItems(customer);
        CheckoutInfo checkoutInfo = checkoutService.prepareCheckout(cartItems, shippingRate);

        String currencyCode = settingService.getCurrencyCode();
        PaymentSettingBag paymentSettings = settingService.getPaymentSettings();
        String paypalClientId = paymentSettings.getClientID();

        model.addAttribute("paypalClientId", paypalClientId);
        model.addAttribute("currencyCode", currencyCode);
        model.addAttribute("customer", customer);
        model.addAttribute("checkoutInfo", checkoutInfo);
        model.addAttribute("cartItems", cartItems);

        return "checkout/checkout";
    }

    /*self-code*/
    private Customer getAuthenticatedCustomer(HttpServletRequest request) {
        String email = Utility.getEmailOfAuthenticatedCustomer(request);
        return customerService.getCustomerByEmail(email);
    }

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    @PostMapping("/place_order")
    public String placeOrder(HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        String paymentType = request.getParameter("paymentMethod");
        PaymentMethod paymentMethod = PaymentMethod.valueOf(paymentType);

        Customer customer = getAuthenticatedCustomer(request);

        Address defaultAddress = addressService.getDefaultAddress(customer);
        ShippingRate shippingRate = null;

        if (defaultAddress != null) {
            shippingRate = shipService.getShippingRateForAddress(defaultAddress);
        } else {
            shippingRate = shipService.getShippingRateForCustomer(customer);
        }

        List<CartItem> cartItems = cartService.listCartItems(customer);
        CheckoutInfo checkoutInfo = checkoutService.prepareCheckout(cartItems, shippingRate);

        Order createdOrder = orderService.createOrder(customer, defaultAddress, cartItems, paymentMethod, checkoutInfo);
        cartService.deleteByCustomer(customer);
        sendOrderConfirmationEmail(request, createdOrder);

        return "checkout/order_completed";
    }

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    private void sendOrderConfirmationEmail(HttpServletRequest request, Order order) throws UnsupportedEncodingException, MessagingException {
        EmailSettingBag emailSettings = settingService.getEmailSettings();
        JavaMailSenderImpl mailSender = Utility.prepareMailSender(emailSettings);
        mailSender.setDefaultEncoding("utf-8");

        String toAddress = order.getCustomer().getEmail();
        String subject = emailSettings.getOrderConfirmationSubject();
        String content = emailSettings.getOrderConfirmationContent();

        subject = subject.replace("[[orderId]]", String.valueOf(order.getId()));

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(emailSettings.getFromAddress(), emailSettings.getSenderName());
        helper.setTo(toAddress);
        helper.setSubject(subject);

        DateFormat dateFormatter =  new SimpleDateFormat("HH:mm:ss E, dd MMM yyyy");
        String orderTime = dateFormatter.format(order.getOrderTime());

        CurrencySettingBag currencySettings = settingService.getCurrencySettings();
        String totalAmount = Utility.formatCurrency(order.getTotal(), currencySettings);

        content = content.replace("[[name]]", order.getCustomer().getFullName());
        content = content.replace("[[orderId]]", String.valueOf(order.getId()));
        content = content.replace("[[orderTime]]", orderTime);
        content = content.replace("[[shippingAddress]]", order.getShippingAddress());
        content = content.replace("[[total]]", totalAmount);
        content = content.replace("[[paymentMethod]]", order.getPaymentMethod().toString());

        helper.setText(content, true);
        mailSender.send(message);
    }

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    @PostMapping("/process_paypal_order")
    public String processPayPalOrder(HttpServletRequest request, Model model)
            throws UnsupportedEncodingException, MessagingException {
        String orderId = request.getParameter("orderId");

        String pageTitle = "Checkout Failure";
        String message = null;

        try {
            if (paypalService.validateOrder(orderId)) {
                return placeOrder(request);
            } else {
                pageTitle = "Checkout Failure";
                message = "ERROR: Transaction could not be completed because order information is invalid";
            }
        } catch (PayPalApiException e) {
            message = "ERROR: Transaction failed due to error: " + e.getMessage();
        }

        model.addAttribute("pageTitle", pageTitle);
        model.addAttribute("title", pageTitle);
        model.addAttribute("message", message);

        return "message";
    }

}
