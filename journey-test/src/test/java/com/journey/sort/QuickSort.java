package com.journey.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author liuqingwen
 * @date 2018/10/8.
 */
public class QuickSort {

    @Test
    public void test() {

//        IntStream.range(0, 10).forEach((index) -> System.out.println(index));
        List<Integer> collect = IntStream.range(0, 10).mapToObj(index -> index).collect(toList());
        Collections.shuffle(collect);
        Integer[] integers = new Integer[]{4, 1, 3, 0, 5, 9, 2, 8, 7, 6, 4, 5, 1, 8, 9};//collect.toArray(new Integer[1]);
        System.out.println("size : " + integers.length);
        System.out.println(Arrays.toString(integers));
        sort(integers);
        System.out.println(Arrays.toString(integers));
    }


    private static void sort(Integer[] sorts) {

        sort(sorts, 0, sorts.length);
    }

    private static void sort(Integer[] sorts, int s, int e) {

        if (Math.abs((e - s)) == 1 || (e - s) == 0) {
            return ;
        }

        int len = e, i = s, j = e - 1;
        int base = sorts[i];
        boolean or = true;
        while (i < len && j > s && i != j) {
            if (or) {
                int next = sorts[j];
                if (next < base) {
                    sorts[i] = next;
                    sorts[j] = base;
                    or = false;
                    System.out.println(Arrays.toString(sorts));
                } else {
                    j --;
                }
            } else {
                int head = sorts[i];
                if (head > base) {
                    sorts[j] = head;
                    sorts[i] = base;
                    or = true;
                    System.out.println(Arrays.toString(sorts));
                } else {
                    i ++;
                }
            }
        }

//        System.out.println("i:" + i + "-j:" + j);
        sort(sorts, s, i + 1);
        sort(sorts, j + 1, e);
    }

}
