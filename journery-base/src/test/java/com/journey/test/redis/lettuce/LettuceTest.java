package com.journey.test.redis.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.util.stream.Collectors.toList;

/**
 * @author liuqingwen
 * @date 2018/4/19.
 */
public class LettuceTest {

    @Test
    public void test() {

        RedisClient redisClient = RedisClient.create("redis://localhost:6379/0");
        StatefulRedisConnection<String, String> redisConnect = redisClient.connect();
        RedisCommands<String, String> redisCommands = redisConnect.sync();
//        redisCommands.set("name", "liuqingwen");
//        System.out.println(redisCommands.get("name"));
//
//        redisCommands.lpush("lname", "one");
//        redisCommands.lpush("lname", "two");
//
//        System.out.println(redisCommands.lindex("lname", 0));
//
//implemented
//        System.out.println(redisCommands.lrange("lname", 0,  0));
//        System.out.println(redisCommands.lrange("lname", 1,  1));
//
//
//
        System.out.println(redisCommands.lrange("lname", 0,  -1));
//
//
//
//
//
        System.out.println(redisCommands.keys("*"));
//        System.out.println(redisCommands.flushall());

        redisConnect.close();
        redisClient.shutdown();
    }

    @Test
    public void test2() {

        RedisURI redisURI = RedisURI.create("localhost", 6379);
        redisURI.setDatabase(0);
        RedisClient redisClient = RedisClient.create(redisURI);
        redisClient.setDefaultTimeout(Duration.ofSeconds(20));

        try (StatefulRedisConnection<String, String> redisConnection = redisClient.connect()){
            RedisCommands<String, String> redisCommands = redisConnection.sync();

            System.out.println(redisCommands.keys("*"));
        }

        redisClient.shutdown();
    }

    @Test
    public void test3() {

        RedisURI redisURI = RedisURI.builder().withHost("localhost").withPort(6379).withDatabase(0).build();
        RedisClient redisClient = RedisClient.create(redisURI);
        redisClient.setDefaultTimeout(Duration.ofSeconds(20));
        try (StatefulRedisConnection<String, String> redisConnection = redisClient.connect()) {
            RedisCommands<String, String> redisCommands = redisConnection.sync();

            System.out.println(redisCommands.keys("*"));
        }

        redisClient.shutdown();
    }

    @Test
    public void test4() {

        RedisURI redisURI = RedisURI.create("redis://localhost:6379/0");
        RedisClient redisClient = RedisClient.create(redisURI);
        redisClient.setDefaultTimeout(Duration.ofSeconds(20));

        try (StatefulRedisConnection<String, String> redisConnection = redisClient.connect()) {
            RedisCommands<String, String> redisCommands = redisConnection.sync();

            System.out.println(redisCommands.keys("*"));
        }

        redisClient.shutdown();
    }

    @Test
    public void test5() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = new CompletableFuture<>();
        System.out.println(future.isDone());

        future.complete("my complete");

        System.out.println(future.isDone());
        System.out.println(future.get());
    }

    @Test
    public void test6() {

        final CompletableFuture<String> future = new CompletableFuture<>();

        future.thenRun(() -> {
            try {
                System.out.println(future.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(future.isDone());

        future.complete("my complete");

        System.out.println(future.isDone());
    }


    @Test
    public void test7() {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Double> future = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return 0.0;
            }
        });

        // 做其他更重要的事情
        // doSomething()

        try {
            Double result = future.get(10, TimeUnit.SECONDS);
            System.out.println(result);

            // 再做组合操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test8() {

        List<CompletableFuture<Integer>> collect = Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(index -> CompletableFuture.supplyAsync(() -> index * index)).collect(toList());
        long count = collect.stream().map(CompletableFuture::join).count();
        System.out.println(count);

    }

}


class Shop {

    private String productName;

    public Shop(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public double getPrice(String productName) {
        return calculatePrice(productName);
    }

    public Future<Double> getPriceAsync(final String productName) {

        CompletableFuture<Double> priceCompletableFuture = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(productName);
                priceCompletableFuture.complete(price);
            } catch (Exception e) {
                priceCompletableFuture.completeExceptionally(e);
            }
        }).start();

        return priceCompletableFuture;
    }

    private double calculatePrice(String productName) {
        delay();
        return new Random(LocalDateTime.now().getNano()).nextDouble() * productName.charAt(0);
    }

    @Test
    public void test() {

        ArrayList<Shop> shops = new ArrayList<Shop>() {{
            add(new Shop("Java"));
            add(new Shop("C ++"));
        }};

        List<String> collect1 = shops.stream().parallel()
                .map(shop -> String.format("%s price is %.2f", shop.getProductName(), shop.getPrice(shop.getProductName())))
                .collect(toList());

        List<CompletableFuture<String>> collect = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getProductName(), shop.getPrice(shop.getProductName()))))
                .collect(toList());

        List<String> collect2 = collect.stream().map(CompletableFuture::join).collect(toList());

    }

    @Test
    public void test2() {

        ArrayList<Shop> shops = new ArrayList<Shop>() {{
            add(new Shop("Java"));
            add(new Shop("C ++"));
        }};

        // N = Ncpu * Ucpu * (1 + W/C)
        // Ncpu cpu数量
        // Ucpu 期望cpu利用率
        // W/C 等待时间与计算时间比率

        Executor executor = Executors.newFixedThreadPool(100, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread();
                thread.setDaemon(true);
                return thread;
            }
        });

    }
}
