package com.opsifi.model;

import com.opsifi.enums.BusinessUsersCategory;

public class BusinessUsersAuthModel {
    private String name;
    private String username;
    private String password;
    private BusinessUsersCategory userType;

    public BusinessUsersAuthModel(String name, String password, String username, BusinessUsersCategory userType) {
        this.name = name;
        this.password = password;
        this.username = username;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BusinessUsersCategory getUserType() {
        return userType;
    }

    public void setUserType(BusinessUsersCategory userType) {
        this.userType = userType;
    }
}
