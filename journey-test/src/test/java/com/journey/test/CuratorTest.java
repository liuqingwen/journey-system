package com.journey.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuqingwen
 * @date 2018/1/8.
 */
public class CuratorTest {

    private Logger logger = LoggerFactory.getLogger(CuratorTest.class);
    private ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3, 20000);
    private CuratorFramework client = CuratorFrameworkFactory.builder().connectString("zk1.jxw.9ijx.com:2181").retryPolicy(retryPolicy).build();

    @Test
    public void test() {

        try {
            client.start();
            List<String> paths = client.getChildren().forPath("/zookeeper/quota");
            logger.info("Zookeeper节点/appconfig 下Node节点 {}", paths);
        }catch (Exception e) {
            logger.error("异常了", e);
        }
    }

    @Test
    public void test1() {
        try {
            client.start();
            List<String> paths = client.getChildren().forPath("/appconfig");
            logger.info("Zookeeper节点/appconfig 下Node节点 {}", paths);
            paths.stream().map(path -> this.getChildren(client, this.directory(path))).forEach(path -> logger.info("Node : {}", path));
        } catch (Exception e) {
            logger.error("异常了", e);
        }
    }

    @Test
    public void test2() {

        try {
            client.start();
            Stat stat = new Stat();
            byte[] bytes = client.getData().storingStatIn(stat).forPath("/zookeeper/quota");
            logger.info("Zookeeper节点/appconfig 下 Node保存数据 {}, Node状态 {}", new Object[]{new String(bytes), stat == null ? null : JSON.toJSONString(stat)});
        }catch (Exception e) {
            logger.error("异常了", e);
        }
    }

    private List<String> getChildren(CuratorFramework client, String path) {

        try {
            return client.getChildren().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public String directory(String path) {

        if (StringUtils.isBlank(path)) {
            return "/";// 根目录
        }

        return path.indexOf("/") == 0 ? path : "/".concat(path);
    }

}
