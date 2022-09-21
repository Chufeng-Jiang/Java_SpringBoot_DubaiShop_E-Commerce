package com.dushop.admin;

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
    /*self-finish*/
    public static final int BRANDS_PER_PAGE = 10;
    /*self-finish*/
    @Autowired
    private BrandRepository repo;

    /*self-finish*/
    public List<Brand> listAll() {
        return (List<Brand>) repo.findAll();
    }

    /*
@Author: Self-code.
“Ecommerce Spring Boot Project step-by-step using Spring Boot, Thymeleaf, Spring Security, Hibernate, Spring Data Jpa, Lombok.” [online]
Available at: https://youtu.be/4ga5bcBPgzo
*/
    public void listByPage(int pageNum, PagingAndSortingHelper helper) {
        helper.listEntities(pageNum, BRANDS_PER_PAGE, repo);
    }

    /*self-finish*/
    public Brand save(Brand brand) {
        return repo.save(brand);
    }

    /*self-finish*/
    public Brand get(Integer id) throws BrandNotFoundException {
        try {
            return repo.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new BrandNotFoundException("Could not find any brand with ID " + id);
        }
    }

    /*self-finish*/
    public void delete(Integer id) throws BrandNotFoundException {
        Long countById = repo.countById(id);
        if (countById == null || countById == 0) {
            throw new BrandNotFoundException("Could not find any brand with ID " + id);
        }
        repo.deleteById(id);
    }

    /***************************************************************************************
     *    Title: mediCare
     *    Author: Bhardwaj-Abh
     *    Availability: https://github.com/Bhardwaj-Abh/medi/blob/32f56a6712eec42f688d93b1de83de0efb96f702/MediCareCommon/src/main/java/com/medicare
     ***************************************************************************************/
    public String checkUnique(Integer id, String name) {
        boolean isCreatingNew = (id == null || id == 0);
        Brand brandByName = repo.findByName(name);
        if (isCreatingNew) {
            if (brandByName != null) return "Duplicate";
        } else {
            if (brandByName != null && brandByName.getId() != id) {
                return "Duplicate";
            }
        }
        return "OK";
    }
}