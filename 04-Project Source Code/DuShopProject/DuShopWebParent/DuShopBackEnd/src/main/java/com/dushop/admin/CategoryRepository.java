package com.dushop.admin;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dushop.common.entity.Category;

import java.util.List;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.category
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-07-24  12:54
 *@Description: TODO
 *@Version: 1.0
 */

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.parent.id is NULL")
    public List<Category> findRootCategories(Sort sort);

    @Query("SELECT c FROM Category c WHERE c.parent.id is NULL")
    public Page<Category> findRootCategories(Pageable pageable);

    @Query("SELECT c FROM Category c WHERE c.name LIKE %?1%")
    public Page<Category> search(String keyword, Pageable pageable);


    public Category findByName(String name);

    public Category findByAlias(String alias);

    @Query("UPDATE Category c SET c.enabled = ?2 WHERE c.id = ?1")
    @Modifying
    public void updateEnabledStatus(Integer id, boolean enabled);

    public Long countById(Integer id);

}
