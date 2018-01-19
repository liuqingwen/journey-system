package com.journey.test;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * @author liuqingwen
 * @date 2017/12/3.
 */
public class BinaryTest {

    @Test
    public void test() {
        byte b = (byte) 0xf1; // 8 bit

//        A = 10 ; B = 11 ; C = 12 ; D = 13 ; E = 14 ; F = 15;
//        128 64 32 16 8 4 2 1
//        1 1 1 1 0 0 0 1 = 1 + 16 + 32 + 64 + 128 = 241; ==> -15
//        0 0 0 0 1 1 1 1 = 15
//        1 1 1 1 1 1 1 1 | 1 1 1 1 1 1 1 1 | 1 1 1 1 1 1 1 1 | 1 1 1 1 0 0 0 1 ==> -15 >>> 4 ==> 0 0 0 0 1 1 1 1 | 1 1 1 1 1 1 1 1 | 1 1 1 1 1 1 1 1 | 1 1 1 1 1 1 1 1 ==>
//        0 0 0 0 1 1 1 1 = 15 >> 4 = 0



//        0 0 0 0 1 0 0 0 | 0 0 0 0 0 0 0 0 | 0 0 0 0 0 0 0 0 | 0 0 0 0 0 1 1 1
        System.out.println(b);
        System.out.println(b >> 4);
        System.out.println((b >>> 4));
        System.out.println(DecimalFormat.getInstance().format(Math.pow(2, 27)));
        System.out.println(((0xf1) >>> 4));
        System.out.println(0xf1);


//        268435455
//        268435456
    }


}
