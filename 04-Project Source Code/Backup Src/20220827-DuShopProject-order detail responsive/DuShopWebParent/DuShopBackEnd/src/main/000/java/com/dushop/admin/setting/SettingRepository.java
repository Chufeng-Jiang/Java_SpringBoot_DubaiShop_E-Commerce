package com.dushop.admin.setting;

import com.dushop.common.entity.dubaishop_setting.SettingCategory;
import org.springframework.data.repository.CrudRepository;

import com.dushop.common.entity.dubaishop_setting.Setting;

import java.util.List;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.setting
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-13  19:19
 *@Description: TODO
 *@Version: 1.0
 */

public interface SettingRepository extends CrudRepository<Setting, String> {
    public List<Setting> findByCategory(SettingCategory category);
}