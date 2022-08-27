package com.dushop.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 *@sql author Sagun Khosla <sagunxp@gmail.com>
 *@github: https://github.com/sagunkho/geo-sql-database/blob/master/geo_states.sql
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.common.entity
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-14  12:59
 *@Description: TODO
 *@Version: 1.0
 */

@Entity
@Table(name = "states")
public class State extends IdBasedEntity{
     @Column(nullable = false, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public State() {

    }

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "State [id=" + id + ", name=" + name + "]";
    }


}

