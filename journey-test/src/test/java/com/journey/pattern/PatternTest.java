package com.journey.pattern;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

/**
 * @author liuqingwen
 * @date 2018/4/17.
 */
public class PatternTest {

    @Test
    public void test() {

        Pattern pattern = Pattern.compile("\\s+");
        System.out.println(pattern.splitAsStream("liu qing wen is best good").collect(toList()));

        System.out.println("\\");

    }

    @Test
    public void test2() {

        Pattern pattern = Pattern.compile("[,，]+");
        String[] split = pattern.split("1,，2,,,，3,,4,5");
        System.out.println(Arrays.toString(split));

    }

    @Test
    public void test3() {

        Pattern pattern = Pattern.compile("\\w+");
        System.out.println(pattern.matcher("ab$c12dk").matches());

    }

}
