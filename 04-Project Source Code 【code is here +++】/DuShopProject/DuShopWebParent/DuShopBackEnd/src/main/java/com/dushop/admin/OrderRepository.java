package com.dushop.admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import java.util.Date;
import java.util.List;

import com.dushop.common.entity.Order;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.order
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-27  16:46
 *@Description: TODO
 *@Version: 1.0
 */

public interface OrderRepository extends SearchRepository<Order, Integer> {
    /***************************************************************************************
     *    Title: mediCare
     *    Author: Bhardwaj-Abh
     *    Availability: https://github.com/Bhardwaj-Abh/medi/blob/32f56a6712eec42f688d93b1de83de0efb96f702/MediCareCommon/src/main/java/com/medicare
     ***************************************************************************************/
    @Query("SELECT o FROM Order o WHERE CONCAT('#', o.id) LIKE %?1% OR  CONCAT(o.firstName, ' ', o.lastName) LIKE %?1% OR"
            + " o.firstName LIKE %?1% OR o.lastName LIKE %?1% OR o.phoneNumber LIKE %?1% OR  o.addressLine1 LIKE %?1% OR o.addressLine2 LIKE %?1% OR"
            + " o.postalCode LIKE %?1% OR o.city LIKE %?1% OR  o.state LIKE %?1% OR o.country LIKE %?1% OR"
            + " o.paymentMethod LIKE %?1% OR o.status LIKE %?1% OR o.customer.firstName LIKE %?1% OR o.customer.lastName LIKE %?1%")
    public Page<Order> findAll(String keyword, Pageable pageable);

    public Long countById(Integer id);
    /***************************************************************************************
     *    Title: mediCare
     *    Author: Bhardwaj-Abh
     *    Availability: https://github.com/Bhardwaj-Abh/medi/blob/32f56a6712eec42f688d93b1de83de0efb96f702/MediCareCommon/src/main/java/com/medicare
     ***************************************************************************************/
    @Query("SELECT NEW com.dushop.common.entity.Order(o.id, o.orderTime, o.productCost, o.subtotal, o.total) FROM Order o WHERE"
            + " o.orderTime BETWEEN ?1 AND ?2 ORDER BY o.orderTime ASC")
    public List<Order> findByOrderTimeBetween(Date startTime, Date endTime);
}