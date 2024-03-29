package com.dushop.admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.security
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-07-12  11:00
 *@Description: TODO https://www.jianshu.com/p/e4ba1c196c59
 *@Version: 1.0
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /*
    @ Java Development Journal, 2020
    Reference: https://www.javadevjournal.com/spring/password-encoding-in-spring-security/
  */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new DuShopUserDetailsService();
    }


    /************************************
     @Author:  Learn Programming with Real Apps
     “Completed E-Commerce with Spring MVC and Spring Data JPA Playlist” [online]
     Available at: https://youtu.be/hwSB50DqMkc
     ************************************/
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }


    /************************************
     @Author:  Learn Programming with Real Apps
     “Completed E-Commerce with Spring MVC and Spring Data JPA Playlist” [online]
     Available at: https://youtu.be/hwSB50DqMkc
     ************************************/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


    /************************************
     @Author:  Learn Programming with Real Apps
     “Completed E-Commerce with Spring MVC and Spring Data JPA Playlist” [online]
     Available at: https://youtu.be/hwSB50DqMkc
     ************************************/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/states/list_by_country/**").hasAnyAuthority("Admin", "Salesperson")
                .antMatchers("/products/**", "/users/**", "/settings/**", "/countries/**", "/states/**","/categories/**", "/brands/**").hasAuthority("Admin")
                .antMatchers("/products/edit/**", "/products/save", "/products/check_unique")
                .hasAnyAuthority("Admin", "Salesperson")
                .antMatchers("/products", "/products/", "/products/detail/**", "/products/page/**")
                .hasAnyAuthority("Admin","Salesperson", "Shipper")
                .antMatchers("/orders", "/orders/", "/orders/page/**", "/orders/detail/**").hasAnyAuthority("Admin", "Salesperson", "Shipper")
                .antMatchers("/customers/**", "/orders/**", "/get_shipping_cost").hasAnyAuthority("Admin", "Salesperson")
                .antMatchers("/orders_shipper/update/**").hasAuthority("Shipper")

                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll()
                .and().logout().permitAll()
                .and()
                .rememberMe()
                .key("kkkkkkkkkkkkkkkkkkkkkk_1234567890")
                .tokenValiditySeconds(7 * 24 * 60 * 60);
        ;
        http.headers().frameOptions().sameOrigin();
    }

    /************************************
     @Author:  Learn Programming with Real Apps
     “Completed E-Commerce with Spring MVC and Spring Data JPA Playlist” [online]
     Available at: https://youtu.be/hwSB50DqMkc
     ************************************/
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }


}