package com.journey.test.redis.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.Test;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

}
