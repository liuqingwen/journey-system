package com.journey.test;

/**
 * @author liuqingwen
 * @date 2017/10/31.
 */
public class FinllayTest {

    public static void main(String[] args) {

        System.out.println(get());

    }

    private static String s = "1";
    public static String get() {
        try {
            s = "2";
            return s;
        }finally {
            s = null;
        }
    }

}
