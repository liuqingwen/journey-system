package com.journey.concurrent.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
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


        Thread thread = new Thread(() -> {

            LockSupport.park();

            System.out.println(" - thread over " + Thread.currentThread().isInterrupted());
        });

        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

        System.out.println("main thread over ." + Thread.currentThread().isInterrupted());
    }

}
