package com.journey.spring;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author liuqingwen
 * @date 2018/9/6.
 */
public class StringTest {

    @Test
    public void test() {

        String[] strings = StringUtils.delimitedListToStringArray("i am java develop", "", "liu");
        System.out.println(Arrays.toString(strings));

        StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement.getClassName() + "#" + stackTraceElement.getMethodName());
            if ("main".equalsIgnoreCase(stackTraceElement.getMethodName())) {
                System.err.println(stackTraceElement.getClassName() + "#" + stackTraceElement.getMethodName());
            }
        }

    }

}
