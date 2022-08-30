package com.dushop.admin.product;
/*
 *@BelongsProject: DuShopProject
 *@BelongsPackage: com.dushop.admin.order
 *@Author: Jiang Chufeng
 *@CreateTime: 2022-08-30  09:42
 *@Description: TODO
 *@Version: 1.0
 */

public class ProductDTO {
    private String name;
    private String imagePath;
    private float price;
    private float cost;

    public ProductDTO(String name, String imagePath, float price, float cost) {
        this.name = name;
        this.imagePath = imagePath;
        this.price = price;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}