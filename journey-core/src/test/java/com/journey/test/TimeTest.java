package com.journey.test;

import org.joda.time.LocalDateTime;

import java.util.Date;

/**
 * Created by liuqingwen on 2017/7/20.
 */
public class TimeTest {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        Date now = localDateTime.toDate();
        System.out.println(now);
        System.out.println(localDateTime.minusDays(7).toDate());


    }

}
