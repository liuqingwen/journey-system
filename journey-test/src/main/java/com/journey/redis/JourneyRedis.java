package com.journey.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuqingwen on 2017/6/18.
 */
public class JourneyRedis implements InitializingBean, DisposableBean {

    Logger logger = LoggerFactory.getLogger(JourneyRedis.class);

    @Autowired private ShardedJedisPool shardedJedisPool;

    public void destroy() throws Exception {
        logger.info("销毁了");
    }

    public void afterPropertiesSet() throws Exception {
        logger.info("初始化");
    }

    public ShardedJedis getShardedJedis() {
        return shardedJedisPool.getResource();
    }

    public void set(String key, String value) {
        this.getShardedJedis().set(key, value);
    }

    public String get(String key) {
        return this.getShardedJedis().get(key);
    }

    public void hmset(String key, Map<String, String> value) {
        this.getShardedJedis().hmset(key, value);
    }

    public List<String> hmget(String key, String... fields) {
        return this.getShardedJedis().hmget(key, fields);
    }

    public long hlen(String key) {
        return this.getShardedJedis().hlen(key);
    }

    public boolean exists(String key) {
        return this.getShardedJedis().exists(key);
    }

    public Set<String> hkeys(String key) {
        return this.getShardedJedis().hkeys(key);
    }

    public List<String> hvals(String key) {
        return this.getShardedJedis().hvals(key);
    }

    public void lpush(String key, String... value) {
        this.getShardedJedis().lpush(key, value);
    }

    public long llen(String key) {
        return this.getShardedJedis().llen(key);
    }

    public String rpush(String key) {
        return this.getShardedJedis().rpop(key);
    }

    public List<String> lrange(String key, int start, int end) {
        return this.getShardedJedis().lrange(key, start, end);
    }

    public long del(String key) {
        return this.getShardedJedis().del(key);
    }

    public void rpush(String key, String... values) {
        this.getShardedJedis().rpush(key, values);
    }

    public void sadd(String key, String... members) {
        this.getShardedJedis().sadd(key, members);
    }

    public long srem(String key, String... members) {
        return this.getShardedJedis().srem(key, members);
    }

    public Set<String> smembers(String key) {
        return this.getShardedJedis().smembers(key);
    }

    public boolean sismember(String key, String member) {
        return this.getShardedJedis().sismember(key, member);
    }

    public String srandmember(String key) {
        return this.getShardedJedis().srandmember(key);
    }

    public long scard(String key) {
        return this.getShardedJedis().scard(key);
    }

    public List<String> sort(String key) {
        return this.getShardedJedis().sort(key);
    }

    public void remove(String key) {
        this.getShardedJedis().del(key);
    }


}
