package com.dushop;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.shipping
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-28  10:31
 *@Description: TODO
 *@Version: 1.0
 */

import org.springframework.data.repository.CrudRepository;

import com.dushop.common.entity.Country;
import com.dushop.common.entity.ShippingRate;

public interface ShippingRateRepository extends CrudRepository<ShippingRate, Integer> {

    public ShippingRate findByCountryAndState(Country country, String state);
}
