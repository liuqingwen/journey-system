package com.journey.redis;

import com.google.common.collect.Lists;
import com.util.Collections;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.List;

/**
 * @author liuqingwen
 * @date 2018/9/27.
 */
public class RedisTest {

    @Test
    public void test() {


        GenericObjectPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMinIdle(10);
        poolConfig.setMaxTotal(100);
        poolConfig.setMaxWaitMillis(10);
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(poolConfig, Lists.newArrayList(new JedisShardInfo("127.0.0.1", 6379)));

        ShardedJedis jedis = shardedJedisPool.getResource();

        for (;;) {

            List<String> brpop = jedis.brpop(0, "book-list");
            if (Collections.isNotBlank(brpop)) {
                System.out.println(brpop.get(1));
            }
        }

    }

}
