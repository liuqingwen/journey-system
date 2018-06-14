package com.journey.vola;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author liuqingwen
 * @date 2018/6/14.
 */
public class VolatileTest {

    private volatile boolean bl = false;
    private int count = 1;

    public void go() {

        String name = Thread.currentThread().getName();
        boolean value = setBl(true);
        if (!value) {
            System.out.println(value + name + "我进来了");
            setBl(true);
            try {
                Thread.sleep(100);
                System.out.println("解锁...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setBl(false);
        } else {
            System.err.println(value + name + "我没进去");
        }

    }

    static AtomicInteger INC = new AtomicInteger(1);
    static Executor executor = Executors.newFixedThreadPool(100, (runnable) -> {
        Thread thread = new Thread(runnable);
        thread.setName("阳光梅利号-" + INC.getAndIncrement() + "-thread");
        return thread;
    });
    static VolatileTest volatileTest = new VolatileTest();

    public static void main(String[] args) {

//        IntStream.range(0, 100).forEach(v -> {
//            try {
//                Thread.sleep(40);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            executor.execute(() -> volatileTest.go());
//        });

        IntStream.range(0, 100).forEach(v -> executor.execute(() -> System.out.println(volatileTest.setCount())));

        Object lock = new Object();
        synchronized (lock) {
            while (true) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized boolean setBl(boolean bl) {
        boolean old = this.bl;
        this.bl = bl;
        return old;
    }

    public synchronized int setCount() {
        count++;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }
}
