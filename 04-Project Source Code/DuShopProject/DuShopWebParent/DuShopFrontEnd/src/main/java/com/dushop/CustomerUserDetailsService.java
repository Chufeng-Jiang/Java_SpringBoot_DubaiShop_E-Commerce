package com.dushop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dushop.common.entity.Customer;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.security
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-18  14:03
 *@Description: TODO
 *@Version: 1.0
 */

public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired private CustomerRepository repo;


    /*self-code, but adapted from user module*/
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = repo.findByEmail(email);
        if (customer == null)
            throw new UsernameNotFoundException("No customer found with the email " + email);

        return new CustomerUserDetails(customer);
    }

}