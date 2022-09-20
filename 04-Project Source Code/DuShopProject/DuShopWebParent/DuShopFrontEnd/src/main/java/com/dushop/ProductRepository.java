package com.dushop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dushop.common.entity.product.Product;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.product
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-12  23:39
 *@Description: TODO
 *@Version: 1.0
 */

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.enabled = true "
            + "AND (p.category.id = ?1 OR p.category.allParentIDs LIKE %?2%)"
            + " ORDER BY p.name ASC")
    public Page<Product> listByCategory(Integer categoryId, String categoryIDMatch, Pageable pageable);

    public Product findByAlias(String alias);

    @Query(value = "SELECT * FROM products WHERE " +
            "enabled = true AND MATCH(name, short_description, full_description) AGAINST (?1)",
            nativeQuery = true)
    public Page<Product> search(String keyword, Pageable pageable);
}
