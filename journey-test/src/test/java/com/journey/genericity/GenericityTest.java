package com.journey.genericity;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuqingwen
 * @date 2018/11/8.
 */
public class GenericityTest {

    @Test
    public void test() {

        List<String> list = new ArrayList<String>() {

        };
        Type genericSuperclass = list.getClass().getGenericSuperclass();
        System.out.println(genericSuperclass instanceof ParameterizedType);
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
        System.out.println(actualTypeArgument);
    }
}
