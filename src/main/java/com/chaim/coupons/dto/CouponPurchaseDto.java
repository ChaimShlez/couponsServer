package com.chaim.coupons.dto;

import java.util.Date;

public class CouponPurchaseDto {
    private long id;
    private long couponId;
    private String couponName;
    private String description;
    private float price;
    private Date startDate;
    private Date endDate;
    private Date timestamp;
    private int amount;
    private String imgUrl;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public CouponPurchaseDto(long id, long couponId, String couponName,  Date timestamp, int amount,String imgUrl) {
        this.id = id;
        this.couponId = couponId;
        this.couponName = couponName;
        this.timestamp = timestamp;
        this.amount = amount;
        this.imgUrl= imgUrl;
    }

    public CouponPurchaseDto(long id, long couponId, String couponName, String description,
                             float price, Date startDate, Date endDate, Date timestamp, int amount,String imgUrl,
                             String firstName,String lastName,String address,String phoneNumber) {
        this.id = id;
        this.couponId = couponId;
        this.couponName = couponName;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timestamp = timestamp;
        this.amount = amount;
        this.imgUrl= imgUrl;
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.phoneNumber=phoneNumber;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "CouponPurchaseDto{" +
                "id=" + id +
                ", couponId=" + couponId +
                ", couponName='" + couponName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", timestamp=" + timestamp +
                ", amount=" + amount +
                ", imgUrl='" + imgUrl + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
