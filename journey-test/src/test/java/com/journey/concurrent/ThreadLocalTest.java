package com.journey.concurrent;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/7/18.
 */
public class ThreadLocalTest {

    @Test
    public void test() {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        threadLocal.set("liu");
        threadLocal.set("qing");
        threadLocal.set("wen");

        System.out.println(threadLocal.get());

    }

    @Test
    public void test2() {

        ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return "liu";
            }
        };

        new Thread(() -> {
            System.out.println(threadLocal.get());
        }).start();

    }

}
