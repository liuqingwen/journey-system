package com.journey.test;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author liuqingwen
 * @date 2018/2/5.
 */
public class SpringTest {

    @Test
    public void test() {

        String[] toke = StringUtils.tokenizeToStringArray("1,2,3,4,5", ",");
        System.out.println(Arrays.toString(toke));

    }


}
