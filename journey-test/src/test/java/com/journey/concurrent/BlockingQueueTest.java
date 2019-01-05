package com.journey.concurrent;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author liuqingwen
 * @date 2018/8/16.
 */
public class BlockingQueueTest {

    @Test
    public void test() {


        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1 << 4);
        queue.offer("liu");

        try {
            System.out.println(queue.take());
            System.out.println(queue.poll(1000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
