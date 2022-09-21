package com.dushop.common.entity;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.common.exception
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-17  20:26
 *@Description: TODO
 *@Version: 1.0
 */

public class CustomerNotFoundException extends Exception {
    /*self-finish*/
    public CustomerNotFoundException(String message) {
        super(message);
    }
}