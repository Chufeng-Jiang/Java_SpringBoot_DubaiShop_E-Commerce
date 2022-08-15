package com.dushop.admin.setting.country;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dushop.common.entity.Country;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.setting.country
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-15  14:03
 *@Description: TODO
 *@Version: 1.0
 */

@RestController
public class CountryRestController {

    @Autowired private CountryRepository repo;

    @GetMapping("/countries/list")
    public List<Country> listAll() {
        return repo.findAllByOrderByNameAsc();
    }

    @PostMapping("/countries/save")
    public String save(@RequestBody Country country) {
        Country savedCountry = repo.save(country);
        return String.valueOf(savedCountry.getId());
    }

    @DeleteMapping("/countries/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repo.deleteById(id);
    }
}
