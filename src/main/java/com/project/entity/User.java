package com.project.entity;
/*
* user实体类
* */
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private Integer userAge;

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
