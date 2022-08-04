package com.dushop.admin.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dushop.common.entity.Brand;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.brand
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-04  19:05
 *@Description: TODO
 *@Version: 1.0
 */

@Service
public class BrandService {
    @Autowired
    private BrandRepository repo;

    public List<Brand> listAll() {
        return (List<Brand>) repo.findAll();
    }
}