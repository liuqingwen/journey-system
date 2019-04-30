package com.thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author liuqingwen@qiyi.com
 * @date 2019/2/14 下午4:56
 */
public class ThreadTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadTest.class);

    public static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> null);

    @Test
    public void test() {
        threadLocal.set("key");
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(Thread.currentThread().getThreadGroup(), () -> {
            System.out.println(threadLocal.get());
            System.out.println(Thread.currentThread().getName());
        }, "i-thread");
        System.out.println(Thread.currentThread().getName());
        System.out.println(threadLocal.get());
        thread.start();

    }

    @Test
    public void test02() {
        v();
    }

    public static String v() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Callable<String> runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("sleep time over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "th";
        };

        Future<String> submit = executorService.submit(runnable);

        try {
            return submit.get(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            LOGGER.error("出异常了", e);

            return null;
        }


    }

}
