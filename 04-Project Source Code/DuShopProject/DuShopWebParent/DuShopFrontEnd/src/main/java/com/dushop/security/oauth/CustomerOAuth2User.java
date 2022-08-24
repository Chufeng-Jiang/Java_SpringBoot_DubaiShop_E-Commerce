package com.dushop.security.oauth;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.oauth
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-23  21:13
 *@Description: TODO
 *@Version: 1.0
 */

public class CustomerOAuth2User implements OAuth2User {

    private String clientName;

    private OAuth2User oauth2User;

    public CustomerOAuth2User(OAuth2User user, String clientName) {
        this.oauth2User = user;
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return oauth2User.getAuthorities();
    }

    @Override
    public String getName() {
        return oauth2User.getAttribute("name");
    }

    public String getEmail() {
        return oauth2User.getAttribute("email");
    }

    public String getFullName() {
        return oauth2User.getAttribute("name");
    }
}