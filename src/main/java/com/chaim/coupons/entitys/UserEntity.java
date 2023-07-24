package com.chaim.coupons.entitys;

import com.chaim.coupons.enums.UserType;

import javax.persistence.*;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="user_name",unique = true,nullable = false)
    private String userName;
    @Column(name="password",nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type",nullable = false)
    private UserType type;
    @ManyToOne
    private CompanyEntity company;


    public UserEntity() {

    }

    public UserEntity(Long id, String userName, String password, UserType type) {
        this( userName,password, type);
        this.id = id;

    }

    public UserEntity(String userName, String password, UserType type) {
        this.userName = userName;
        this.password = password;
        this.type = type;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type=" + type +
                ", company=" + company +
                '}';
    }
}
