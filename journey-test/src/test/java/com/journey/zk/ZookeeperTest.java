package com.journey.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.DefaultZookeeperFactory;
import org.apache.curator.utils.ZookeeperFactory;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import static org.apache.zookeeper.Watcher.Event.EventType.NodeDataChanged;

/**
 * @author liuqingwen
 * @date 2018/8/13.
 */
public class ZookeeperTest {

    protected ZookeeperFactory zookeeperFactory = new DefaultZookeeperFactory();
    protected ZooKeeper zooKeeper = null;
    private boolean onoff = false;

    static {
        System.out.println("我是静态代码块");
    }

    {
        System.out.println("我是代码块");
        if (onoff) {
            try {
                zooKeeper = zookeeperFactory.newZooKeeper("127.0.0.1:2181", 1 * 1000, (WatchedEvent event) -> System.out.println("1 -> " + event), false);
            } catch (Exception e) {}
        }
    }

    public ZookeeperTest(boolean onoff) {
        System.out.println("我是构造方法");
        this.onoff = onoff;
    }

    public static void main(String[] args) {

        ZookeeperTest zookeeperTest = new ZookeeperTest(true);
        zookeeperTest.test();

    }



    @Test
    public void test() {

        try {
            System.out.println("我是方法");
            onoff = true;
            System.out.println(zooKeeper.getChildren("/", (WatchedEvent event) -> System.out.println("2 -> " + event)));
            Object lock = new Object();
            synchronized (lock) {
                lock.wait();
            }

        } catch (Exception e) {

        }

    }

    @Test
    public void test2() {

        try {
            Stat stat = new Stat();
            byte[] data = zooKeeper.getData("/lnode", (WatchedEvent event) -> System.out.println("2 -> " + event), stat);
            System.out.println(new String(data));
            System.out.println(stat);
        } catch (Exception e) {

        }

    }

    @Test
    public void test3() {

        Stat stat = new Stat();
        try {
            byte[] data = zooKeeper.getData("/lnode", event -> {
                if (event.getType() == NodeDataChanged) {
                    try {
                        Stat stat1 = new Stat();
                        byte[] data2 = zooKeeper.getData("/lnode", false, stat1);
                        System.out.println("==" + new String(data2));
                        System.out.println("==" + stat1);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, stat);
            System.out.println("--" + new String(data));
            System.out.println("--" + stat);

            stat = zooKeeper.setData("/lnode", "kk".getBytes(), -1);
            System.out.println(stat);

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test4() {

        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("127.0.0.1:2182", new ExponentialBackoffRetry(1000, 2));
        curatorFramework.start();
        try {
            Stat stat = new Stat();
            byte[] bytes = curatorFramework.getData().storingStatIn(stat).usingWatcher((CuratorWatcher)(event) -> System.out.println(event)).forPath("/lnode");
            System.out.println(new String(bytes));
            System.out.println(stat);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
