package com.dushop.order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dushop.common.entity.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.dushop.common.entity.Customer;
import org.springframework.data.jpa.repository.Query;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.order
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-27  16:46
 *@Description: TODO
 *@Version: 1.0
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT DISTINCT o FROM Order o JOIN o.orderDetails od JOIN od.product p "
            + "WHERE o.customer.id = ?2 "
            + "AND (p.name LIKE %?1% OR o.status LIKE %?1%)")
    public Page<Order> findAll(String keyword, Integer customerId, Pageable pageable);

    @Query("SELECT o FROM Order o WHERE o.customer.id = ?1")
    public Page<Order> findAll(Integer customerId, Pageable pageable);

    public Order findByIdAndCustomer(Integer id, Customer customer);
}