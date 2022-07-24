package com.dushop.admin.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dushop.common.entity.Category;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.category
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-07-24  13:35
 *@Description: TODO
 *@Version: 1.0
 */

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repo;

    public List<Category> listAll() {
        return (List<Category>) repo.findAll();
    }

    /*
     * @description: Resuse from test
     * @author: Jiang Chufeng
     * @date: 2022/7/24 15:01
     * @param:
     * @return: java.util.List<com.dushop.common.entity.Category>
     */
    public List<Category> listCategoriesUsedInForm() {
        List<Category> categoriesUsedInForm = new ArrayList<>();

        Iterable<Category> categoriesInDB = repo.findAll();

        for (Category category : categoriesInDB) {
            if (category.getParent() == null) {
                categoriesUsedInForm.add(new Category(category.getName()));

                Set<Category> children = category.getChildren();

                for (Category subCategory : children) {
                    String name = "--" + subCategory.getName();
                    categoriesUsedInForm.add(new Category(name));

                    listChildren(categoriesUsedInForm, subCategory, 1);
                }
            }
        }

        return categoriesUsedInForm;
    }

    private void listChildren(List<Category> categoriesUsedInForm, Category parent, int subLevel) {
        int newSubLevel = subLevel + 1;
        Set<Category> children = parent.getChildren();

        for (Category subCategory : children) {
            String name = "";
            for (int i = 0; i < newSubLevel; i++) {
                name += "--";
            }
            name += subCategory.getName();

            categoriesUsedInForm.add(new Category(name));

            listChildren(categoriesUsedInForm, subCategory, newSubLevel);
        }
    }

}
