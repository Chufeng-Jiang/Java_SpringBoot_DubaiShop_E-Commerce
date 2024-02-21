package com.dushop.admin;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String checkDuplicateEmail(Integer id, String email) {
        if (service.isEmailUnique(id, email)) {
            return "OK";
        } else {
            return "Duplicated";
        }
    }
}