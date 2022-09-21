package com.dushop.admin.setting;

import java.util.List;

import com.dushop.common.entity.Setting;
import com.dushop.common.entity.SettingBag;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.setting
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-13  19:35
 *@Description: TODO
 *@Version: 1.0
 */

public class GeneralSettingBag extends SettingBag {

    public GeneralSettingBag(List<Setting> listSettings) {
        super(listSettings);
    }

    public void updateCurrencySymbol(String value) {
        super.update("CURRENCY_SYMBOL", value);
    }

    public void updateSiteLogo(String value) {
        super.update("SITE_LOGO", value);
    }
}