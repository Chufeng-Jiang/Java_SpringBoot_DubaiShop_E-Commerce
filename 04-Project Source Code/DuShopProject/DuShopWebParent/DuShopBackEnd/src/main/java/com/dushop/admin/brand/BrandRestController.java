package com.dushop.admin.brand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.brand
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-05  09:29
 *@Description: TODO
 *@Version: 1.0
 */

@RestController
public class BrandRestController {
    @Autowired
    private BrandService service;

    @PostMapping("/brands/check_unique")
    public String checkUnique(@Param("id") Integer id, @Param("name") String name) {
        return service.checkUnique(id, name);
    }
}