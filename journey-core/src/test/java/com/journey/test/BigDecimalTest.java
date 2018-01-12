package com.journey.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @author liuqingwen
 * @date 2017/10/20.
 */
public class BigDecimalTest {

    @Test
    public void test() {

        BigDecimal bigDecimal = new BigDecimal(10.12, MathContext.UNLIMITED);
        System.out.println(bigDecimal.doubleValue());
        System.out.println(bigDecimal.intValue());
        System.out.println(bigDecimal.doubleValue() > bigDecimal.intValue());
    }

    @Test
    public void test1() {
        BigDecimal bigDecimal = BigDecimal.valueOf(-1000.00000);
        BigDecimal bigDecimal1 = BigDecimal.valueOf(1000.333);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(1000.2221111);

        System.out.println(bigDecimal1.subtract(bigDecimal));
        double bigDecimal3 = bigDecimal.doubleValue() + bigDecimal1.doubleValue() + bigDecimal2.doubleValue();
        System.out.println(bigDecimal3);
        BigDecimal bigDecimal4 = new BigDecimal(0);
//        bigDecimal4.setScale(2);
        System.out.println(bigDecimal4.add(bigDecimal).add(bigDecimal1).add(bigDecimal2).doubleValue());

        Double payPriceDouble = BigDecimal.valueOf(226.54).subtract(BigDecimal.valueOf(195.54))
                .subtract(BigDecimal.valueOf(0.0))
                .subtract(BigDecimal.valueOf(0.0)).subtract(BigDecimal.valueOf(0.0))
                .subtract(BigDecimal.valueOf(0.0)).subtract(BigDecimal.valueOf(10.00)).doubleValue();// 应付金额
        System.out.println(payPriceDouble);
    }

}
