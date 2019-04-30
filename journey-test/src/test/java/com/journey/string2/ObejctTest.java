package com.journey.string2;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2019/1/23.
 */
public class ObejctTest {

    @Test
    public void test() {

        int arg = 2;
        Integer arg2 = 2;
        Object arg3 = arg2;

        System.out.println("---------------------");

        System.out.println(equals2(arg, arg2));
        System.out.println(equals3(arg, arg2));

        System.out.println("---------------------");

        System.out.println(equals2(arg, arg3));
        System.out.println(equals3(arg, arg3));

        System.out.println("---------------------");

        System.out.println(equals(arg2, arg3));
        System.out.println(equals(arg2, arg3));

        System.out.println("---------------------");

        System.out.println(equals(1, "ss"));
        System.out.println(equals("ss", 1));
    }

    public static boolean equals2(Object arg, Object arg2) {
        return arg == arg2;
    }

    public static boolean equals3(Object arg, Object arg2) {
        return arg == arg2 || ((arg != null && arg2 != null) && arg.equals(arg2));
    }

    public static final boolean equals(Object arg1, Object arg2) {
        return (arg1 != null && arg2 != null) && StringUtils.isNumeric(arg1.toString()) && (arg1 == arg2 || arg1.equals(arg2));
    }

}
