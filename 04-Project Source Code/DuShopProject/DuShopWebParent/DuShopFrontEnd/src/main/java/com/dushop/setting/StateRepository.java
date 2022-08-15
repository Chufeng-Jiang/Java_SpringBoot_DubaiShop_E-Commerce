package com.dushop.setting;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dushop.common.entity.Country;
import com.dushop.common.entity.State;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.setting
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-15  20:03
 *@Description: TODO
 *@Version: 1.0
 */

public interface StateRepository extends CrudRepository<State, Integer> {
    public List<State> findByCountryOrderByNameAsc(Country country);
}