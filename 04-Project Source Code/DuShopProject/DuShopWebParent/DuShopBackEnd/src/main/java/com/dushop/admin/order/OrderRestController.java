package com.dushop.admin.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.order
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-30  15:56
 *@Description: TODO
 *@Version: 1.0
 */

@RestController
public class OrderRestController {

    @Autowired
    private OrderService service;

    @PostMapping("/orders_shipper/update/{id}/{status}")
    public Response updateOrderStatus(@PathVariable("id") Integer orderId, @PathVariable("status") String status) {
        service.updateStatus(orderId, status);
        return new Response(orderId, status);
    }
}

class Response {
    private Integer orderId;
    private String status;

    public Response(Integer orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}