package com.journey.util;

import com.google.common.collect.Lists;
import com.journey.string2.Strings;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author liuqingwen
 * @date 2018/9/5.
 */
public class ListTest {

    CyclicBarrier cyclicBarrier = new CyclicBarrier(1000);

    @Test
    public void test() {

        List<String> collect = IntStream.range(1, 20).mapToObj(i -> String.valueOf(i)).collect(toList());
        System.out.println("初始长度：" + collect.size());
        for (int index = 0; index < 2000; index++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "-进入等待");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "-开始执行");
                    Collections.shuffle(collect);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            thread.setName("thread-"+index);
            thread.setDaemon(true);
            thread.start();
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(collect);
        System.out.println("打乱后Distinct长度：" + collect.stream().distinct().count());
    }


    @Test
    public void test2() {

        ArrayList<String> strings = Lists.newArrayList("1", "2", "3");
        System.out.println(Strings.joint(",", strings.toArray()));

    }

    @Test
    public void test3() {

        List<Integer> list = Lists.newArrayList(1, 2, 3);
        System.out.println(list.subList(1, 1));

    }

}
