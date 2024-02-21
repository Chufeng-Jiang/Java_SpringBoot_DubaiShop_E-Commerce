package com.dushop.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/*
 * @description:
 * @author: Jiang Chufeng
 * @date: 2022/7/10 13:57
 * @param: null
 * @return: 
 */
@NoRepositoryBean
public interface SearchRepository<T, ID> extends PagingAndSortingRepository<T, ID> {
	/*****************************
	 @Author: Code Java.
	 “Spring Boot Tutorials Playlist” [online]
	 Available at: https://youtu.be/zDc63OHY_v8
	 ****************************/
	public Page<T> findAll(String keyword, Pageable pageable);
}