package com.dushop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dushop.common.entity.CategoryNotFoundException;
import com.dushop.common.entity.Category;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.category
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-12  22:15
 *@Description: TODO
 *@Version: 1.0
 */

@Service
public class CategoryService {

    @Autowired private CategoryRepository repo;

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    public List<Category> listNoChildrenCategories() {
        List<Category> listNoChildrenCategories = new ArrayList<>();

        List<Category> listEnabledCategories = repo.findAllEnabled();

        listEnabledCategories.forEach(category -> {
            Set<Category> children = category.getChildren();
            if (children == null || children.size() == 0) {
                listNoChildrenCategories.add(category);
            }
        });

        return listNoChildrenCategories;
    }

    /*self-code*/
    public Category getCategory(String alias) throws CategoryNotFoundException {
        Category category = repo.findByAliasEnabled(alias);
        if (category == null) {
            throw new CategoryNotFoundException("Could not find alias " + alias);
        }
        return category;
    }

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    public List<Category> getCategoryParents(Category child) {
        List<Category> listParents = new ArrayList<>();

        Category parent = child.getParent();

        while (parent != null) {
            listParents.add(0, parent);
            parent = parent.getParent();
        }

        listParents.add(child);

        return listParents;
    }

}