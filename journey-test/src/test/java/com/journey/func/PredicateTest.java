package com.journey.func;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * @author liuqingwen
 * @date 2019/1/23.
 */
public class PredicateTest {

    @Test
    public void test() {

        Predicate<Integer> predicate = arg -> arg.equals(1);
        Predicate<Integer> negate = predicate.negate();

        System.out.println(predicate.test(1));
        System.out.println(negate.test(2));

    }


}
