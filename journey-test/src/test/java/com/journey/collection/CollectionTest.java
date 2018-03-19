package com.journey.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author liuqingwen
 * @date 2018/3/19.
 */
public class CollectionTest {

    @Test
    public void test() {

        System.out.println(List.class.isAssignableFrom(ArrayList.class));
        System.out.println(List.class.isAssignableFrom(List.class));
        System.out.println(List.class.isAssignableFrom(Set.class));

    }

}
