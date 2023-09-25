package com.dushop.common.entity.dubaishop_order;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.common.entity
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-26  11:46
 *@Description: TODO
 *@Version: 1.0
 */

public enum OrderStatus {
    NEW, CANCELLED, PROCESSING, PACKAGED, PICKED, SHIPPING,
    DELIVERED, RETURNED, PAID, REFUNDED
}