package com.journey;

import org.junit.Test;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @author liuqingwen@qiyi.com
 * @date 2019-05-05 16:24
 */
public class RandomTest {

    @Test
    public void test() {



//        Stream.generate(() -> new Random().nextInt(200)).limit(20).forEach(
//                index -> System.out.println(new Random(System.currentTimeMillis() + index).nextInt(10))
//        );


        String[] args = new String[]{"1"};
        Stream.generate(() -> new Random().nextInt(200)).limit(20).forEach(
                index -> System.out.println(args[new Random(System.currentTimeMillis() + index).nextInt(args.length)])
        );

    }

}
