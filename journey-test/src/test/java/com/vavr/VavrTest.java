package com.vavr;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/12/9.
 */
public class VavrTest {

    @Test
    public void test() {

        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
        System.out.println(java8._1);
        Tuple2<String, Integer> map = java8.map(s -> s.substring(2) + "vr", i -> i / 8);
        System.out.println(map._1);
        Tuple2<String, Integer> map1 = java8.map((s, i) -> Tuple.of(s.substring(2) + "vr", i / 8));
        System.out.println(map1._2);
    }

}
