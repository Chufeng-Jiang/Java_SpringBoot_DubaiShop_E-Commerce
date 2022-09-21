package com.dushop.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dushop.admin.SearchRepository;
import com.dushop.common.entity.ShippingRate;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.shippingrate
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-25  17:40
 *@Description: TODO
 *@Version: 1.0
 */

public interface ShippingRateRepository extends SearchRepository<ShippingRate, Integer> {

    /*self-code*/
    @Query("SELECT sr FROM ShippingRate sr WHERE sr.country.id = ?1 AND sr.state = ?2")
    public ShippingRate findByCountryAndState(Integer countryId, String state);

    /*self-code*/
    @Query("UPDATE ShippingRate sr SET sr.codSupported = ?2 WHERE sr.id = ?1")
    @Modifying
    public void updateCODSupport(Integer id, boolean enabled);

    /*self-code*/
    @Query("SELECT sr FROM ShippingRate sr WHERE sr.country.name LIKE %?1% OR sr.state LIKE %?1%")
    public Page<ShippingRate> findAll(String keyword, Pageable pageable);

    public Long countById(Integer id);
}
