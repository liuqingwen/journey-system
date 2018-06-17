package com.journey.vola;

/**
 * @author liuqingwen
 * @date 2018/6/14.
 */
public class Counter {

    public static volatile int count = 0;

    public static void main(String[] args) {
        Counter.count();
    }

    public static void inc() {
        // 这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        count++;
        System.out.println(count);
    }

    public static void count() {
        // 同时启动1000个线程，去进行i++计算，看看实际结果
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.inc();
                }
            }).start();
        }
        // 这里每次运行的值都有可能不同,可能不为1000
        System.out.println("运行结果:Counter.count=" + Counter.count);
    }

}

