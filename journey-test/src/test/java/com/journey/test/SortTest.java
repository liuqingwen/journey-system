package com.journey.test;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liuqingwen on 2017/9/6.
 */
public class SortTest {


    public static void main(String[] args) {


        List<User> users = new ArrayList<>();
        users.add(new User(5, "kk"));
        users.add(new User(2, "ss"));
        Collections.sort(users, Ordering.natural().onResultOf((User user) -> user.getId()));
        System.out.println(users);

    }

}
