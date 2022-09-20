package com.dushop.common.entity;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.common.entity
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-27  23:21
 *@Description: TODO
 *@Version: 1.0
 */

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractAddressWithCountry extends AbstractAddress {
    /*self-finish*/
    @ManyToOne
    @JoinColumn(name = "country_id")
    protected Country country;
    /*self-finish*/
    public Country getCountry() {
        return country;
    }

    /*self-finish*/
    public void setCountry(Country country){this.country = country;}


    /*
@Author: Self-code.
“Ecommerce Spring Boot Project step-by-step using Spring Boot, Thymeleaf, Spring Security, Hibernate, Spring Data Jpa, Lombok.” [online]
Available at: https://youtu.be/4ga5bcBPgzo
*/
    @Override
    public String toString() {
        String address = firstName;

        if (lastName != null && !lastName.isEmpty()) address += " " + lastName;

        if (!addressLine1.isEmpty()) address += ", " + addressLine1;

        if (addressLine2 != null && !addressLine2.isEmpty()) address += ", " + addressLine2;

        if (!city.isEmpty()) address += ", " + city;

        if (state != null && !state.isEmpty()) address += ", " + state;

        address += ", " + country.getName();

        if (!postalCode.isEmpty()) address += ". Postal Code: " + postalCode;
        if (!phoneNumber.isEmpty()) address += ". Phone Number: " + phoneNumber;

        return address;
    }
}