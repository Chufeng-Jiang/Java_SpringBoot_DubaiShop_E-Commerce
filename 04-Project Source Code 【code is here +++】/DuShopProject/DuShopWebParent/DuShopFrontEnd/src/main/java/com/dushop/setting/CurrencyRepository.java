package com.dushop.setting;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.shipping
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-28  22:08
 *@Description: TODO
 *@Version: 1.0
 */

import org.springframework.data.repository.CrudRepository;

import com.dushop.common.entity.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

}
