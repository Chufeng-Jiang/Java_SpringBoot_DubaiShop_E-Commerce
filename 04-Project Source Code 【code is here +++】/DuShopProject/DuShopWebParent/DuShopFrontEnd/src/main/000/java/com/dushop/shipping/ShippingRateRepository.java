package com.dushop.shipping;
import org.springframework.data.repository.CrudRepository;

import com.dushop.common.entity.Country;
import com.dushop.common.entity.ShippingRate;

public interface ShippingRateRepository extends CrudRepository<ShippingRate, Integer> {

    public ShippingRate findByCountryAndState(Country country, String state);
}