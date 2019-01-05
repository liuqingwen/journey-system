package com.journey.date;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

/**
 * @author liuqingwen
 * @date 2018/3/15.
 */
public class InstantTest {

    @Test
    public void test() {

        Instant timestamp = Instant.now();
        System.out.println(timestamp);
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println(specificTime);

        Duration day = Duration.ofDays(30);
        System.out.println(day);

    }

    @Test
    public void test2() {

        System.out.println(Instant.EPOCH);
        Instant instant = Instant.ofEpochSecond(1 * 60 * 60 * 24);
        System.out.println(instant);

    }

}
