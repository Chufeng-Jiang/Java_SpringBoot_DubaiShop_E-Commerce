package com.dushop.admin.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.dushop.common.entity.Role;
import com.dushop.common.entity.User;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.user.controller
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-07-10  16:25
 *@Description: TODO
 *@Version: 1.0
 */

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/users")
    public String listAll(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }
}


