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

    @Test
    public void test2() {

        System.out.println("abc".indexOf("b"));

    }

    @Test
    public void test3() {

        String str = "liuqingwen";
        System.out.println(reverse(str));

    }

    private String reverse(String arg) {

        char[] chars = arg.toCharArray();
        int length = chars.length;
        if (length < 2) {
            return arg;
        }

        char t;
        for (int index = 0; index < length; index++) {
            if (index > (length - 1 - index)) {
                break;
            }
            t = chars[index];
            chars[index] = chars[length - 1 - index];
            chars[length - 1 - index] = t;

        }

        return new String(chars);
    }

}
