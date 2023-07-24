package com.chaim.coupons.entitys;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "purchases")
public class  PurchaseEntity {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private CouponEntity coupon;
    @ManyToOne
    @JoinColumn (name="customer_id",nullable = false)
    private CustomerEntity customer;
    @Column(name="amount",nullable = false)
    private int amount;
    @Column(name="timestamp",nullable = false)
    private Date timestamp;

    public PurchaseEntity(){

    }

    public PurchaseEntity(long id, int amount, Date timestamp) {
        this( amount,  timestamp);
        this.id = id;

    }

    public PurchaseEntity( int amount, Date timestamp) {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public CouponEntity getCoupon() {
        return coupon;
    }

    public void setCoupon(CouponEntity coupon) {
        this.coupon = coupon;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "PurchaseEntity{" +
                "id=" + id +
                ", coupon=" + coupon +
                ", customer=" + customer +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
