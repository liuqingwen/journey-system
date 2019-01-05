package com.journey.test;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2017/12/4.
 */
public class BooleanTest {

    @Test
    public void test() {

        int i = 0;
        System.out.println(1 == 1 || (i = 1) == 1);
        System.out.println(i);
        System.out.println(1 == 1 | (i = 2) == 1);
        System.out.println(i);

        System.out.println(1 != 1 && (i = 3) == 1);
        System.out.println(i);
        System.out.println(1 != 1 & (i = 4) == 1);
        System.out.println(i);
    }


}
