package com.journey.redis;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.ShardedJedis;

/**
 * @author liuqingwen
 * @date 2018/3/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public abstract class JedisBase {

    @Autowired protected JourneyRedis journeyRedis;
    protected static ShardedJedis shardedJedis;
    {
        shardedJedis = journeyRedis.getShardedJedis();
    }

}
