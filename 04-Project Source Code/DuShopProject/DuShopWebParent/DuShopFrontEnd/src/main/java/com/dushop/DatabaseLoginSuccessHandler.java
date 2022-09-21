package com.dushop;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.dushop.common.entity.AuthenticationType;
import com.dushop.common.entity.Customer;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.security
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-23  20:59
 *@Description: TODO 可以进行认证成功后的一系列处理，如返回给前端结果信息、页面跳转等。
 *               https://blog.csdn.net/qq_41522183/article/details/113987400
 *@Version: 1.0
 */

@Component
public class DatabaseLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired private CustomerService customerService;

    /************************************
     @Author: AmigosCode
     “Spring & Spring Boot Playlist” [online]
     Available at: https://youtu.be/8SGI_XS5OPw
     ************************************/
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        CustomerUserDetails userDetails = (CustomerUserDetails) authentication.getPrincipal();
        Customer customer = userDetails.getCustomer();
        customerService.updateAuthenticationType(customer, AuthenticationType.DATABASE);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}