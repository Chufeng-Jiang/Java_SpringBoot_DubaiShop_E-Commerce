package com.dushop.admin;

import com.dushop.common.entity.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import com.dushop.admin.setting.country.CountryRepository;
import com.dushop.common.entity.Country;
import java.util.NoSuchElementException;
import com.dushop.common.entity.Order;
import java.util.Date;
import com.dushop.common.entity.OrderStatus;
import com.dushop.common.entity.OrderTrack;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.order
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-27  17:11
 *@Description: TODO
 *@Version: 1.0
 */

@Service
public class OrderService {
    private static final int ORDERS_PER_PAGE = 10;

    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private CountryRepository countryRepo;

    /***************************************************************************************
     *    Title: mediCare
     *    Author: Bhardwaj-Abh
     *    Availability: https://github.com/Bhardwaj-Abh/medi/blob/32f56a6712eec42f688d93b1de83de0efb96f702/MediCareCommon/src/main/java/com/medicare
     ***************************************************************************************/
    public void listByPage(int pageNum, PagingAndSortingHelper helper) {
        String sortField = helper.getSortField();
        String sortDir = helper.getSortDir();
        String keyword = helper.getKeyword();

        Sort sort = null;

        if ("destination".equals(sortField)) {
            sort = Sort.by("country").and(Sort.by("state")).and(Sort.by("city"));
        } else {
            sort = Sort.by(sortField);
        }

        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNum - 1, ORDERS_PER_PAGE, sort);

        Page<Order> page = null;

        if (keyword != null) {
            page = orderRepo.findAll(keyword, pageable);
        } else {
            page = orderRepo.findAll(pageable);
        }

        helper.updateModelAttributes(pageNum, page);
    }

    /*self-code, but adapted from user module*/
    public Order get(Integer id) throws OrderNotFoundException {
        try {
            return orderRepo.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new OrderNotFoundException("Could not find ID " + id);
        }
    }

    /*self-code, but adapted from user module*/
    public void delete(Integer id) throws OrderNotFoundException {
        Long count = orderRepo.countById(id);
        if (count == null || count == 0) {
            throw new OrderNotFoundException("Could not find any orders " + id);
        }

        orderRepo.deleteById(id);
    }
    public List<Country> listAllCountries() {
        return countryRepo.findAllByOrderByNameAsc();
    }

    /*self-code, but adapted from user module*/
    public void save(Order orderInForm) {
        Order orderInDB = orderRepo.findById(orderInForm.getId()).get();
        orderInForm.setOrderTime(orderInDB.getOrderTime());
        orderInForm.setCustomer(orderInDB.getCustomer());
        orderRepo.save(orderInForm);
    }

    /***************************************************************************************
     *    Title: mediCare
     *    Author: Bhardwaj-Abh
     *    Availability: https://github.com/Bhardwaj-Abh/medi/blob/32f56a6712eec42f688d93b1de83de0efb96f702/MediCareCommon/src/main/java/com/medicare
     ***************************************************************************************/
    public void updateStatus(Integer orderId, String status) {
        Order orderInDB = orderRepo.findById(orderId).get();
        OrderStatus statusToUpdate = OrderStatus.valueOf(status);

        if (!orderInDB.hasStatus(statusToUpdate)) {
            List<OrderTrack> orderTracks = orderInDB.getOrderTracks();
            OrderTrack track = new OrderTrack();
            track.setOrder(orderInDB);
            track.setStatus(statusToUpdate);
            track.setUpdatedTime(new Date());
            track.setNotes(statusToUpdate.defaultDescription());
            orderTracks.add(track);
            orderInDB.setStatus(statusToUpdate);
            orderRepo.save(orderInDB);
        }

    }
}