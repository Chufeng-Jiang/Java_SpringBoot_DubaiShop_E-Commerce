package com.dushop.admin.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dushop.common.entity.Category;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.category
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-07-24  13:34
 *@Description: TODO
 *@Version: 1.0
 */

@Controller
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public String listAll(Model model) {
        List<Category> listCategories = service.listAll();
        model.addAttribute("listCategories", listCategories);

        return "categories/categories";
    }
}
