package com.journey.concurrent.lock;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author liuqingwen
 * @date 2018/9/7.
 */
public class LockSupportTest {

    @Test
    public void test() {

        Object blocker = LockSupport.getBlocker(Thread.currentThread());
        System.out.println(blocker);

    }

}
