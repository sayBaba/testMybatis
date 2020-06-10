package com.hzit.testMybatis.model;

public class Orders {

    private Integer id;

    private String userId;

    private Integer number;

    public UserOrder getUser() {
        return user;
    }

    public void setUser(UserOrder user) {
        this.user = user;
    }

    private UserOrder user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
