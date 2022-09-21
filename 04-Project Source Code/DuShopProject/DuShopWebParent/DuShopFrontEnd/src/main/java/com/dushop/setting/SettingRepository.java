package com.dushop.setting;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dushop.common.entity.Setting;
import com.dushop.common.entity.SettingCategory;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.setting
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-13  20:22
 *@Description: TODO
 *@Version: 1.0
 */

public interface SettingRepository extends CrudRepository<Setting, String> {
    public List<Setting> findByCategory(SettingCategory category);

    @Query("SELECT s FROM Setting s WHERE s.category = ?1 OR s.category = ?2")
    public List<Setting> findByTwoCategories(SettingCategory catOne, SettingCategory catTwo);

    public Setting findByKey(String key);
}
