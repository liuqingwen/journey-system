package com.journey.concurrent;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author liuqingwen
 * @date 2018/8/9.
 */
public class CyclicBarrierTest {

    @Test
    public void test() {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("我解放了");
        });

        for (int index = 0; index < 5; index++ ) {

            Thread thread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "-我等了很久了");
                } catch (BrokenBarrierException | InterruptedException e) {}
            });
            thread.setName("Thread-" + index + "-号");
            thread.setDaemon(true);
            thread.start();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
        }

        System.out.println("结束了");
    }

}
