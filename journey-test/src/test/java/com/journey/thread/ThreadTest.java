package com.journey.thread;

import org.junit.Test;
import sun.misc.Unsafe;
import sun.tools.jconsole.Worker;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author liuqingwen
 * @date 2018/9/19.
 */
public class ThreadTest {

    // linux 线程模型

    // 进程 线程(KLT-内核线程) 轻量级进程(LWP) 用户线程(UT)

    // 内核线程
    // 内核线程就是内核的分身，一个分身可以处理一件特定事情，这在处理异步事件如异步 IO 时特别有用。内核线程使用是廉价的，唯一使用的资源就是内核栈和上下文切换时保存寄存器的空间。支持多线程的内核叫做多线程内核(Multi-Threads kernel)。

    // 轻量级进程
    // 轻量级进程是一种由内核支持的用户线程，他是基于内核线程的高度抽象，因此只有先支持内核线程，才能有轻量级进程。这样每个进程都有一个或者多个轻量级进程，一个轻量级进程都由一个内核线程支持，这种就是一对一线程模型。用这种实现的操作系统中，轻量级进程被称为用户进程。
    // 由于每一个轻量级进程(LWP)都与一个内核线程关联，因此每个轻量级进程都一个独立的线程调度单元。这样即使一个轻量级进程阻塞，也不会影响整个进程的执行。
    // 轻量级进程有局限性。首先，大多数轻量级进程(LWP)的操作(如建立、析构和同步)等都需要进行系统调用。系统调用的代价是相对较高的(需要在 user mode 和 kernel mode 来回切换)，其次轻量级进程是需要内核线程来支持的，因此轻量级进程是要消耗内核资源的(如内核栈空间)，因此一个系统不能支持大量的轻量级进程。

    // 用户线程
    // 轻量级进程本质上是属于用户线程，但是轻量级进程始终还是建立在内核之上的，因此轻量级进程很多操作还是需要系统调用，因此效率不高。
    // 而这里的用户线程，是完全建立在用户内存空间的线程库，用户线程的建立、销毁、同步，调度完全在用户空间完成，不需要内核的帮助。因此这种线程的操作是极其快速且低消耗的。
    // 缺点是对多 cpu 支持不好，因为用户线程是完全不在内核控制范围内的，所以对 cpu 的分配无法做到。

    // 轻量级基础+用户线程(加强版的线程模型)

    // 教科书定义：进程是资源管理的最小单位，线程是程序执行的最小单位。在操作系统上，从进程演化出线程，最主要的目的就是更好的支持SMP及减少(线程/进程)上下文切换的开销。
    // 无论按照怎么分法，一个进程都需要至少一个线程来作为它的命令执行体。
    // 进程管理资源(cpu、内存、文件等)，将线程分配到某个 cpu 上执行，如果运行在 SMP 机器上，就可以用多个 cpu 执行线程，达到了并行的最大化，以提高效率。

    // Why Thread
    // 1. 现实中很多需要并发处理的任务，如数据库的服务端、网络服务器和大容量计算等
    // 2. 传统的 Unix 进程是单线程的，单线程意味着需要顺序执行，不能并发。即同一时刻只能运行在一个处理器上，因此不能充分利用多处理器框架(SMP)的机器。
    // 3. 如果采用多进程的方法，有如下问题：
    // 1) fork 一个子进程的消耗是很大的，fork 是一个昂贵的系统调用，即使使用现代的写时复制(Copy on Write)技术。
    // 2）各个进程之前有自己的独立的地址空间，进程间的协作需要复杂的 IPC 技术，如消息传递和内存共享等。

    @Test
    public void test() {

        Random random = new Random(System.currentTimeMillis());

        ThreadPoolExecutor executorService = new ThreadPoolExecutorExtend(10, 10, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1_000_000), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        ThreadPoolMonitor threadPoolMonitor = new ThreadPoolMonitor(executorService, 1000, TimeUnit.MILLISECONDS);
        new Thread(threadPoolMonitor).start();

        int executeCount = 100_000;

        CountDownLatch countDownLatch = new CountDownLatch(executeCount);

        for (int index = 0; index < executeCount; index++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        try {
            countDownLatch.await();
//            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ThreadPoolMonitor.toString(executorService));
        threadPoolMonitor.printWorkers();

        System.out.println("运行结束");
    }
}
