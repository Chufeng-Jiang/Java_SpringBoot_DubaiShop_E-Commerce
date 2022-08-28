package com.dushop.setting;
import java.util.List;

import com.dushop.common.entity.setting.Setting;
import com.dushop.common.entity.setting.SettingBag;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.setting
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-28  21:11
 *@Description: TODO
 *@Version: 1.0
 */

public class CurrencySettingBag extends SettingBag {

    public CurrencySettingBag(List<Setting> listSettings) {
        super(listSettings);
    }

    public String getSymbol() {
        return super.getValue("CURRENCY_SYMBOL");
    }

    public String getSymbolPosition() {
        return super.getValue("CURRENCY_SYMBOL_POSITION");
    }

    public String getDecimalPointType() {
        return super.getValue("DECIMAL_POINT_TYPE");
    }

    public String getThousandPointType() {
        return super.getValue("THOUSANDS_POINT_TYPE");
    }

    public int getDecimalDigits() {
        return Integer.parseInt(super.getValue("DECIMAL_DIGITS"));
    }
}