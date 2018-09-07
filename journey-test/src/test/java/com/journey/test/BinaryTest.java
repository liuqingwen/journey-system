package com.journey.test;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

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

    @Test
    public void test7() {

        int initialCapacity = 8;
        initialCapacity |= (initialCapacity >>> 1);
        initialCapacity |= (initialCapacity >>> 2);
        initialCapacity |= (initialCapacity >>> 4);
        initialCapacity |= (initialCapacity >>> 8);
        initialCapacity |= (initialCapacity >>> 16);
        initialCapacity++;
        System.out.println(initialCapacity);

    }

    @Test
    public void test8() {

        System.out.println(1 << 16);

    }

    @Test
    public void test9() {

        System.out.println((1L << 62));
        System.out.println(Long.MAX_VALUE >> 1);

    }

    @Test
    public void test10() {

        System.out.println(1 << 16);
        System.out.println((1 << 16) / 1024);
        System.out.println(1 << 8);

    }

    @Test
    public void test11() {

        //
        System.out.println(Integer.toBinaryString(1 << 8));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println((byte)(1 << 7));
        System.out.println(Integer.toBinaryString(1 << 7));
    }


    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    @Test
    public void test12() {

        System.out.println(repair0(Integer.toBinaryString(RUNNING), 32) + "-- RUNNING");
        System.out.println(repair0(Integer.toBinaryString(SHUTDOWN), 32) + "-- SHUTDOWN");
        System.out.println(repair0(Integer.toBinaryString(STOP), 32) + "-- STOP");
        System.out.println(repair0(Integer.toBinaryString(TIDYING), 32) + "-- TIDYING");
        System.out.println(repair0(Integer.toBinaryString(TERMINATED), 32) + "-- TERMINATED");

    }

    private String repair0(String ending, int unit) {

        StringBuilder sb = new StringBuilder(1 << 6);
        int repairLen = unit - ending.length();
        for (int index = 0; index < repairLen; index++) {
            sb.append("0");
        }

        return sb.append(ending).toString();
    }

    @Test
    public void test13() {

        System.out.println(Double.valueOf(Math.pow(2, 32)));

    }

    @Test
    public void test14() {

        int var = 1;
        var ^= 2;
        var ^= 4;
        var ^= 4;
        var ^= 1;
        System.out.println(var);

        System.out.println(1 << 5);
        System.out.println(Integer.toBinaryString(1 << 5));
    }

    // LockSupport nextSecondarySeed Test
    @Test
    public void test15() {
        int r = 1;
        r ^= r << 13;   // xorshift
        r ^= r >>> 17;
        r ^= r << 5;
        System.out.println(r);
        System.out.println(Integer.toBinaryString(r));
    }
}
