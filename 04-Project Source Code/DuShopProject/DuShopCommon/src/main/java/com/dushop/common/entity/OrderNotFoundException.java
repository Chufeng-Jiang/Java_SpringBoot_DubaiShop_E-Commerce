package com.dushop.common.entity;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.order
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-27  17:51
 *@Description: TODO
 *@Version: 1.0
 */

public class OrderNotFoundException extends Exception {
    /*self-finish*/
    public OrderNotFoundException(String message) {
        super(message);
    }

}