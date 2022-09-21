package com.dushop.paypal;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.checkout.paypal
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-28  22:57
 *@Description: TODO
 *@Version: 1.0
 */

public class PayPalOrderResponse {
    private String id;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean validate(String orderId) {
        return id.equals(orderId) && status.equals("COMPLETED");
    }

}