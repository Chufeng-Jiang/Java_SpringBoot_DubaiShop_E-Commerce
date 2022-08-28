package com.dushop.order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dushop.common.entity.order.Order;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.order
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-27  16:46
 *@Description: TODO
 *@Version: 1.0
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

}