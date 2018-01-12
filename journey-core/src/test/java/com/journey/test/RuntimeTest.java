package com.journey.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuqingwen on 2017/9/6.
 */
public class RuntimeTest {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
    private static Thread thread = new Thread(new MyRunnable());

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (queue != null) {
                for (;queue != null && !queue.isEmpty();) {
                    try {Thread.sleep(500);} catch (InterruptedException e) {}
                    if (queue == null || queue.isEmpty()) {
                        System.out.println("队列数据操作完成");
//                        thread.interrupt();
                        break;
                    }
//                    System.out.println(queue.poll());
                    if (!thread.isAlive()) {
                        thread.start();
                    }
                }
            }
        }));
    }


    public static void main(String[] args) throws Exception {

        int count = 0;
        while (true) {
            Thread.sleep(1000);
            System.out.println("我已经等了"+count+"秒钟");
            if (count > 9) {
                System.out.println("我的循环遍历结束");
                break;
            }
            count++;
            queue.add(String.valueOf(count));
        }
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {

            while (true) {

                String tmp = "";
                try {
                    Thread.sleep(1000);
                    tmp = queue.poll(1000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("MyRunnable ： 我开始输出了，各个暴击 ： "+tmp);
            }
        }
    }


}
