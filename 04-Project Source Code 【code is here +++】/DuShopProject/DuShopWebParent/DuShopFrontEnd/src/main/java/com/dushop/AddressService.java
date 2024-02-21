package com.dushop;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dushop.common.entity.Address;
import com.dushop.common.entity.Customer;
import javax.transaction.Transactional;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: address
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-27  15:25
 *@Description: TODO
 *@Version: 1.0
 */

@Service
@Transactional
public class AddressService {

    @Autowired private AddressRepository repo;
    /*self-code*/
    public List<Address> listAddressBook(Customer customer) {
        return repo.findByCustomer(customer);
    }
    /*self-code*/
    public void save(Address address) {
        repo.save(address);
    }
    /*self-code*/
    public Address get(Integer addressId, Integer customerId) {
        return repo.findByIdAndCustomer(addressId, customerId);
    }
    /*self-code*/
    public void delete(Integer addressId, Integer customerId) {
        repo.deleteByIdAndCustomer(addressId, customerId);
    }

    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    public void setDefaultAddress(Integer defaultAddressId, Integer customerId) {
        if (defaultAddressId > 0) {
            repo.setDefaultAddress(defaultAddressId);
        }

        repo.setNonDefaultForOthers(defaultAddressId, customerId);
    }
    /************************************
     @Author: Jay Gajera
     “Spring E commerce project | With Code| Run step by step execution” [online]
     Available at: https://youtu.be/c6WWdINWSlI
     ************************************/
    public Address getDefaultAddress(Customer customer) {
        return repo.findDefaultByCustomer(customer.getId());
    }
}
