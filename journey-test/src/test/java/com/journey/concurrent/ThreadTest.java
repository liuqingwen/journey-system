package com.journey.concurrent;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/9/12.
 */
public class ThreadTest {

    @Test
    public void test() {

        synchronized (this) {

        }

        new Thread(() -> {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        });

    }

}
