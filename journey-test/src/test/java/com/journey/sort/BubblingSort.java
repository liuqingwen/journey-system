package com.journey.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liuqingwen
 * @date 2018/10/8.
 */
public class BubblingSort {

    @Test
    public void test() {

        Integer[] integers = new Integer[]{4, 1, 3, 0, 5, 9, 2, 8, 7, 6, 4, 5, 1, 8, 9};//collect.toArray(new Integer[1]);
        System.out.println("size : " + integers.length);
        System.out.println(Arrays.toString(integers));
        sort2(integers);
        System.out.println(Arrays.toString(integers));

    }

    private static void sort(Integer[] sorts) {

        int tmp;
        for (int index = 0; index < sorts.length; index++) {
            for (int index2 = 1 + index; index2 < sorts.length; index2++) {
                if (sorts[index] > sorts[index2]) {
                    continue;
                }
                if (index + 1 < index2) {
                    tmp = sorts[index];
                    sorts[index] = sorts[index2 - 1];
                    sorts[index2 - 1] = tmp;
                    index = 0;
                }
                break;
            }
        }

    }

    public static void sort2(Integer[] sorts) {

        int tmp;
        for (int index = 0; index < sorts.length; index++) {
            for (int index2 = 0; index2 < sorts.length - 1 - index; index2++) {
                if (sorts[index2 + 1] < sorts[index2]) {
                    tmp = sorts[index2 + 1];
                    sorts[index2 + 1] = sorts[index2];
                    sorts[index2] = tmp;
                }
            }
        }

    }

}
