package com.dushop.customer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import net.bytebuddy.utility.RandomString;
import java.util.Date;

import com.dushop.common.entity.Country;
import com.dushop.common.entity.Customer;
import com.dushop.setting.CountryRepository;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.customer
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-15  20:00
 *@Description: TODO
 *@Version: 1.0
 */

@Service
public class CustomerService {

    @Autowired private CountryRepository countryRepo;
    @Autowired private CustomerRepository customerRepo;
    @Autowired PasswordEncoder passwordEncoder;

    public List<Country> listAllCountries() {
        return countryRepo.findAllByOrderByNameAsc();
    }

    public boolean isEmailUnique(String email) {
        Customer customer = customerRepo.findByEmail(email);
        return customer == null;
    }

    public void registerCustomer(Customer customer) {
        encodePassword(customer);
        customer.setEnabled(false);
        customer.setCreatedTime(new Date());

        String randomCode = RandomString.make(64);
        customer.setVerificationCode(randomCode);

        customerRepo.save(customer);

    }

    private void encodePassword(Customer customer) {
        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
    }

}