package com.journey.test;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

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

    @Test
    public void test2() {

        AtomicLong atomicLong = new AtomicLong(1000);
        System.out.println(atomicLong.incrementAndGet());
        System.out.println(atomicLong.incrementAndGet());
        atomicLong.set(100);
        System.out.println(atomicLong.incrementAndGet());
        System.out.println(atomicLong.incrementAndGet());

    }

}
