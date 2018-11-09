package com.journey.genericity;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuqingwen
 * @date 2018/11/8.
 */
public class GenericityTest {

    @Test
    public void test() {

        Map<String, Integer> map = new HashMap<String, Integer>(){};
        Type[] actualTypeArguments = ((ParameterizedType) map.getClass().getGenericSuperclass()).getActualTypeArguments();
        for (Type type : actualTypeArguments) {
            System.out.println(type);
        }

    }
}
