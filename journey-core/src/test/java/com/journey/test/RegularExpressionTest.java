package com.journey.test;

import org.junit.Test;

import java.util.Arrays;

/**
 * 正则表达式Test
 *
 * @author liuqingwen
 * @date 2017/10/20.
 */
public class RegularExpressionTest {

    @Test
    public void test() {

        String ss = "Mozilla/5.0 (Linux; Android 5.0.1; SCH-I959 Build/LRX22C; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043622 Safari/537.36 jiuxianApp/7.8.0 from/ANDROID suptwebp/1 netEnv/wifi";
        String s1 = Arrays.asList(ss.split(" ")).stream().filter(s -> "jiuxianApp/".equalsIgnoreCase(s)).findFirst().orElse(null);
        if (s1 != null && s1.indexOf("/") > -1) {
            String s = s1.split("/")[1];

        }

    }


}
