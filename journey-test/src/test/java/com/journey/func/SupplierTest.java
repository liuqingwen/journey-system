package com.journey.func;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.util.function.Supplier;

/**
 * @author liuqingwen
 * @date 2019/1/23.
 */
public class SupplierTest {

    @Test
    public void test() {

        Supplier<Integer> supplier = () -> 1 * 2;
        System.out.println(supplier.get());

    }

    @Test
    public void test02() {
        Supplier<Boolean> supplier = () -> {
            return Boolean.FALSE;
        };

        Supplier<Boolean> supplier2 = new Supplier<Boolean>() {
            @Override
            public Boolean get() {
                return null;
            }
        };

        get(supplier);

    }

    public static final <T> T get(Supplier<T> supplier) {
        boolean equals = ((ParameterizedType) supplier.getClass().getGenericSuperclass()).getActualTypeArguments()[0].getClass().equals(Boolean.class);
        System.out.println(equals);
        return null;
    }
}
