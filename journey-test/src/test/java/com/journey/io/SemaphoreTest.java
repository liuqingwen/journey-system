package com.journey.io;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author liuqingwen
 * @date 2018/7/24.
 */
public class SemaphoreTest {

    @Test
    public void test() {

        ExecutorService executorService = Executors.newFixedThreadPool(20, (runnable) -> {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        });

        Semaphore semaphore = new Semaphore(5);
        for (int index = 0; index < 20; index++) {

            int indexFinal = index;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("Accessing: " + indexFinal);
                    Thread.sleep((long)(Math.random() * 10000));
                    semaphore.release();
                    System.out.println("-----------------"+semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        while (!executorService.isTerminated()) {
        }

        executorService.shutdown();
    }

}
