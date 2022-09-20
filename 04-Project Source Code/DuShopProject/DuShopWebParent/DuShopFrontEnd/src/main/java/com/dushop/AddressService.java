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

    public List<Address> listAddressBook(Customer customer) {
        return repo.findByCustomer(customer);
    }

    public void save(Address address) {
        repo.save(address);
    }

    public Address get(Integer addressId, Integer customerId) {
        return repo.findByIdAndCustomer(addressId, customerId);
    }

    public void delete(Integer addressId, Integer customerId) {
        repo.deleteByIdAndCustomer(addressId, customerId);
    }

    public void setDefaultAddress(Integer defaultAddressId, Integer customerId) {
        if (defaultAddressId > 0) {
            repo.setDefaultAddress(defaultAddressId);
        }

        repo.setNonDefaultForOthers(defaultAddressId, customerId);
    }

    public Address getDefaultAddress(Customer customer) {
        return repo.findDefaultByCustomer(customer.getId());
    }
}
