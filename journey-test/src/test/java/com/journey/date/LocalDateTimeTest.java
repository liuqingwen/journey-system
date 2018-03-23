package com.journey.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Locale;

/**
 * @author liuqingwen
 * @date 2018/3/15.
 */
public class LocalDateTimeTest {

//    java.time – 包含值对象的基础包
//    java.time.chrono – 提供对不同的日历系统的访问
//    java.time.format – 格式化和解析时间和日期
//    java.time.temporal – 包括底层框架和扩展特性
//    java.time.zone – 包含时区支持的类

//    Joda-Time

//    方法大致功能
//    of： 静态工厂方法，从组成部分中创建实例
//    from： 静态工厂方法，尝试从相似对象中提取实例。from()方法没有of()方法类型安全
//    now： 静态工厂方法，用当前时间创建实例
//    parse： 静态工厂方法，总字符串解析得到对象实例
//    get： 获取时间日期对象的部分状态
//    is： 检查关于时间日期对象的描述是否正确
//    with： 返回一个部分状态改变了的时间日期对象拷贝
//    plus： 返回一个时间增加了的、时间日期对象拷贝
//    minus： 返回一个时间减少了的、时间日期对象拷贝
//    to： 把当前时间日期对象转换成另外一个，可能会损失部分状态
//    at： 用当前时间日期对象组合另外一个，创建一个更大或更复杂的时间日期对象
//    format： 提供格式化时间日期对象的能力

//    原文链接
//    http://www.blogjava.net/4cai/archive/2014/04/29/413041.html

    LocalDateTime localDateTime;
    // year month dayOfMonth(当前月的 第几天) hour minute second nanoOfsecond(当前秒的 多少纳秒)
    LocalDateTime definedLocalDateTime;
    LocalDate nowDate;
    LocalDate definedDate;
    {
        localDateTime = LocalDateTime.now();
        System.out.println(String.format("now local date time = %s", localDateTime));
        definedLocalDateTime = LocalDateTime.of(2018, 03, 15, 11, 42, 51, 100);
        System.out.println(String.format("defined localDateTime is %s", definedLocalDateTime));
        nowDate = LocalDate.now();
        System.out.println(String.format("now localDate is %s", nowDate));
        definedDate = LocalDate.of(2008, 2, 07);
        System.out.println(String.format("defined localDate is %s", definedDate));

        System.out.println();
        System.out.println("------------------------init params-------------------------------");
        System.out.println();
    }

    // 比较
    @Test
    public void test() {

        System.out.println(String.format("now date is after defined date is %s", nowDate.isAfter(definedDate)));
        System.out.println(String.format("now date is before defined date is %s", nowDate.isBefore(definedDate)));

    }

    // 闰年
    @Test
    public void test2() {

        System.out.println(String.format("now year is leap year is %s", nowDate.isLeapYear()));
        System.out.println(String.format("defined year is leap year is %s", definedDate.isLeapYear()));
    }

    // 支持纪元否
    @Test
    public void test3() {

        System.out.println(String.format("localDate support epoch is %s", nowDate.isSupported(ChronoField.EPOCH_DAY)));
        System.out.println(String.format("localTime support epoch is %s", LocalTime.now().isSupported(ChronoField.EPOCH_DAY)));
//        System.out.println(nowDate.get(ChronoField.EPOCH_DAY)); instead use getLong();
        System.out.println(nowDate.getLong(ChronoField.EPOCH_DAY));

        System.out.println(nowDate.isSupported(ChronoUnit.WEEKS));
    }

    // 创建 LocalDateTime 通过 LocalDate 和 LocalTime/OffsetTime
    // LocalDateTime.of(date, time) 是下面方法真实调用
    @Test
    public void test4() {

        System.out.println(definedDate.atStartOfDay());
        System.out.println(definedDate.atTime(LocalTime.now()));

    }

    // 格式化
    @Test
    public void test5() {

        LocalDateTime.of(LocalDate.now(), LocalTime.now());

        System.out.println(nowDate.format(DateTimeFormatter.ISO_DATE));
        System.out.println(nowDate.format(DateTimeFormatter.ofPattern("yyyy年MM月dd", Locale.CHINA)));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH小时mm分ss秒")));

        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));



    }

    // 获取 明确时间
    @Test
    public void test6() {

        System.out.println(localDateTime.getLong(ChronoField.EPOCH_DAY));
        System.out.println(localDateTime.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(localDateTime.get(ChronoField.DAY_OF_WEEK)); // 周的第几天
        System.out.println(localDateTime.get(ChronoField.DAY_OF_MONTH)); // 月的第几天
        System.out.println(localDateTime.get(ChronoField.DAY_OF_YEAR)); // 年的第几天

    }

    // 转换
    @Test
    public void test7() {

        System.out.println(LocalDate.from(LocalDateTime.now()));
    }

    // 减法
    @Test
    public void test8() {

        LocalDate minusDays = nowDate.minus(1, ChronoUnit.DAYS); // - a day
        System.out.println(String.format("now date minus 1 of days = %s", minusDays));
//        LocalDate minusHalfDays = nowDate.minus(1, ChronoUnit.HALF_DAYS); // - a half day
//        System.out.println(String.format("now date minus 1 half of days = %s", minusHalfDays));
        LocalDate minusWeeks = nowDate.minus(1, ChronoUnit.WEEKS); // - a week
        System.out.println(String.format("now date minus 1 of weeks = %s", minusWeeks));
        LocalDate minusMonths = nowDate.minus(1, ChronoUnit.MONTHS); // - a month
        System.out.println(String.format("now date minus 1 of months = %s", minusMonths));
        LocalDate minusPeriod = nowDate.minus(Period.of(1, 2, 1));
        System.out.println(String.format("now date minus period = %s", minusPeriod));

    }

    // range
    @Test
    public void test9() {

        ValueRange range = nowDate.range(ChronoField.DAY_OF_MONTH);
        System.out.println(String.format("now date day of month is range = %s", range));
        ValueRange rangeDefined = definedDate.range(ChronoField.DAY_OF_MONTH);
        System.out.println(String.format("defined date day of month is range = %s", rangeDefined));

    }

    // period
    @Test
    public void test10() {

        Period until = nowDate.until(LocalDate.now().plusDays(1));// +
        System.out.println(String.format("now date util param date is period = %s", until.getDays()));
        Period untilMinus = nowDate.until(LocalDate.now().minusDays(1));// -
        System.out.println(String.format("now date util param date is period = %s", untilMinus.getDays()));

    }
}
