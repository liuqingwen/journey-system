package com.journey.concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author liuqingwen
 * @date 2018/8/19.
 */
public class TimeUnitTest {

    @Test
    public void test() throws InterruptedException {

        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("我已经结束了");

    }

}
