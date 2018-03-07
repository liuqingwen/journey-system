package com.journey.io;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

/**
 * @author liuqingwen
 * @date 2018/3/6.
 */
public class CharsetTest {

    @Test
    public void test() {

        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (Map.Entry<String, Charset> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }

    }

}
