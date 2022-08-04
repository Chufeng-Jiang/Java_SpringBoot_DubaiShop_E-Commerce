package com.dushop.admin.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dushop.common.entity.Brand;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.brand
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-04  19:04
 *@Description: TODO
 *@Version: 1.0
 */

@Controller
public class BrandController {

    @Autowired
    private BrandService service;

    @GetMapping("/brands")
    public String listAll(Model model) {
        List<Brand> listBrands = service.listAll();
        model.addAttribute("listBrands", listBrands);

        return "brands/brands";
    }
}
