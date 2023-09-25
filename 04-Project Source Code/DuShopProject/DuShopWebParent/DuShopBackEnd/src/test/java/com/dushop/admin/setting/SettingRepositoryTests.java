package com.dushop.admin.setting;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.dushop.common.entity.setting.Setting;
import com.dushop.common.entity.setting.SettingCategory;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-13  19:20
 *@Description: TODO
 *@Version: 1.0
 */


    @DataJpaTest
    @AutoConfigureTestDatabase(replace = Replace.NONE)
    @Rollback(false)
    public class SettingRepositoryTests {

        @Autowired
        SettingRepository repo;

        @Test
        public void testCreateGeneralSettings() {
            Setting siteName = new Setting("SITE_NAME", "DuShop", SettingCategory.GENERAL);
            Setting siteLogo = new Setting("SITE_LOGO", "DuShop.png", SettingCategory.GENERAL);
            Setting copyright = new Setting("COPYRIGHT", "Copyright (C) 2022 DuShop Ltd.", SettingCategory.GENERAL);

            repo.saveAll(List.of(siteName, siteLogo, copyright));

            Iterable<Setting> iterable = repo.findAll();

            assertThat(iterable).size().isGreaterThan(0);
        }

        @Test
        public void testCreateCurrencySettings() {
            Setting currencyId = new Setting("CURRENCY_ID", "1", SettingCategory.CURRENCY);
            Setting symbol = new Setting("CURRENCY_SYMBOL", "$", SettingCategory.CURRENCY);
            Setting symbolPosition = new Setting("CURRENCY_SYMBOL_POSITION", "before", SettingCategory.CURRENCY);
            Setting decimalPointType = new Setting("DECIMAL_POINT_TYPE", "POINT", SettingCategory.CURRENCY);
            Setting decimalDigits = new Setting("DECIMAL_DIGITS", "2", SettingCategory.CURRENCY);
            Setting thousandsPointType = new Setting("THOUSANDS_POINT_TYPE", "COMMA", SettingCategory.CURRENCY);

            repo.saveAll(List.of(currencyId, symbol, symbolPosition, decimalPointType,
                    decimalDigits, thousandsPointType));

        }

        @Test
        public void testListSettingsByCategory() {
            List<Setting> settings = repo.findByCategory(SettingCategory.GENERAL);

            settings.forEach(System.out::println);
        }
    }