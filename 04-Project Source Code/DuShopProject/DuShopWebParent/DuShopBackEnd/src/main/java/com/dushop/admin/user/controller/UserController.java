package com.dushop.admin.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import com.dushop.admin.FileUploadUtil;
import com.dushop.admin.user.UserNotFoundException;
import com.dushop.admin.user.UserService;
import com.dushop.admin.user.export.UserCsvExporter;
import com.dushop.admin.user.export.UserExcelExporter;
import com.dushop.admin.user.export.UserPdfExporter;
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
import com.dushop.admin.PagingAndSortingHelper;
import com.dushop.admin.PagingAndSortingParam;

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

    private String defaultRedirectURL = "redirect:/users/page/1?sortField=firstName&sortDir=asc";

    /*self-finish*/
    @GetMapping("/users")
    public String listFirstPage() {
        return defaultRedirectURL;
//        Set default sort Column(sortFiled) in bootstrap from when go to manage user page
    }

    /*
     * @description:
     * @author: Jiang Chufeng
     * @date: 2022/7/13 18:31
     * @param: pageNum
     * @param: model
     * @param: sortField Admin-Manage User-sorting
     * @param: sortDir
     * @return: java.lang.String
     */

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    @GetMapping("/users/page/{pageNum}")
    public String listByPage( @PagingAndSortingParam(listName = "listUsers", moduleURL = "/users") PagingAndSortingHelper helper,
            @PathVariable(name = "pageNum") int pageNum) {
        service.listByPage(pageNum, helper);
        return "users/users";
    }

    /*self-finish*/
    @GetMapping("/users/new")
    public String newUser(Model model) {
        List<Role> listRoles = service.listRoles();
        User user = new User();
        user.setEnabled(true);
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("pageTitle", "Create New User");
        return "users/user_form";
    }

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes, @RequestParam("image") MultipartFile multipartFile) throws IOException {

        if (!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            user.setPhotos(fileName);
            User savedUser = service.save(user);
            String uploadDir = "user-photos/" + savedUser.getId();
            FileUploadUtil.cleanDir(uploadDir);
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        } else {
            if (user.getPhotos().isEmpty()) user.setPhotos(null);
            service.save(user);
        }

        redirectAttributes.addFlashAttribute("message", "Saved successfully.");
        //Return to page 1 after edit information
        return getRedirectURLtoAffectedUser(user);
    }

    /*
     * @description: Keep the user only affected  stay in the front of  the screen, the filter catch the name auto
     * @author: Jiang Chufeng
     * @date: 2022/7/16 22:25
     * @param: user
     * @return: java.lang.String
     */

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    private String getRedirectURLtoAffectedUser(User user) {
        String prefixOfEmail = user.getEmail().split("@")[0];
        return "redirect:/users/page/1?sortField=id&sortDir=asc&keyword=" + prefixOfEmail;
    }



    /*self-finish*/
    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            User user = service.get(id);
            List<Role> listRoles = service.listRoles();
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User (ID: " + id + ")");
            model.addAttribute("listRoles", listRoles);
            return "users/user_form";
        } catch (UserNotFoundException ex) {
            redirectAttributes.addFlashAttribute("message", ex.getMessage());
            return defaultRedirectURL;
        }
    }

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            service.delete(id);;
            redirectAttributes.addFlashAttribute("message", "The user ID " + id + " has been deleted successfully");
        } catch (UserNotFoundException ex) {
            redirectAttributes.addFlashAttribute("message", ex.getMessage());
        }
        return defaultRedirectURL;
    }

    /*self-code*/
    @GetMapping("/users/{id}/enabled/{status}")
    public String updateUserEnabledStatus(@PathVariable("id") Integer id, @PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes) {
        service.updateUserEnabledStatus(id, enabled);
        String status = enabled ? "enabled" : "disabled";
        String message = "The user ID " + id + " has been " + status;
        redirectAttributes.addFlashAttribute("message", message);

        return defaultRedirectURL;
    }

    /*
 https://codehunter.cc/a/spring/how-to-return-csv-data-in-browser-from-spring-controller
 https://grabthiscode.com/whatever/download-csv-file-spring-boot
 */
    @GetMapping("/users/export/csv")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        List<User> listUsers = service.listAll();
        UserCsvExporter exporter = new UserCsvExporter();
        exporter.export(listUsers, response);
    }

    /*Adopted from above code */
    @GetMapping("/users/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        List<User> listUsers = service.listAll();
        UserExcelExporter exporter = new UserExcelExporter();
        exporter.export(listUsers, response);
    }
    /*Adopted from above code */
    @GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws IOException {
        List<User> listUsers = service.listAll();
        UserPdfExporter exporter = new UserPdfExporter();
        exporter.export(listUsers, response);
    }
}


