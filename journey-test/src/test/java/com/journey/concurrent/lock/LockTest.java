package com.journey.concurrent.lock;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuqingwen
 * @date 2018/9/18.
 */
public class LockTest {

    // 锁优化
    // 1. 自旋(自适应自旋) 2. 锁消除 3. 锁粗化 4. 轻量级锁 5. 偏向锁

    // -XX:PreBlockSpin 自旋次数

    // 轻量级锁
    // Object Header 分为两部分

    // 第一部分用于存储对象自身的运行时数据，如哈希码(HashCode)、GC 分代年龄(Generational GC Age)等，称为"Mark Word"。(这部分数据的长度在 32 位和 64 位的虚拟机中分别为 32 个和 64 个 Bits)
    // 它是实现轻量级锁和偏向锁的关键

    // 另外一个部分用于存储指向方法区对象类型数据的指针，如果是数组对象的话，还会有一个额外的部分用于存储数组长度。

    // 对象头信息是与对象自身定义的数据无关的额外存储成本，考虑到虚拟机的空间效率，Mark Word 被设计成一个非固定的数据结构以便在极小的空间内存储尽量多的信息，它会根据对象的状态复用自己的存储空间。
    // 例如 在 32 位的 HotSpot 虚拟机中对象未被锁定的状态下，Mark Word 的 32 个 Bits 空间中的 25Bits 用于存储对象的哈希码(HashCode)，4Bits 用于存储对象的分代年龄，2Bits 用于存储锁标志位，1Bits 固定为 0，
    // 在其他状态(轻量级锁、重量级锁、GC标志、可偏向锁)下对象的存储内容如下所示
    // 存储内容                                      标志位          状态
    // 对象哈希码、对象分代年龄                         01             未锁定
    // 指向锁记录的指针、                              00             轻量级锁
    // 指向重量级锁的指针                              10             膨胀(重量级锁)
    // 空，不需要记录信息                              11             GC 标志
    // 偏向线程 ID、偏向时间戳、对象分代年龄              01             可偏向

    // 如果进入同步块的时候，如果此同步对象没有被锁定，虚拟机首先在当前栈针中建立一个锁记录(Lock Record)的空间，用于存储锁对象目前的 Mark Word 的拷贝，名为 Displaced Mark Word。
    // 然后通过 CAS 来尝试更新对象的 Mark Word 的存储锁标志位。
    // 如果更新成功了，那么就拥有了这个对象的锁
    // 如果失败了，首先检查对象的 Mark Word 是否已经指向了当前线程的栈针，如果是，就说明已经拥有了对象锁。如果不是，说明这个锁对象被其他线程抢占了，如果有两条以上的线程争用同一个锁，那轻量级锁就会膨胀为重量级锁，锁标志位改为 10，Mark Word 中的存储就是指向重量级锁(互斥量)的指针，后面等待锁的线程也要进入阻塞状态。


    // -XX:_UseBiasedLocking 开启偏向锁


//    春天，忧伤以及空空荡荡；我伸出双手，丢掉了什么；又抓住些什么。 在寒冷的小屋；像圣徒一样读书；什么也不能把我拯救。 长期的寂寞使人发疯；下一个我将把谁干掉；想象中，我曾埋葬过多少赫赫帝王。 其实我多愿意是个快活的小流氓；歪戴帽子，吹着口哨；踩一辆破车子去漫游四方。 也许我该怒吼；也许我该冷笑；也许我该躺下来，好好睡一觉。

    volatile int num = 0;

    @Test
    public void test() {

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();

        try {

            Thread thread = new Thread(() -> {
                while (true) {
                    reentrantLock.lock();
                    if (num > 8) {
                        break;
                    }
                    System.out.println("thread - " + (++num));
                    try {
                        condition2.signal();
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        reentrantLock.unlock();
                    }

                }
            });

            Thread thread2 = new Thread(() -> {
                while (true) {
                    reentrantLock.lock();
                    if (num > 8) {
                        break;
                    }
                    System.out.println("thread2 - " + (++num));
                    try {
                        condition.signal();
                        condition2.await();
                    } catch (InterruptedException e) {}
                    finally {
                        reentrantLock.unlock();
                    }
                }
            });

            thread.start();
            thread2.start();


            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {}
        } finally {

        }
    }

    public void pri() {
        System.out.println(num++);
    }

    @Test
    public void test2() {




    }

    class Run implements Runnable {

        int num = 0;

        @Override
        public void run() {

        }

        protected synchronized void pri() {

        }
    }

}
