package com.journey.collection;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void test2() {

        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("liu");
        deque.addFirst("qing");
        deque.addFirst("qing");
        deque.addFirst("qing");
        deque.addFirst("qing");
        deque.addFirst("qing");
        deque.addFirst("qing");
        deque.addFirst("qing");
        deque.addFirst("qing");
        deque.addLast("wen");
        deque.addLast("web");
        deque.addLast("qing");
        deque.addLast("qing");
        deque.addLast("qing");
        deque.addLast("web");
        deque.addLast("qing");
        deque.addLast("qing");
        deque.addLast("qing");

    }

    @Test
    public void test3() {

        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        System.out.println(new ArrayList<>(integers.subList(0, 2)));
        System.out.println(integers.subList(2, 4));
        System.out.println(integers.subList(4, 6));
        System.out.println(integers);

    }

}
