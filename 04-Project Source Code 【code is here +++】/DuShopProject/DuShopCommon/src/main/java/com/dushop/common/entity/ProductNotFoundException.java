package com.dushop.common.entity;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.product
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-06  19:32
 *@Description: TODO
 *@Version: 1.0
 */

public class ProductNotFoundException extends Exception {
    /*self-finish*/
    public ProductNotFoundException(String message) {
        super(message);
    }
}