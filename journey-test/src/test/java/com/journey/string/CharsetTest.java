package com.journey.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author liuqingwen
 * @date 2018/3/19.
 */
public class CharsetTest {

    @Test
    public void test() throws UnsupportedEncodingException {
        String s = "鏈\uE046櫥褰�";
        String ss = new String(s.getBytes("GBK"), "UTF-8");
        System.out.println(ss);
    }

}
