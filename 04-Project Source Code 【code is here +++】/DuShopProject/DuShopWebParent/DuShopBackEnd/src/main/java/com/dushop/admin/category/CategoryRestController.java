package com.dushop.admin.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.category
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-07-27  23:58
 *@Description: TODO
 *@Version: 1.0
 */

@RestController
public class CategoryRestController {

    @Autowired
    private CategoryService service;

    @PostMapping("/categories/check_unique")
    public String checkUnique(@Param("id") Integer id, @Param("name") String name,
                              @Param("alias") String alias) {
        return service.checkUnique(id, name, alias);
    }
}