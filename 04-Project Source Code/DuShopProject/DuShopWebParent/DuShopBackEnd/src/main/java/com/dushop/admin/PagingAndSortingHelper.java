package com.dushop.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.method.support.ModelAndViewContainer;

/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.paging
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-07-10  16:22
 *@Description: TODO
 *@Version: 1.0
 */

public class PagingAndSortingHelper {
    private ModelAndViewContainer model ;
    private String listName;
    private String sortDir;
    private String sortField;

    private String keyword;

    /*Auto-generated by InteliJ Idea*/
    public PagingAndSortingHelper(ModelAndViewContainer model,String listName, String sortField, String sortDir, String keyword) {
        this.model = model;
        this.listName = listName;
        this.sortField = sortField;
        this.sortDir = sortDir;
        this.keyword = keyword;
    }

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    public void updateModelAttributes(int pageNum, Page<?> page) {
        List<?> listItems = page.getContent();
        int pageSize = page.getSize();

        long startCount = (pageNum - 1) * pageSize + 1;
        long endCount = startCount + pageSize - 1;
        if (endCount > page.getTotalElements()) {
            endCount = page.getTotalElements();
        }
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("startCount", startCount);
        model.addAttribute("endCount", endCount);
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute(listName, listItems);
    }

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    public void listEntities(int pageNum, int pageSize, SearchRepository<?, Integer> repo) {

        //Pageable 是Spring Data库中定义的一个接口,用于构造翻页查询,是所有分页相关信息的一个抽象
        Pageable pageable = createPageable(pageSize, pageNum);

        Page<?> page = null;

        if (keyword != null) {
            page = repo.findAll(keyword, pageable);
        } else {
            page = repo.findAll(pageable);
        }

        updateModelAttributes(pageNum, page);
    }

    /*****************************
     @Author: Code Java.
     “Spring Boot Tutorials Playlist” [online]
     Available at: https://youtu.be/zDc63OHY_v8
     ****************************/
    public Pageable createPageable(int pageSize, int pageNum) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        return PageRequest.of(pageNum - 1, pageSize, sort);
    }

    /*Auto-generated by InteliJ Idea*/
    public String getSortField() {
        return sortField;
    }
    /*Auto-generated by InteliJ Idea*/
    public String getSortDir() {
        return sortDir;
    }
    /*Auto-generated by InteliJ Idea*/
    public String getKeyword() {
        return keyword;
    }
}