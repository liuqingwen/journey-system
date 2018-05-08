package com.journey.test;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void test2() {

        System.out.println(1 << 14);
        System.out.println(Integer.toBinaryString(1 << 14));


        System.out.println(7 & 3);
        System.out.println(7 % 3);
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(3));

        Map<Integer, Object> map = new HashMap<>(8);
        map.put(3, "liu");
        System.out.print(map);

    }

    @Test
    public void test3() {

        System.out.println(Integer.toString(15, 2));
        System.out.println(Integer.toBinaryString(15));

    }

    @Test
    public void test4() {

        System.out.println(8 ^ 7);
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(5));


        System.out.println(3_000_000 * 255 / 1_000 / 1_000);

    }

    @Test
    public void test5() {

        System.out.println(2 & 6);
        System.out.println(2 & 6 & 6);

    }

    @Test
    public void test6() {

        System.out.println(Integer.toBinaryString(((int) Math.pow(2, 0)) - 1));
        System.out.println(Integer.toBinaryString(((int) Math.pow(2, 1)) - 1));
        System.out.println(Integer.toBinaryString(((int) Math.pow(2, 2)) - 1));
        System.out.println(Integer.toBinaryString(((int) Math.pow(2, 3)) - 1));
        System.out.println(Integer.toBinaryString(((int) Math.pow(2, 4)) - 1));

    }


}
