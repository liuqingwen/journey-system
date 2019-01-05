package com.journey.test;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuqingwen
 * @date 2017/11/2.
 */
public class RegTest {

    public static void main(String[] args) {


        Pattern pattern = Pattern.compile("(\\p{Digit}{2,3}\\.){3}\\p{Digit}{2,3}:\\p{Digit}{1,6}");
        Matcher matcher = pattern.matcher("192.168.16.87:8080");
        System.out.println(matcher.matches());

    }

    @org.junit.Test
    public void testReplace() {
        String s = "201711/13/17171113043453945453.pdf";
        String s1 = s.replaceAll("\\\\", "/");
        System.out.println(s1);
    }

    @Test
    public void test() {
        System.out.println(isMobile("15309275862"));
    }

    /**
     * 检查是否是手机号
     */
    public final static boolean isMobile(String text) {
        if (null == text)
            return false;
        if (text.length() != 11)
            return false;
        return match(text, "^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\\d{8})$");
    }

    /**
     * 正则表达式匹配
     *
     * @param text
     *            待匹配的文本
     * @param reg
     *            正则表达式
     * @return
     */
    private final static boolean match(String text, String reg) {
        if (org.apache.commons.lang3.StringUtils.isBlank(text) || org.apache.commons.lang3.StringUtils.isBlank(reg))
            return false;
        return Pattern.compile(reg).matcher(text).matches();
    }

}
