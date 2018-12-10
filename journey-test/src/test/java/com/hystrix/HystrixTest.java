package com.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

import java.util.concurrent.TimeUnit;

/**
 * @author liuqingwen
 * @date 2018/7/20.
 */
public class HystrixTest {

    public static class MyHystrixCommand extends HystrixCommand<String> {

        private String name;

        protected MyHystrixCommand(String name) {
            super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))  //必须
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ExampleGroup-pool"))  //可选,默认 使用 this.getClass().getSimpleName();
                    .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(4)));

//            Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("MyHystrixCommandGroup")).andThreadPoolPropertiesDefaults(
//                    HystrixThreadPoolProperties.Setter().withKeepAliveTimeMinutes()
//            );

            this.name = name;

        }

        @Override
        protected String run() throws Exception {
            System.out.println("running");
            TimeUnit.MILLISECONDS.sleep(1000);
            return "Hello " + name + "!";
        }

//        @Override
//        protected String getFallback() {
//            return "哦，我失败了";
//        }
    }

    public static void main(String[] args) {

//        String name = new MyHystrixCommand("liu").execute();
//        System.out.println(name);

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

    }


    class MyThread extends Thread {

        public void operate() {
            this.getName();
        }

    }
}
