package com.journey.regex;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author liuqingwen
 * @date 2018/3/23.
 */
public class RegexTest {

    @Test
    public void test() {

        String s = "1,2,3,4,5";
        Pattern pattern = Pattern.compile(",");
        String[] split = pattern.split(s);
        System.out.println(Arrays.toString(split));
        Stream<String> stringStream = pattern.splitAsStream(s);
        System.out.println(stringStream.collect(toList()));

    }

}
