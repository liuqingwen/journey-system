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

    @Test
    public void test4() {

        String s = "qq.txt";
        int index = -1;
        System.out.println((index = s.indexOf(".")) > -1 ? s.substring(0, index) : s);

    }

    @Test
    public void test5() {

        StringBuilder stringBuilder = new StringBuilder(1 << 5);
        stringBuilder.append("1").append(",").append("2").append(",").append("3").append(",").append("4").append(",")
                .append("5").append(",").append("6").append(",");
        System.out.println(stringBuilder.lastIndexOf(","));
        System.out.println(stringBuilder.length());
        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));

    }

    @Test
    public void test6() {

        System.out.println("http://www.jiuxian.com/jalsdkfjalsd".replace("http://www.", "").indexOf("jiuxian.com"));

    }

}
