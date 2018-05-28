package com.journey.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author liuqingwen
 * @date 2018/5/27.
 */
public class JvmTest {

    List<int[]> list = new ArrayList<>();
    private static Random random = new Random();
    Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2, Executors.defaultThreadFactory());

    public void test() {

        executor.execute(() -> {
            while (true) {

                list.add(new int[random.nextInt(10)]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
