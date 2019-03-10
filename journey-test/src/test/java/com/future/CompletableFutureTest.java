package com.future;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author liuqingwen@qiyi.com
 * @date 2019/2/11 下午4:06
 */
public class CompletableFutureTest {

    @Test
    public void other_test() {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        System.out.println(random.nextInt(100, 1000));

    }

    @Test
    public void test() {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        List<CompletableFuture<Void>> collect = Stream.of(1, 2, 3).parallel().map(it -> CompletableFuture.<Integer>runAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(100, 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        })).collect(Collectors.toList());

        for (CompletableFuture<Void> future : collect) {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2() {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        ExecutorService executorService = new ThreadPoolExecutor(10, 100, 0, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        List<CompletableFuture<Void>> collect = Stream.of(1, 2, 3).parallel().map(it -> CompletableFuture.<Integer>runAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(100, 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }, executorService)).collect(Collectors.toList());

        for (CompletableFuture<Void> future : collect) {
            try {
                if(future.isDone()) {
                    future.get();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

}
