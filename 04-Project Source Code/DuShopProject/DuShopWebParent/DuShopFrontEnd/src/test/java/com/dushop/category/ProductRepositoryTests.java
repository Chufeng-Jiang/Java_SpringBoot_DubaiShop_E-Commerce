package com.dushop.category;

import static org.assertj.core.api.Assertions.assertThat;
import com.dushop.common.entity.dubaishop_product.Product;

import com.dushop.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.category
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-13  12:59
 *@Description: TODO
 *@Version: 1.0
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRepositoryTests {

    @Autowired
    ProductRepository repo;

    @Test
    public void testFindByAlias() {
        String alias = "canon-eos-m50";
        Product product = repo.findByAlias(alias);

        assertThat(product).isNotNull();
    }
}