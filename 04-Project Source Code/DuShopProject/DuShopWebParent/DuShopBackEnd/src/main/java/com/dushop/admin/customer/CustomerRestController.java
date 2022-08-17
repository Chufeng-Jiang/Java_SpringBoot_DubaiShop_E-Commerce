package com.dushop.admin.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.customer
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-17  20:38
 *@Description: TODO
 *@Version: 1.0
 */

@RestController
public class CustomerRestController {
    @Autowired
    private CustomerService service;

    @PostMapping("/customers/check_email")
    public String checkDuplicateEmail(@Param("id") Integer id, @Param("email") String email) {
        if (service.isEmailUnique(id, email)) {
            return "OK";
        } else {
            return "Duplicated";
        }
    }
}