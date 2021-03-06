package com.metrics;

import com.codahale.metrics.*;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.name;

/**
 * @author liuqingwen
 * @date 2018/12/7.
 */
public class MetricsTest {

    static class GaugeTest {
        /**
         * 实例化一个registry，最核心的一个模块，相当于一个应用程序的metrics系统的容器，维护一个Map
         */
        private static final MetricRegistry metrics = new MetricRegistry();

        private static Queue<String> queue = new LinkedBlockingDeque<String>();

        /**
         * 在控制台上打印输出
         */
        private static ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();

        public static void main(String[] args) throws InterruptedException {
            reporter.start(3, TimeUnit.SECONDS);

            //实例化一个Gauge
            Gauge<Integer> gauge = new Gauge<Integer>() {
                @Override
                public Integer getValue() {
                    return queue.size();
                }
            };

            //注册到容器中
            metrics.register(name(GaugeTest.class, "pending-job", "size"), gauge);

            //测试JMX
            JmxReporter jmxReporter = JmxReporter.forRegistry(metrics).build();
            jmxReporter.start();

            //模拟数据
            for (int i=0; i<20; i++){
                queue.add("a");
                Thread.sleep(1000);
            }

        }
    }

    static class HistogramsTest {

        private static final MetricRegistry METRIC_REGISTRY = new MetricRegistry();

        private static ConsoleReporter reporter = ConsoleReporter.forRegistry(METRIC_REGISTRY).build();

        private static Histogram randomHistogram = METRIC_REGISTRY.histogram(name(HistogramsTest.class, "random"));

        public static void update(double random) {
            randomHistogram.update((long) random);
        }

        public static void main(String[] args) throws InterruptedException {

            reporter.start(3, TimeUnit.SECONDS);

            Random random = new Random(System.currentTimeMillis());

            for (;;) {
                update(random.nextInt(100));
                Thread.sleep(1000);
            }

        }

    }

}
