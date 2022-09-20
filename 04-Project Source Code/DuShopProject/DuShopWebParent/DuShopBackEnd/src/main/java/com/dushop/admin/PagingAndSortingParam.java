package com.dushop.admin;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.paging
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-17  22:18
 *@Description: TODO
 *@Version: 1.0
 */

@Retention(RUNTIME) //用来表示注解的生命周期
@Target(PARAMETER) //此注解说明注解的作用目标，默认值为任何元素, 允许作用在方法参数上
 public @interface PagingAndSortingParam {
    public String listName();

    public String moduleURL();
}
