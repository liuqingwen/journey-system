package com.service;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * @author liuqingwen
 * @date 2018/11/30.
 */
public class ServiceLoaderTest {

    @Test
    public void test() {

        ServiceLoader<Interface2> interface2s = ServiceLoader.load(Interface2.class);
        for (Interface2 interface2 : interface2s) {
            System.out.println(interface2.getClass());
        }

    }

}
