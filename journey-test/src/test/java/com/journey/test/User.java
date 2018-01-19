package com.journey.test;

import java.io.Serializable;

/**
 * Created by liuqingwen on 2017/9/6.
 */
public class User implements Serializable {

    private static final long serialVersionUID = -1694909307744743762L;
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static User build(User user) {
        return user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}