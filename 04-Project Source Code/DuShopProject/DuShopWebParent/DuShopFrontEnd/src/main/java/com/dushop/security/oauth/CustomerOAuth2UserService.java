package com.dushop.security.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.security
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-23  21:18
 *@Description: TODO
 *@Version: 1.0
 */

@Service
public class CustomerOAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);
        return new CustomerOAuth2User(user);
    }

}