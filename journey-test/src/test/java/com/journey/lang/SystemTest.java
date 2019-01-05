package com.journey.lang;

import org.junit.Test;

import java.util.Map;
import java.util.Properties;

/**
 * @author liuqingwen
 * @date 2018/9/20.
 */
public class SystemTest {

    @Test
    public void test() {

        Properties properties = System.getProperties();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println(properties);

        System.out.println();
        Map<String, String> getenv = System.getenv();
        for (Map.Entry<String, String> entry : getenv.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println(getenv);

    }

}
