package com.dushop.address;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dushop.common.entity.Address;
import com.dushop.common.entity.Customer;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: address
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-27  15:25
 *@Description: TODO
 *@Version: 1.0
 */

@Service
public class AddressService {

    @Autowired private AddressRepository repo;

    public List<Address> listAddressBook(Customer customer) {
        return repo.findByCustomer(customer);
    }

}
