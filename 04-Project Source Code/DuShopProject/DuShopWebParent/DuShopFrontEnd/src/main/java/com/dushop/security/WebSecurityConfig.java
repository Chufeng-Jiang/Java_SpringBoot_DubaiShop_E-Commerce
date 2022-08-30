package com.dushop.security;

import com.dushop.security.oauth.CustomerOAuth2UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import com.dushop.security.oauth.OAuth2LoginSuccessHandler;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.security
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-12  16:26
 *@Description: TODO https://www.jianshu.com/p/e4ba1c196c59
 *@Version: 1.0
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private CustomerOAuth2UserService oAuth2UserService;
    @Autowired private OAuth2LoginSuccessHandler oauth2LoginHandler;
    @Autowired private DatabaseLoginSuccessHandler databaseLoginHandler;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests()
                .antMatchers("/account_details", "/update_account_details", "/orders/**",
                        "/cart", "/address_book/**", "/checkout", "/place_order",
                        "/process_paypal_order").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .successHandler(databaseLoginHandler)
                .permitAll()
                .and()
                .oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(oAuth2UserService)
                .and()
                .successHandler(oauth2LoginHandler)
                .and()
                .logout().permitAll()
                .and()
                .rememberMe()
                .key("5124569852_dhsjshdgdbdddyZ")
                .tokenValiditySeconds(14 * 24 * 60 * 60)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
        ;

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomerUserDetailsService();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }
}

    /* In Spring Security 5.4 we also introduced the WebSecurityCustomizer.
    The WebSecurityCustomizer is a callback interface that can be used to customize WebSecurity.
    Below is an example configuration using the WebSecurityConfigurerAdapter that ignores requests
    that match /ignore1 or /ignore2:
    https://www.baeldung.com/spring-security-expressions
    */
