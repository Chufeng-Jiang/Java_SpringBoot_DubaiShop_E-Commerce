package com.dushop.setting;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import com.dushop.common.entity.Country;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.setting
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-15  20:01
 *@Description: TODO
 *@Version: 1.0
 */

public interface CountryRepository extends CrudRepository<Country, Integer> {
    public List<Country> findAllByOrderByNameAsc();

    @Query("SELECT c FROM Country c WHERE c.code = ?1")
    public Country findByCode(String code);

}
