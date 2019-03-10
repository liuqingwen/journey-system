package com.journey.date;

import org.junit.Test;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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


        DateTest test = new DateTest();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1471522276000L);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));

        test.test();
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

    @Test
    public void test5() {

        LocalDate graduate = LocalDate.of(2014, 7, 14);
        LocalDate working = LocalDate.now();
        long days = 0;
        System.out.println(days = working.toEpochDay() - graduate.toEpochDay());
        System.out.println("工作 " + days / 365 + " 年 零 " + (days % 365) + " 天");

    }

    @Test
    public void test6() {

        LocalDateTime localDateTime = LocalDateTime.of(2018, Month.MARCH, 8, 16, 49, 42);
//        System.out.println(localDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        System.out.println(localDateTime.getNano());
        System.out.println(localDateTime.getSecond() * 1000);


        System.out.println("--------------------------------");

        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
        System.out.println(now.getNano());
        System.out.println(now.getSecond() * 1000);
    }

    @Test
    public void test7() {

        Instant instant = Instant.now();
        System.out.println(instant.toEpochMilli());
        System.out.println(instant.getNano());

    }

    @Test
    public void test8() {

        Long aLong = 1524790636L;
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(Instant.ofEpochSecond(aLong), ZoneId.systemDefault());
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(aLong, 0, ZoneOffset.ofHours(8));
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        System.out.println(localDateTime1.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));


    }

    @Test
    public void test9() {

        System.out.println(Long.MAX_VALUE);
        System.out.println();

        Instant instant = Instant.now();
        System.out.println(instant.toEpochMilli());
        System.out.println(System.currentTimeMillis());

        System.out.println();
        System.out.println(System.nanoTime());
        System.out.println(instant.toEpochMilli() * 1_000_000);
        System.out.println(instant.getNano());

        System.out.println();
        System.out.println(String.valueOf(instant.toEpochMilli()).length());

    }

    @Test
    public void test10() {

        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.HOUR_OF_DAY, 2);
        Date date2 = calendar2.getTime();
        System.out.println("date2 : " + date2);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        System.out.println("date : " + date);

        System.out.println(date.compareTo(date2));
    }

    @Test
    public void test11() {

        Date date = new Date();
        System.out.println(date);

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR_OF_DAY, 2);
        System.out.println(instance.getTime());

        instance.setTime(date);
        System.out.println(instance.getTime());

    }

    @Test
    public void test12() {

        Date date = new Date();
        System.out.println(date.getTime()/1000);
        System.out.println((int) (date.getTime()/1000));
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void test13() {

        long time = 1551337882588L;
        System.out.println(new Date(time));

    }

    @Test
    public void test14() {

        Date date = new Date();
        System.out.println(date);
        System.out.println(new java.sql.Date(date.getTime()));

    }

    @Test
    public void test15() {

        System.out.println(System.currentTimeMillis());

    }
}
