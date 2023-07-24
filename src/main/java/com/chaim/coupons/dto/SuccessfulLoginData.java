package com.chaim.coupons.dto;

import com.chaim.coupons.enums.UserType;





public class SuccessfulLoginData {
    private Long id;

    private UserType userType;
    private String firstName;
    private String lastName;

    private Long companyId;

    public SuccessfulLoginData(Long id, UserType userType, String firstName, String lastName, Long companyId) {
        this.id = id;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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
        return "SuccessfulLoginData{" +
                "id=" + id +
                ", userType=" + userType +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}

