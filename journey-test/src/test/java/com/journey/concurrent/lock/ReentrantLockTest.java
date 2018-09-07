package com.journey.concurrent.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuqingwen
 * @date 2018/9/7.
 */
public class ReentrantLockTest {

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Object lock = new Object();
    private volatile int state = 0;

    @Test
    public void test() {

        for (int index = 1; index <= 2; index++) {
            final int indexTmp = index;
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " -> 开始执行了");
                update2(indexTmp);
                System.out.println(Thread.currentThread().getName() + " -> 执行完了");
            });
            thread.setName("ReentrantLockTest-" + index);
            thread.setDaemon(true);
            thread.start();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void update(int state) {
        try {
            reentrantLock.lock();
            this.state += state;
            int i = 1/0;
            reentrantLock.unlock();
        } catch (Exception e) {
        }
    }

    private void update2(int state) {
        synchronized (lock) {
            try {
                this.state += state;
                int i = 1/0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {

        Thread thread = new Thread(() -> {
            while (true) {
                desc();
            }
        });
        thread.setName("酒仙一号");
        thread.start();
        Thread thread2 = new Thread(() -> {
            while (true) {
                desc2();
            }
        });
        thread2.setName("酒仙二号");
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Condition condition = reentrantLock.newCondition();
    private Condition condition2 = reentrantLock.newCondition();
    private boolean bl = true;
    private void desc() {
        try {
            reentrantLock.lock();
            while (bl) {
                condition.await();
            }
            this.state ++;
            System.out.println("desc - " + Thread.currentThread().getName() + "-" + this.state);
            this.bl = true;
            TimeUnit.SECONDS.sleep(1);
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void desc2() {
        try {
            reentrantLock.lock();
            while (!bl) {
                condition2.await();
            }
            this.state ++;
            System.out.println("desc2 - " + Thread.currentThread().getName() + "-" + this.state);
            this.bl = false;
            TimeUnit.SECONDS.sleep(1);
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
