package com.time;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author liuqingwen
 * @date 2018/12/14.
 */
public class TimeCalculateTest {

    @Test
    public void test() {

        String mark = TimeCalculate.mark();

        try {
            int sleepTime = new Random(System.currentTimeMillis()).nextInt(10);
            System.out.println(sleepTime);
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(TimeCalculate.calculate(mark));

    }

}
