package com.dushop;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dushop.common.entity.CartItem;
import com.dushop.common.entity.Customer;
import com.dushop.common.entity.Product;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.shoppingcart
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-24  21:53
 *@Description: TODO
 *@Version: 1.0
 */

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
    /*self-code*/
    public List<CartItem> findByCustomer(Customer customer);
    /*self-code*/
    public CartItem findByCustomerAndProduct(Customer customer, Product product);

    /*self-code*/
    @Modifying
    @Query("UPDATE CartItem c SET c.quantity = ?1 WHERE c.customer.id = ?2 AND c.product.id = ?3")
    public void updateQuantity(Integer quantity, Integer customerId, Integer productId);

    /*self-code*/
    @Modifying
    @Query("DELETE FROM CartItem c WHERE c.customer.id = ?1 AND c.product.id = ?2")
    public void deleteByCustomerAndProduct(Integer customerId, Integer productId);

    /*self-code*/
    @Modifying
    @Query("DELETE CartItem c WHERE c.customer.id = ?1")
    public void deleteByCustomer(Integer customerId);
}