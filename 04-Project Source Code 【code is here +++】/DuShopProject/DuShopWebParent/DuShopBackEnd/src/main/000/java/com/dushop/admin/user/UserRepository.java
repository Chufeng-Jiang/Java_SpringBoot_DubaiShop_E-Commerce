package com.dushop.admin.user;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.dushop.admin.paging.SearchRepository;
import com.dushop.admin.paging.SearchRepository;
import com.dushop.common.entity.User;

/*
 * @description:
 * @author: Jiang Chufeng
 * @date: 2022/7/10 13:57
 * @param: null
 * @return: 
 */
public interface UserRepository extends SearchRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    public User getUserByEmail(@Param("email") String email);

    public Long countById(Integer id);  // This method follows the convention specified by Spring Data JPA, so we don't have to specify any SQL statement, any query and pass the parameter id here..

    @Query("SELECT u FROM User u WHERE CONCAT(u.id, ' ', u.email, ' ', u.firstName, ' ',"
            + " u.lastName) LIKE %?1%")
    public Page<User> findAll(String keyword, Pageable pageable);

    @Query("UPDATE User u SET u.enabled = ?2 WHERE u.id = ?1")
    @Modifying
    public void updateEnabledStatus(Integer id, boolean enabled);

}
