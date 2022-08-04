package com.dushop.admin.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

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

    public Brand save(Brand brand) {
        return repo.save(brand);
    }

    public Brand get(Integer id) throws BrandNotFoundException {
        try {
            return repo.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new BrandNotFoundException("Could not find any brand with ID " + id);
        }
    }

    public void delete(Integer id) throws BrandNotFoundException {
        Long countById = repo.countById(id);

        if (countById == null || countById == 0) {
            throw new BrandNotFoundException("Could not find any brand with ID " + id);
        }

        repo.deleteById(id);
    }

}