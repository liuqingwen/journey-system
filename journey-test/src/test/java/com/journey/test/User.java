package com.journey.test;

import java.io.Serializable;

/**
 * Created by liuqingwen on 2017/9/6.
 */
public class User implements Serializable, Comparable<User> {

    private static final long serialVersionUID = -1694909307744743762L;
    private int id;
    private String name;

    static {
        System.out.println("User Class init");
    }

    public User() {
    }

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

    public User setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return this.getId() == o.getId() ? 0 :
                this.getId() > o.getId() ? 1 : -1;
    }
}
