package com.dushop.common.entity;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.setting.state
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-15  14:40
 *@Description: TODO
 *@Version: 1.0
 */

public class StateDTO {
    private Integer id;
    private String name;

    public StateDTO() {

    }

    public StateDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
