package com.dushop.admin;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.category
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-02  20:51
 *@Description: TODO
 *@Version: 1.0
 */

public class CategoryPageInfo {
    private int totalPages;
    private long totalElements;

    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public long getTotalElements() {
        return totalElements;
    }
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }


}
