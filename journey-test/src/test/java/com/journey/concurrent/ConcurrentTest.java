package com.journey.concurrent;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuqingwen
 * @date 2018/8/31.
 */
public class ConcurrentTest {

    @Test
    public void test() {

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        String s = concurrentHashMap.putIfAbsent("k", "c");
        String s2 = concurrentHashMap.putIfAbsent("k", "c");
        System.out.println(s);
        System.out.println(s2);

    }

}
