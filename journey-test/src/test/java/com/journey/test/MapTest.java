package com.journey.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by liuqingwen on 2017/10/9.
 */
public class MapTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("PRO_ID", "29234");
        map.put("PRO_NAME", "54°水井坊画卷装1000ml");
        map.put("kk", null);
        map.put("yy", "liu");

        System.out.println(map);
        final Map<String, String> map1 = new HashMap<>(map);
        System.out.println("1 -> " + map1);

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key == null || map.get(key) == null) {
                /*iterator.remove();*/map.remove(key);
            }
        }
        System.out.println(map);
    }

    @Test
    public void test() {

        System.out.println(Integer.MAX_VALUE);
        System.out.println((1 << 31) - 1);
        System.out.println((1 << 4) << 1);
        System.out.println(5 << 1);
//        0 1 0 1 << 1 ==> 1 0 1 0 ==> 8 + 2 = 10;
    }


    @Test
    public void test2() {

        Map<String, String> map = new HashMap<String, String>(){{put("str", "1");put("str2", "2");}};
        System.out.println(map);
        String str = map.merge("str", "2", (v1, v2) -> null);
        System.out.println(str);
        System.out.println(map);


    }
}
