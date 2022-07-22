package com.dushop.admin.security;

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
 *@Description: TODO
 *@Version: 1.0
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll();
    }

   /* In Spring Security 5.4 we also introduced the WebSecurityCustomizer.
    The WebSecurityCustomizer is a callback interface that can be used to customize WebSecurity.
    Below is an example configuration using the WebSecurityConfigurerAdapter that ignores requests
    that match /ignore1 or /ignore2:
    https://www.baeldung.com/spring-security-expressions
    */
   @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**"); // Resolve the static resources problem
    }


}
