package com.dushop.admin.shippingrate;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.shippingrate
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-25  17:37
 *@Description: TODO
 *@Version: 1.0
 */

public class ShippingRateAlreadyExistsException extends Exception {

    public ShippingRateAlreadyExistsException(String message) {
        super(message);
    }

}