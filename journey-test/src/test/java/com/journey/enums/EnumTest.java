package com.journey.enums;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/9/20.
 */
public class EnumTest {

    @Test
    public void test() {

        PaymentInvoiceStatusEnum rejected = PaymentInvoiceStatusEnum.REJECTED;
        String op = rejected.combinationOperate();
        System.out.println(op);

    }

}
