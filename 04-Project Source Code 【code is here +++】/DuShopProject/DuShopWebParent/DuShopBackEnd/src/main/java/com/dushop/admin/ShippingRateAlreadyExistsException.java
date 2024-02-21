package com.dushop.admin;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.shippingrate
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-25  17:37
 *@Description: TODO
 *@Version: 1.0
 */

public class ShippingRateAlreadyExistsException extends Exception {

    /************************************
     @Author:  The Sheryians Coding School
     ““E-Commerce Project in Spring Boot & Thymeleaf Playlist”[online]
     Available at: https://youtu.be/z-9lNgN2QV4
     ************************************/
    public ShippingRateAlreadyExistsException(String message) {
        super(message);
    }

}