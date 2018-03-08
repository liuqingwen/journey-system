package com.journey.redis;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/3/7.
 */
public class JedisCommandsTest extends JedisBase {

    @Test
    public void append() {

        String key = "cache-tool";
        Boolean exists = shardedJedis.exists(key);
        System.out.println(exists);
        Long append = shardedJedis.append(key, "jedis");
        System.out.println(append);

    }


}
