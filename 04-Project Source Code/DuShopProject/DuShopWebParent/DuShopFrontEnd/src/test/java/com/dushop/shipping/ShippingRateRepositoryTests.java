package com.dushop.shipping;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.shipping
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-28  10:38
 *@Description: TODO
 *@Version: 1.0
 */

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.dushop.common.entity.Country;
import com.dushop.common.entity.ShippingRate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ShippingRateRepositoryTests {

    @Autowired private ShippingRateRepository repo;

    @Test
    public void testFindByCountryAndState() {
        Country uae = new Country(8);
        String state = "Dubai";
        ShippingRate shippingRate = repo.findByCountryAndState(uae, state);

        assertThat(shippingRate).isNotNull();
        System.out.println(shippingRate);
    }
}