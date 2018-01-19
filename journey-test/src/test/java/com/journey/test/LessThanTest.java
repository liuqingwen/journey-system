package com.journey.test;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2017/11/28.
 */
public class LessThanTest {

    @Test
    public void test() {
        System.out.println(1 << 0);
        System.out.println(1 << 1);
        System.out.println(1 << 2);
        System.out.println(3 << 1);

//        8 4 2 1
//        0 0 0 1
//        0 0 1 0
//
//        1 1 0 0
//        0 1 1 0

        System.out.println(Integer.toBinaryString(11));
        System.out.println(11 >>> 2);
//        8 4 2 1
//        1 0 1 1
//        0 0 1 0


//        2
//        0 0 1 0
//        1 1 0 1 + 1
//        1 1 1 0
//        -2

//        0 0 0 1 + 1
//        0 0 1 0

        String binary[] = {
                "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"
        };
        int a = 3; // 0 + 2 + 1 or 0011 in binary
        int b = 6; // 4 + 2 + 0 or 0110 in binary
        int c = a | b;
        int d = a & b;
        int e = a ^ b;
        int f = (~a & b) | (a & ~b);
        int g = ~a & 0x0f;
        System.out.println(" a = " + binary[a]);
        System.out.println(" b = " + binary[b]);
        System.out.println(" a|b = " + binary[c]);
        System.out.println(" a&b = " + binary[d]);
        System.out.println(" a^b = " + binary[e]);
        System.out.println("~a&b|a&~b = " + binary[f]);
        System.out.println(" ~a = " + binary[g]);

    }


}
