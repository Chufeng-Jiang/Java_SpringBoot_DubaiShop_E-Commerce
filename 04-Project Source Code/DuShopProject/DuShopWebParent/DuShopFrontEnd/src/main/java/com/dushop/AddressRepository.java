package com.dushop;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dushop.common.entity.Address;
import com.dushop.common.entity.Customer;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: address
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-27  15:19
 *@Description: TODO
 *@Version: 1.0
 */

public interface AddressRepository extends CrudRepository<Address, Integer> {

    /*self-code*/
    public List<Address> findByCustomer(Customer customer);

    /*self-code*/
    @Query("SELECT a FROM Address a WHERE a.id = ?1 AND a.customer.id = ?2")
    public Address findByIdAndCustomer(Integer addressId, Integer customerId);

    /*self-code*/
    @Query("DELETE FROM Address a WHERE a.id = ?1 AND a.customer.id = ?2")
    @Modifying
    public void deleteByIdAndCustomer(Integer addressId, Integer customerId);

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    @Query("UPDATE Address a SET a.defaultForShipping = true WHERE a.id = ?1")
    @Modifying
    public void setDefaultAddress(Integer id);

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    @Query("UPDATE Address a SET a.defaultForShipping = false "
            + "WHERE a.id != ?1 AND a.customer.id = ?2")
    @Modifying
    public void setNonDefaultForOthers(Integer defaultAddressId, Integer customerId);

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    @Query("SELECT a FROM Address a WHERE a.customer.id = ?1 AND a.defaultForShipping = true")
    public Address findDefaultByCustomer(Integer customerId);
}