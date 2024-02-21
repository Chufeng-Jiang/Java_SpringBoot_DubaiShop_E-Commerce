package com.dushop;
import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dushop.common.entity.Customer;
import com.dushop.common.entity.CustomerNotFoundException;
import com.dushop.setting.EmailSettingBag;
import com.dushop.setting.SettingService;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.customer
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-24  19:08
 *@Description: TODO
 *@Version: 1.0
 */

@Controller
public class ForgotPasswordController {
   // to do
}