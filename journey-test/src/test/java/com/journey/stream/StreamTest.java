package com.journey.stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author liuqingwen
 * @date 2018/3/20.
 */
public class wStreamTest {

    // https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
    // https://www.ibm.com/developerworks/cn/java/j-java-streams-1-brian-goetz/index.html?ca=drs-
    // https://www.ibm.com/developerworks/cn/java/j-java-streams-2-brian-goetz/index.html?ca=drs- Collectors 介绍

    @Test
    public void test() {

        NumCounter1 reduce = Lists.<Integer>newArrayList(1, 2, 3).stream()
                .reduce(new NumCounter1(0), NumCounter1::returnV, NumCounter1::add2);
        System.out.println(reduce);
        Integer reduce1 = Lists.newArrayList(1, 2, 3).stream().reduce(Integer.valueOf(0), Integer::sum);
        System.out.println(reduce1);

//        Lists.newArrayList().forEach( {
//
//        });
//
//        for (Lists.newArrayList())


//        List<List<Integer>> lists = null; // ==> List<Integer>
//        lists.stream().flatMap(list -> list.stream()).collect(toList());



    }

    @Test
    public void test3() {

        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

    }

    @Test
    public void test4() {

        Stream<ArrayList<Integer>> arrayListStream = Stream.of(Lists.newArrayList(1, 2, 3), Lists.newArrayList(4, 5, 6), Lists.newArrayList(7, 8, 9));
        Stream<Integer> integerStream = arrayListStream.flatMap(list -> list.stream());
        System.out.println(integerStream.collect(toList()));
    }

    @Test
    public void test5() {

        Stream limit = IntStream.rangeClosed(1, 6).mapToObj(i -> i);
        System.out.println(limit.limit(3).collect(toList()));

    }

    @Test
    public void test6() {
        List<String> strings = Lists.newArrayList("1", "2", "3");
        strings.stream().reduce("", String::concat);
    }

    @Test
    public void test2() {
        String arr = "12%3 21sdas s34d dfsdz45   R3 jo34 sjkf8 3$1P 213ikflsd fdg55 kfd";
        Stream<Character> stream = IntStream.range(0, arr.length()).mapToObj(arr::charAt);
        System.out.println("ordered total: " + countNum(stream));
    }

    private static int countNum(Stream<Character> stream){
        NumCounter numCounter = stream.reduce(new NumCounter(0, 0, false), NumCounter::accumulate, NumCounter::combine);
        return numCounter.getSum();
    }

}

final class NumCounter1 {

    private Integer v;

    public NumCounter1(Integer v) {
        this.v = v;
    }

    public NumCounter1 returnV(Integer v) {
        return new NumCounter1(v);
    }

    public NumCounter1 add2(NumCounter1 numCounter1) {
        return new NumCounter1(Integer.sum(numCounter1.v, this.v));
    }
}

class NumCounter {

    private int num;
    private int sum;
    // 是否当前是个完整的数字
    private boolean isWholeNum;

    public NumCounter(int num, int sum, boolean isWholeNum) {
        this.num = num;
        this.sum = sum;
        this.isWholeNum = isWholeNum;
    }

    public NumCounter accumulate(Character c) {
        if (Character.isDigit(c)) {
            return isWholeNum ? new NumCounter(Integer.parseInt("" + c), sum + num, false) : new NumCounter(Integer.parseInt("" + num + c), sum, false);
        } else {
            return new NumCounter(0, sum + num, true);
        }
    }

    public NumCounter combine(NumCounter numCounter) {
        return new NumCounter(numCounter.num, this.getSum() + numCounter.getSum(), numCounter.isWholeNum);
    }

    public int getSum() {
        return sum + num;
    }
}
