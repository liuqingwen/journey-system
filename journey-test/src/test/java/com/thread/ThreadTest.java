package com.thread;

import org.junit.Test;

/**
 * @author liuqingwen@qiyi.com
 * @date 2019/2/14 下午4:56
 */
public class ThreadTest {

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

}
