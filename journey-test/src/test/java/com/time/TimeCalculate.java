package com.time;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuqingwen
 * @date 2018/12/14.
 */
public final class TimeCalculate {

    private static Map<String, Long> timeMap = new ConcurrentHashMap<>();

    public static final int MILLISECONDS = 1;
    public static final int SECONDS = 1 * 1000;
    public static final int MINUTES = 1 * 1000 * 60;

    public static String mark() {
        String uuid = UUID.randomUUID().toString();
        timeMap.put(uuid, System.currentTimeMillis());
        return uuid;
    }

    public static long calculate(String uuid) {
        long result = System.currentTimeMillis() - timeMap.get(uuid);
        timeMap.remove(uuid);
        return result;
    }

    public static long seconds(String uuid) {
        return calculate(uuid) / SECONDS;
    }

}
