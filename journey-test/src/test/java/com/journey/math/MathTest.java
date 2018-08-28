package com.journey.math;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/7/17.
 */
public class MathTest {

    @Test
    public void test() {

        System.out.println(Math.log(2));

    }

    @Test
    public void test2() {

        System.out.println(Math.abs(-1));

    }

    @Test
    public void test3() {

        System.out.println(Math.floor(5.4));
        System.out.println(Math.floor(5.6));

        System.out.println(Math.round(5.4));
        System.out.println(Math.round(5.6));

        System.out.println(Math.ceil(5.4));
        System.out.println(Math.ceil(5.6));


        int count = 0;
        count += 5.5;
        System.out.println(count);
    }

}
