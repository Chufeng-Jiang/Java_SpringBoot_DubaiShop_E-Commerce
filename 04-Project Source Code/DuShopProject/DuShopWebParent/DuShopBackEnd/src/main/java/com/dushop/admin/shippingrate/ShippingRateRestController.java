package com.dushop.admin.shippingrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.shippingrate
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-29  23:33
 *@Description: TODO
 *@Version: 1.0
 */

@RestController
public class ShippingRateRestController {

    @Autowired private ShippingRateService service;

    @PostMapping("/get_shipping_cost")
    public String getShippingCost(Integer productId, Integer countryId, String state)
            throws ShippingRateNotFoundException {
        float shippingCost = service.calculateShippingCost(productId, countryId, state);
        return String.valueOf(shippingCost);
    }
}