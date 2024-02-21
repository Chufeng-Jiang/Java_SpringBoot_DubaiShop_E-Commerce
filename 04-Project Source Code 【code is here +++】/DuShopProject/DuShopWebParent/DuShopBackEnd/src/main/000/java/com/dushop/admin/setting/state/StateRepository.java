package com.dushop.admin.setting.state;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dushop.common.entity.Country;
import com.dushop.common.entity.State;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.setting.state
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-14  22:04
 *@Description: TODO
 *@Version: 1.0
 */

public interface StateRepository extends CrudRepository<State, Integer> {

    public List<State> findByCountryOrderByNameAsc(Country country);
}
