package com.dushop.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.customer
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-15  19:59
 *@Description: TODO
 *@Version: 1.0
 */

@RestController
public class CustomerRestController {

    @Autowired private CustomerService service;

    @PostMapping("/customers/check_unique_email")
    public String checkDuplicateEmail(String email) {
        return service.isEmailUnique(email) ? "OK" : "Duplicated";
    }
}