package com.dushop.admin.category;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dushop.common.entity.Category;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.category
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-07-24  12:54
 *@Description: TODO
 *@Version: 1.0
 */

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {

}
