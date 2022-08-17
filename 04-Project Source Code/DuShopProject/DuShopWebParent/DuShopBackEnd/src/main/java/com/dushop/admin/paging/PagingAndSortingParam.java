package com.dushop.admin.paging;

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

@Retention(RUNTIME)
@Target(PARAMETER)
public @interface PagingAndSortingParam {
    public String moduleURL();

    public String listName();
}
