package com.dushop.admin.user;

import java.util.List;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.dushop.admin.paging.PagingAndSortingHelper;
import com.dushop.common.entity.Role;
import com.dushop.common.entity.User;
import org.springframework.ui.Model;

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


    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }

}

