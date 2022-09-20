package com.dushop.admin;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.brand
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-05  18:27
 *@Description: TODO
 *@Version: 1.0
 */

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Brand not found")
public class BrandNotFoundRestException extends Exception {
}