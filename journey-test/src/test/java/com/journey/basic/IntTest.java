package com.journey.basic;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/6/20.
 */
public class IntTest {

    @Test
    public void test() {

        System.out.println(Integer.MAX_VALUE);
        System.out.println((1 << 31) - 1);
        System.out.println((Integer.toBinaryString((1 << 31))));
        System.out.println((Integer.toBinaryString((1 << 31))).length());
        System.out.println((Integer.toBinaryString((1 << 31) - 1)));
        System.out.println((Integer.toBinaryString((1 << 31) - 1)).length());

}

}
