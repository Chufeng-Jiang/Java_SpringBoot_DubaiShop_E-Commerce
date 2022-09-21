package com.dushop.common.entity;import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/*
 * @BelongsProject: DuShopProject
 * @BelongsPackage: com.dushop.common.entity
 * @Author: Jiang Chufeng
 * @CreateTime: 2022-07-9  19:23
 * @Description: TODO
 * @Version: 1.0
 */

/*
 * @description: Base ID for customer ID purpose
 * @author: Jiang Chufeng
 * @date: 2022/8/31 17:40
 * @param: null
 * @return:
 */

@MappedSuperclass
public abstract class IdBasedEntity {

/*
 * 主键
 * 生成策略为自动增长
 * 唯一、长度为
 */
/*self-finish*/
    @Id //定义属性为数据库的主键，一个实体里面必须有一个。
    @GeneratedValue(strategy = GenerationType.IDENTITY) //为主键生成策略
    protected Integer id; // The table role - 1st Attribute: id
    /*self-finish*/
    public Integer getId() {
        return id;
    }
    /*self-finish*/
    public void setId(Integer id) {
        this.id = id;
    }
}
