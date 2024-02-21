package com.dushop.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.dushop.common.entity.Brand;
import com.dushop.common.entity.Category;

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

    /*self-finish*/
    @Autowired
    private BrandService service;

    /*self-finish*/
    @PostMapping("/brands/check_unique")
    public String checkUnique(Integer id, String name) {
        return service.checkUnique(id, name);
    }

    /***************************************************************************************
     *    Title: mediCare
     *    Author: Bhardwaj-Abh
     *    Availability: https://github.com/Bhardwaj-Abh/medi/blob/32f56a6712eec42f688d93b1de83de0efb96f702/MediCareCommon/src/main/java/com/medicare
     ***************************************************************************************/
    @GetMapping("/brands/{id}/categories")
    public List<CategoryDTO> listCategoriesByBrand(@PathVariable(name = "id") Integer brandId) throws BrandNotFoundRestException {
        List<CategoryDTO> listCategories = new ArrayList<>();

        try {
            Brand brand = service.get(brandId);
            Set<Category> categories = brand.getCategories();

            for (Category category : categories) {
                CategoryDTO dto = new CategoryDTO(category.getId(), category.getName());
                listCategories.add(dto);
            }

            return listCategories;
        } catch (BrandNotFoundException e) {
            throw new BrandNotFoundRestException();
        }
    }
}