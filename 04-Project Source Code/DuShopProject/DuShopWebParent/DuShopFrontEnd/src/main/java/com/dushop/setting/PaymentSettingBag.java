package com.dushop.setting;
import java.util.List;

import com.dushop.common.entity.setting.Setting;
import com.dushop.common.entity.setting.SettingBag;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.shipping
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-28  22:09
 *@Description: TODO
 *@Version: 1.0
 */

public class PaymentSettingBag extends SettingBag {

    public PaymentSettingBag(List<Setting> listSettings) {
        super(listSettings);
    }

    public String getURL() {
        return super.getValue("PAYPAL_API_BASE_URL");
    }

    public String getClientID() {
        return super.getValue("PAYPAL_API_CLIENT_ID");
    }

    public String getClientSecret() {
        return super.getValue("PAYPAL_API_CLIENT_SECRET");
    }
}