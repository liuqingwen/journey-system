package com.journey.comparator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuqingwen
 * @date 2018/4/26.
 */
public class ComparatorTest {

    @Test
    public void test() {

        Arrays.asList("1-1000-2000", "1-1-1000").stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

    }

}
