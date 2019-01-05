package com.journey.reflect;

import com.journey.reflect.pojo.XianService;
import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author liuqingwen
 * @date 2018/11/10.
 */
public class MethodHandleTest2 {

    @Test
    public void test() throws Throwable {

        mh(new XianService()).invokeExact("开开心心");

    }

    private MethodHandle mh(Object obj) throws Exception {

        MethodType methodType = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(obj.getClass(), "say", methodType).bindTo(obj);
    }
}
