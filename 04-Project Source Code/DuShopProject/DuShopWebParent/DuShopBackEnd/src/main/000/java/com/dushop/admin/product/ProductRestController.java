package com.dushop.admin.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.product
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-05  23:46
 *@Description: TODO
 *@Version: 1.0
 */

@RestController
public class ProductRestController {

    @Autowired private ProductService service;

    @PostMapping("/products/check_unique")
    public String checkUnique(Integer id, String name) {
        return service.checkUnique(id, name);
    }
}
