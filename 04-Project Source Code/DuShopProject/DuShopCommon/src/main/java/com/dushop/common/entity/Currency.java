package com.dushop.common.entity;

import javax.persistence.*;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.common.entity
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-13  19:23
 *@Description: TODO
 *@Version: 1.0
 */

@Entity
@Table(name = "currencies")
public class Currency extends IdBasedEntity {
    /*self-finish*/
    @Column(nullable = false, length = 64)
    private String name;
    /*self-finish*/
    @Column(nullable = false, length = 3)
    private String symbol;
    /*self-finish*/
    @Column(nullable = false, length = 4)
    private String code;
    /*Auto-generated by InteliJ Idea*/
    public Currency() {

    }
    /*Auto-generated by InteliJ Idea*/
    public Currency(String name, String symbol, String code) {
        super();
        this.name = name;
        this.symbol = symbol;
        this.code = code;
    }
    /*Auto-generated by InteliJ Idea*/
    public String getName() {
        return name;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setName(String name) {
        this.name = name;
    }
    /*Auto-generated by InteliJ Idea*/
    public String getSymbol() {
        return symbol;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    /*Auto-generated by InteliJ Idea*/
    public String getCode() {
        return code;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setCode(String code) {
        this.code = code;
    }
    /*Auto-generated by InteliJ Idea*/
    @Override
    public String toString() {
        return name + " - " + code + " - " + symbol;
    }

}