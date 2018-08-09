package com.journey.concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuqingwen
 * @date 2018/8/9.
 */
public class CountDownLatchTest {

    @Test
    public void test() {

        CountDownLatch countDownLatch = new CountDownLatch(5);

        final Thread thread1 = Thread.currentThread();
        for (int index = 0; index < 5; index++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                    System.out.println("parentThread - "+ thread1.getName() + "-" + thread1.getState());
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName() + "-" + Thread.currentThread().getState());
                } catch (InterruptedException e) {}
            });
            thread.setName("Thread-"+index+"号");
            thread.setDaemon(true);
            thread.start();
        }

        try {
            countDownLatch.await();
            System.out.println(Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
