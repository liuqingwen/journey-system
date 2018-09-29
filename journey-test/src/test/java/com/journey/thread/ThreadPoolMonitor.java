package com.journey.thread;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuqingwen
 * @date 2018/9/29.
 */
public class ThreadPoolMonitor implements Runnable {

    private ThreadPoolExecutor threadPoolExecutor;
    private long time;
    private TimeUnit timeUnit;

    public ThreadPoolMonitor(ThreadPoolExecutor threadPoolExecutor, long time, TimeUnit timeUnit) {
        this.threadPoolExecutor = threadPoolExecutor;
        this.time = time;
        this.timeUnit = timeUnit;
    }

    @Override
    public void run() {
        for (;;) {
            try {
                timeUnit.sleep(time);
                System.out.println();
                System.out.println(toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return toString(this.threadPoolExecutor);
    }

    public static String toString(ThreadPoolExecutor threadPoolExecutor) {
        return new StringBuilder(1 << 6).append("Current Pool : ").append(threadPoolExecutor.getPoolSize())
                .append(" - CorePoolSize : ").append(threadPoolExecutor.getCorePoolSize())
                .append(" - MaximumPoolSize : ").append(threadPoolExecutor.getMaximumPoolSize())
                .append(" - ActiveTaskCount : ").append(threadPoolExecutor.getActiveCount())
                .append(" - CompletedTaskCount : ").append(threadPoolExecutor.getCompletedTaskCount())
                .append(" - TotalTaskCount : ").append(threadPoolExecutor.getTaskCount())
                .append(" - isTerminated : ").append(threadPoolExecutor.isTerminated()).toString();
    }

    public void printWorkers() {
        if (this.threadPoolExecutor instanceof ThreadPoolExecutorExtend) {
            ((ThreadPoolExecutorExtend) this.threadPoolExecutor).printWorkers();
        }
    }
}
