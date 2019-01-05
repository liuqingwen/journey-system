package com.journey.basic;

import org.junit.Test;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

/**
 * @author liuqingwen
 * @date 2018/6/18.
 */
public class BasicJava {

    @Test
    public void test() {

        Enumeration<Driver> drivers = DriverManager.getDrivers();
        if (drivers != null) {
            while (drivers.hasMoreElements()) {
                System.out.println(drivers.nextElement());
            }
        }

    }

}
