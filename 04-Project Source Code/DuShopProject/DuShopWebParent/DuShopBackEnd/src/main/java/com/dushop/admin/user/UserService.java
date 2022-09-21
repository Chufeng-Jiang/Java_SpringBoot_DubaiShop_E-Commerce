package com.dushop.admin.user;

import java.util.List;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.dushop.admin.PagingAndSortingHelper;
import com.dushop.common.entity.Role;
import com.dushop.common.entity.User;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.user
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-07-10  16:19
 *@Description: TODO
 *@Version: 1.0
 */

@Service
@Transactional
public class UserService {
    public static final int USERS_PER_PAGE = 4;
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*self-finish*/
    public List<User> listAll() {
        return (List<User>) userRepo.findAll(Sort.by("firstName").ascending());
    }
    /*self-finish*/
    public User getByEmail(String email) {
        return userRepo.getUserByEmail(email);
    }

    /*
     * @description:
     * @author: Jiang Chufeng
     * @date: 2022/7/14 11:34
     * @param: pageNum
     * @param: sortField: Sorting according to which column in "manage users" form of Control panel
     * @param: sortDir: asc-up; dsc-down
     * @param: keyword: search users by keywords
     * @return: org.springframework.data.domain.Page<com.dushop.common.entity.User>
     */

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    public void listByPage(int pageNum, PagingAndSortingHelper helper) {
        helper.listEntities(pageNum, USERS_PER_PAGE, userRepo);
    }


    /*self-finish*/
    public List<Role> listRoles() {
        return (List<Role>) roleRepo.findAll();
    }

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    public User save(User user) {

        boolean isUpdatingUser = (user.getId() != null);

        if (isUpdatingUser) {
            User existingUser = userRepo.findById(user.getId()).get();
            if (user.getPassword().isEmpty()) {
                user.setPassword(existingUser.getPassword());
            } else {
                encodePassword(user);
            }
        } else {
            encodePassword(user);
        }
        return userRepo.save(user);
    }

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    private void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    public boolean isEmailUnique(Integer id, String email) {
        User userByEmail = userRepo.getUserByEmail(email);

        if (userByEmail == null) return true;

        boolean isCreatingNew = (id == null);//

        if (isCreatingNew) {
            if (userByEmail != null) return false;
        } else {
            if (userByEmail.getId() != id) {
                return false;
            }
        }
        return true;
    }

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    public User get(Integer id) throws UserNotFoundException {
        try {
            return userRepo.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new UserNotFoundException("Could not find  ID " + id);
        }
    }

    /*self-finish*/
    public void delete(Integer id) throws UserNotFoundException {
        Long countById = userRepo.countById(id);
        if (countById == null || countById == 0) {
            throw new UserNotFoundException("Could not find ID " + id);
        }
        userRepo.deleteById(id);
    }

    /*self-finish*/
    public void updateUserEnabledStatus(Integer id, boolean enabled) {
        userRepo.updateEnabledStatus(id, enabled);
    }

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    public User updateAccount(User userInEditForm) {
        User userInDatabase = userRepo.findById(userInEditForm.getId()).get();

        if (!userInEditForm.getPassword().isEmpty()) {
            userInDatabase.setPassword(userInEditForm.getPassword());
            encodePassword(userInDatabase);
        }

        if (userInEditForm.getPhotos() != null) {
            userInDatabase.setPhotos(userInEditForm.getPhotos());
        }

        userInDatabase.setFirstName(userInEditForm.getFirstName());
        userInDatabase.setLastName(userInEditForm.getLastName());

        return userRepo.save(userInDatabase);
    }
}

