package com.chaim.coupons.entitys;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="coupons")
public class CouponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name= "name",nullable = false)
    private String name;
    @Column(name= "price",nullable = false)
    private float price;
    @Column(name= "description",nullable = false)
    private String description;
    @Column(name= "start_date",nullable = false)
    private Date startDate;
    @Column(name= "end_date",nullable = false)
    private Date endDate;
    @Column(name="img_url",nullable = false)
    private String imgUrl;
    @ManyToOne
    private CompanyEntity company;
    @ManyToOne
    private CategoryEntity category;
    @OneToMany(mappedBy = "coupon",cascade = CascadeType.REMOVE)
    private List<PurchaseEntity> purchase;

    public CouponEntity(){

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

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<PurchaseEntity> getPurchase() {
        return purchase;
    }

    public void setPurchase(List<PurchaseEntity> purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "CouponEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", imgUrl='" + imgUrl + '\'' +
                ", company=" + company +
                ", category=" + category +
                ", purchase=" + purchase +
                '}';
    }
}
