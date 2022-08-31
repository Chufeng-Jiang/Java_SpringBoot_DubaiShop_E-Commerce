package com.dushop.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/*
 * @BelongsProject: DuShopProject
 * @BelongsPackage: com.dushop.common.entity
 * @Author: Jiang Chufeng
 * @CreateTime: 2022-07-8  10:16
 * @Description: TODO
 * @Version: 1.0
 */

/*@SpringBootApplication 注解是 Spring Boot 项目的核心注解，主要作用是开启
  Spring 自动配置，如果在 Application 类上去掉该注解，那么不会启动 SpringBoot程序*/
// 只有当类所在的包被 Spring @ComponentScan 注解扫描到才会生效，
// 默认情况下，该注解会扫描在主应用类下的所有包结构。

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })//加上它就解决了
@EntityScan({"com.dushop.common.entity"})
public class DuShopBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuShopBackEndApplication.class, args);
    }

}
