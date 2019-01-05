package com.journey.thread;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author liuqingwen
 * @date 2018/9/29.
 */
public class ThreadPoolExecutorExtend extends ThreadPoolExecutor {

//    private static final Unsafe UNSAFE;
//    private static final long workersOffset;
//
//    static {
//        try {
//            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//            theUnsafe.setAccessible(true);
//            UNSAFE = (Unsafe) theUnsafe.get(null);
//            workersOffset = UNSAFE.objectFieldOffset(ThreadPoolExecutor.class.getDeclaredField("workers"));
//
//            UNSAFE.getObject()
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            throw new Error(e);
//        }
//    }

    private static Map<String, Integer> countMap = new ConcurrentHashMap<>();

    public ThreadPoolExecutorExtend(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public ThreadPoolExecutorExtend(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public ThreadPoolExecutorExtend(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public ThreadPoolExecutorExtend(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        countMap.put(t.getName(), countMap.getOrDefault(t.getName(), 0) + 1);
    }

    public static void printWorkers() {
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

}
