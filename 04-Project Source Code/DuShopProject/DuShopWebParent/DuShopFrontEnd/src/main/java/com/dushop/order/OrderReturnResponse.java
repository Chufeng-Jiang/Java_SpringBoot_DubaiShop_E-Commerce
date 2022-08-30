package com.dushop.order;
import com.dushop.common.entity.order.OrderTrack;
import com.dushop.common.exception.OrderNotFoundException;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.order
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-30  20:46
 *@Description: TODO
 *@Version: 1.0
 */

public class OrderReturnResponse {
    private Integer orderId;

    public OrderReturnResponse() { }

    public OrderReturnResponse(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}