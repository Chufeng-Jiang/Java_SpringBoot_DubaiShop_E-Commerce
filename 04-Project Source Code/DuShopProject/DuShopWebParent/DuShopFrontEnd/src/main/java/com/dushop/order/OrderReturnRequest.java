package com.dushop.order;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.order
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-30  20:46
 *@Description: TODO
 *@Version: 1.0
 */

public class OrderReturnRequest {
    private Integer orderId;
    private String reason;
    private String note;

    public OrderReturnRequest() {
    }

    public OrderReturnRequest(Integer orderId, String reason, String note) {
        this.orderId = orderId;
        this.reason = reason;
        this.note = note;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}