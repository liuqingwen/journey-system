package com.journey.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by liuqingwen on 2017/8/11.
 */
public class DateTest {

    public static void main(String[] args) {


//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
//        Calendar calendar1 = Calendar.getInstance();
//
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()) + "--" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar1.getTime()));
//        System.out.println(calendar1.getTime().compareTo(calendar.getTime()));




//        System.out.println(new Date().getTime() + " --- " + Calendar.getInstance().getTimeInMillis());
//        System.out.println("1505702827808".length());


        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1471522276000L);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));

    }


    @Test
    public void test() {

        Calendar instance = Calendar.getInstance();
        instance.set(2017, Calendar.OCTOBER, 28, 0, 0, 0);
        System.out.println(instance.compareTo(Calendar.getInstance()));
    }

    @Test
    public void test2() {

        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE,  5);
//        calendar.add(Calendar.DAY_OF_MONTH, 5);
//        calendar.add(Calendar.DAY_OF_YEAR, 5);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));

    }

    @Test
    public void test3() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        System.out.println(new Date().before(calendar.getTime()));

    }

    @Test
    public void test4() {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getDayOfMonth());
        LocalDate localDate1 = localDate.minusDays(localDate.getDayOfMonth() - 1);
        System.out.println(localDate1.getDayOfMonth());

    }
}
