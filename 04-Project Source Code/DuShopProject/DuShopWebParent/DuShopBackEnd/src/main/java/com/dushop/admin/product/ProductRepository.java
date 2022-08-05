package com.dushop.admin.product;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dushop.common.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

}