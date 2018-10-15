package com;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/10/15.
 */
public class SystemTest {

    @Test
    public void test() {

        System.out.println(System.getProperty("system.home", "home"));
        System.out.println(System.getProperty("user.home"));


    }

}
