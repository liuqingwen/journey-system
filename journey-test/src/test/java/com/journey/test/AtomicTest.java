package com.journey.test;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuqingwen
 * @date 2018/2/11.
 */
public class AtomicTest {

    @Test
    public void test() {

        AtomicInteger atomic = new AtomicInteger(2);
        System.out.println(atomic.accumulateAndGet(1, Integer::min));

    }


}
