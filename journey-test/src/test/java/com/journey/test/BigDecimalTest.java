package com.journey.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author liuqingwen
 * @date 2017/10/20.
 */
public class BigDecimalTest {

    @Test
    public void test() {

        BigDecimal bigDecimal = new BigDecimal(10.12, MathContext.UNLIMITED);
        bigDecimal.setScale(1, RoundingMode.HALF_UP);
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

    @Test
    public void test2() {

        System.out.println(BigDecimal.ONE.compareTo(BigDecimal.ZERO));
        System.out.println(BigDecimal.ZERO.compareTo(BigDecimal.TEN));

    }

    @Test
    public void test3() {

        BigDecimal bigDecimal = null, bigDecimal2 = null, bigDecimal3 = null;

        ArrayList<BigDecimal> bigDecimals = Lists.newArrayList(BigDecimal.valueOf(30), BigDecimal.valueOf(30), BigDecimal.valueOf(40));
        int size = bigDecimals.size();

        BigDecimal reduce = bigDecimals.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal divide = reduce.divide(BigDecimal.valueOf(size), 2, RoundingMode.HALF_DOWN);
        if (divide.multiply(BigDecimal.valueOf(size)).compareTo(reduce) == 0) {
            bigDecimal = divide;
        } else {
            bigDecimal2 = divide;
            bigDecimal3 = reduce.subtract(divide.multiply(BigDecimal.valueOf(size - 1)));
        }

        System.out.println(bigDecimal);
        System.out.println(bigDecimal2);
        System.out.println(bigDecimal3);

    }

}
