package com.journey.redis;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuqingwen on 2017/6/18.
 */
public class JedisTest extends JedisBase {

    private Logger logger = LoggerFactory.getLogger(JedisTest.class);

    @Autowired private JourneyRedis journeyRedis;

    @Test
    public void test1() {
        logger.info("启动完成");
    }

    @Test
    public void test() {
        new Thread(() -> {
            logger.info("我是{}", "java工作者");
        }).start();
    }

    public static Jedis createJedis(String host, int port) {
        Jedis jedis = new Jedis(host, port);
        return jedis;
    }

    @Test
    public void test2() {
        String value = journeyRedis.get("name");
        logger.info("这个是输出的结果 {} ", value);
    }

    @Test
    public void test3() {
        Map<String, String> map = ImmutableMap.of("name", "weixin", "age", "22", "qq", "757578255");
        journeyRedis.hmset("user", map);
        List<String> strings = journeyRedis.hmget("user", "name", "age", "qq");
        logger.info("返回结果 {} {}", new Object[]{strings, Joiner.on(" -> ").join(strings)});
        logger.info("返回结果长度 {}", journeyRedis.hlen("user"));
        logger.info("返回结果是否存在 {} ", journeyRedis.exists("user"));
        logger.info("返回结果 Key集合 {} ", journeyRedis.hkeys("user"));
        logger.info("返回结果 Value集合 {} ", journeyRedis.hvals("user"));
        journeyRedis.del("java framework");
        journeyRedis.lpush("java framework", "spring", "struts", "hibernate");
        logger.info("取出队列里面集合 {} ", journeyRedis.lrange("java framework", 0, -1));
        journeyRedis.del("java framework");
        journeyRedis.rpush("java framework", "spring", "struts", "hibernate");
        logger.info("取出队列里面集合 {} ", journeyRedis.lrange("java framework", 0, -1));

    }

    @Test
    public void test4() {
        String key = "users";
        journeyRedis.sadd(key, "liuling", "zhangsan", "lisi", "wangwu", "maliu", "who");
        logger.info("返回集合结果集 {} ", journeyRedis.smembers(key));
        logger.info("删除几个对象 {} ", journeyRedis.srem(key, "who"));
        logger.info("返回集合结果集 {} ", journeyRedis.smembers(key));
        logger.info("对象是否存在 {} ", journeyRedis.sismember(key, "who"));
        logger.info(" {} ", journeyRedis.srandmember(key));
        logger.info(" {} ", journeyRedis.srandmember(key));// 随机取出一个元素
        logger.info("返回元素个数 {} ", journeyRedis.scard(key));
    }

    @Test
    public void test5() {
        String key = "a";
        journeyRedis.del(key);
        journeyRedis.rpush(key, "1");
        journeyRedis.lpush(key, "6", "3", "19");
        logger.info("取出结果集 {} ", journeyRedis.lrange(key, 0, -1));
        logger.info("排序 {} ", journeyRedis.sort(key));
        logger.info("取出结果集 {} ", journeyRedis.lrange(key, 0, -1));
    }

    @Test
    public void test6() {
        String key = "chinese";
        journeyRedis.set(key, "张三，李四");
        logger.info("中文测试 {} ", journeyRedis.get(key));
    }

    public static void main(String[] args) {
//        System.out.println(createJedis("127.0.0.1", 6379).get("name"));


//        Preconditions.checkNotNull(null, "key 允许为空 %s %s", new Object[]{1, 2});
//
//        System.out.println(EAopLogTypes.fromCode(1).getDescription());


        Map<String, String> map = new HashMap<>();
        map.put("nickname", "刘刘刘刘庆文");
        map.put("userheadImage", "http://image.jiuxian.com/pic.png");

        System.out.println(JSON.toJSONString(map));


//        BigDecimal TEN_CENTS = new BigDecimal(".10");
//        int itemBount = 0;
//        BigDecimal funds = new BigDecimal("1.00");
//        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
//            itemBount ++;
//            funds = funds.subtract(price);
//        }
//        System.out.println(String.format("买了%1s块糖果", itemBount));
//        System.out.println(String.format("还是下%1s钱", funds));


//        List<Integer> list = ImmutableList.of(1, 2, 3, 4);
//        System.out.println(list.subList(1, list.size()));


    }


    @Test
    public void test7() {
        String key = "test7Arrays";
        List<String> list = Arrays.asList("1", "2", "3", "4");
        journeyRedis.remove(key);
        journeyRedis.lpush(key, list.toArray(new String[list.size()]));
        String s = journeyRedis.rpush(key);
        logger.info(s);
//        logger.info(""+journeyRedis.hlen(key));
        logger.info(""+journeyRedis.llen(key));
    }

    @Test
    public void test8() {

        ShardedJedis shardedJedis = journeyRedis.getShardedJedis();
        System.out.println(shardedJedis.get("name"));
        System.out.println(shardedJedis.getSet("name", "刘庆文"));
        System.out.println(shardedJedis.setnx("name1", "刘刘刘"));


        System.out.println(shardedJedis.del("name"));

    }

    @Test
    public void test9() {

        ShardedJedis shardedJedis = journeyRedis.getShardedJedis();
        shardedJedis.hset("hset_java", "java1", "liu");
        shardedJedis.hset("hset_java", "java2", "liu2");
        shardedJedis.hset("hset_java", "java1", "liu3");
        System.out.println(shardedJedis.hgetAll("hset_java"));

    }

}
