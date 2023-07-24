package com.chaim.coupons.dto;

import java.util.Date;

public class CouponDto {
    private long id;
    private String name;
    private float price;
    private String description;
    private Date startDate;
    private Date endDate;
    private String imgUrl;
    private long companyId;

    private String companyName;
    private long categoryId;
    private String categoryName;

    public CouponDto(long id, String name, float price , String imgUrl, Date endDate){
        this.id=id;
        this.name=name;
        this.price=price;
        this.imgUrl=imgUrl;
        this.endDate=endDate;
    }
    public CouponDto(long id, String name, float price, String description, Date startDate,
                     Date endDate,String imgUrl,long companyId, String companyName,long categoryId, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.imgUrl=imgUrl;
        this.companyId=companyId;
        this.companyName = companyName;
        this.categoryId=categoryId;
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "CouponDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", imgUrl='" + imgUrl + '\'' +
                ", companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
