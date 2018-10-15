package com.journey.pattern;

import org.junit.Test;

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

}
