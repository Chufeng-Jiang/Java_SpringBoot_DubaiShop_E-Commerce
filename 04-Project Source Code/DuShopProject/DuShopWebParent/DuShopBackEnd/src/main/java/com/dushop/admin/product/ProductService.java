package com.dushop.admin.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dushop.common.entity.Product;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.product
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-05  17:00
 *@Description: TODO
 *@Version: 1.0
 */

@Service
public class ProductService {

    @Autowired private ProductRepository repo;

    public List<Product> listAll() {
        return (List<Product>) repo.findAll();
    }
}
