package com.dushop.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.dushop.common.entity.Customer;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.customer
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-17  20:30
 *@Description: TODO
 *@Version: 1.0
 */

public interface CustomerRepository extends SearchRepository<Customer, Integer> {

    /*self-code, but adapted from user module*/
    @Query("SELECT c FROM Customer c WHERE CONCAT(c.email, ' ', c.firstName, ' ', c.lastName, ' ', c.addressLine1, ' ', c.addressLine2, ' ', c.city, ' ', c.state, "
            + "' ', c.postalCode, ' ', c.country.name) LIKE %?1%")
    public Page<Customer> findAll(String keyword, Pageable pageable);

    /*self-code, but adapted from user module*/
    @Query("UPDATE Customer c SET c.enabled = ?2 WHERE c.id = ?1")
    @Modifying
    public void updateEnabledStatus(Integer id, boolean enabled);

    /*self-code, but adapted from user module*/
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    public Customer findByEmail(String email);

    /*self-code, but adapted from user module*/
    public Long countById(Integer id);
}