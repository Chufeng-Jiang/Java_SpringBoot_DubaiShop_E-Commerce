package com.dushop.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * @BelongsProject: DuShopProject
 * @BelongsPackage: com.dushop.common.entity
 * @Author: Jiang Chufeng
 * @CreateTime: 2022-07-10  00:50
 * @Description: Backend Admin Role Entity. Set the dushopdb-roles attributes.
 * @Version: 1.0
 */

@Entity
@Table(name = "roles")  // The roles table's name in the dushopdb Database
public class Role extends IdBasedEntity {
    /*self-finish*/
    @Column(length = 40, nullable = false, unique = true)  // The table role - 2nd Attribute: name
    private String name;
    /*self-finish*/
    @Column(length = 150, nullable = false) // The table role - 3rd Attribute: description
    private String description;
    /*Auto-generated by InteliJ Idea*/
    public Role() {
    }
    /*Auto-generated by InteliJ Idea*/
    public Role(Integer id) {
        this.id = id;
    }
    /*Auto-generated by InteliJ Idea*/
    public Role(String name) {
        this.name = name;
    }
    /*Auto-generated by InteliJ Idea*/
    public Role(String name, String description) {
        this.name = name;
        this.description = description;
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
    public String getDescription() {
        return description;
    }
    /*Auto-generated by InteliJ Idea*/
    public void setDescription(String description) {
        this.description = description;
    }

    /*Auto-generated by InteliJ Idea*/
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

/*Auto-generated by InteliJ Idea and partly adopted from
@Author: Code Java.
“Spring Boot Tutorials Playlist” [online]
Available at: https://youtu.be/zDc63OHY_v8
*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Role other = (Role) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    /*Auto-generated by InteliJ Idea*/
    @Override
    public String toString() {
        return this.name;
    }


}
