package com.chaim.coupons.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "companies")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name",unique = true,nullable = false)
    private String name;
    @Column(name = "address",unique = true,nullable = false)
    private String address;
    @Column(name = "phone_number",unique = true,nullable = false)
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "company")
    private List<UserEntity> employees;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "company")
    private List<CouponEntity>  coupons;


    public CompanyEntity(){

    }

    public CompanyEntity(Long id, String name, String address, String phoneNumber) {
        this(name, address, phoneNumber);
        this.id = id;

    }

    public CompanyEntity(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<UserEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<UserEntity> employees) {
        this.employees = employees;
    }

    public List<CouponEntity> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<CouponEntity> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "CompanyEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
