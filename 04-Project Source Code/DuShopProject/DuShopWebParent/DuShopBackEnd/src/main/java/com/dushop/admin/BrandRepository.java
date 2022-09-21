package com.dushop.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.dushop.common.entity.Brand;

import java.util.List;

public interface BrandRepository extends SearchRepository<Brand, Integer> {
    /*self-finish*/
    public Long countById(Integer id);

    /*self-finish*/
    public Brand findByName(String name);
    /*self-finish*/
    @Query("SELECT b FROM Brand b WHERE b.name LIKE %?1%")
    public Page<Brand> findAll(String keyword, Pageable pageable);

    /*self-finish*/
    @Query("SELECT NEW Brand(b.id, b.name) FROM Brand b ORDER BY b.name ASC")
    public List<Brand> findAll();
}
