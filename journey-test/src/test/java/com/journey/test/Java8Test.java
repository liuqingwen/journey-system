package com.journey.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by liuqingwen on 2017/7/20.
 */
public class Java8Test {


    public static void main(String[] args) {


//        Optional<Integer> count = Stream.of(1,2,3).reduce((acc, element) -> acc + element);
//        System.out.println(count.get());
//
//
//        Map<Integer, Integer> map = Arrays.asList(1,2,3).stream().collect(Collectors.toMap(index -> index, index -> index +1));
//        System.out.println((List<Integer>)map.values());



//        System.out.println(Runtime.getRuntime().availableProcessors());


//        System.out.println(IntStream.range(1, 10).reduce(0, (x, y) -> x + y));


//        List<String> strings = Lists.newArrayList("1","2", "2", "3");
//        System.out.println(strings.stream().map(v -> Integer.parseInt(v)).distinct().collect(Collectors.toList()));


//        IntStream.range(0, 11).forEach(System.out::println);

//        System.out.println(IntStream.range(0, 11).count());


//        Map<String, Object> map = new HashMap<>();
//        map.put("couponId", 111);
//        map.put("info", "10元直减券");
//
//        System.out.println(JSON.toJSONString(map));


//        IntStream.range(1, 10).mapToObj(index -> UUID.randomUUID().toString()).collect(Collectors.toList()).forEach(System.out::println);

          System.out.println(Lists.newArrayList("1", "2", "3").stream().reduce((res, item) -> res.concat(",").concat(item)).get());

    }

    @Test
    public void test1() {

        List<User> users = new ArrayList<>();
        users.add(new User(1, "liu"));
        users.add(new User(1, "gao"));
        users.add(new User(3, "liu"));

//        users.stream().

//        Map<String, ArrayList<User>> usersMap = users.stream().collect(Collectors.toMap(user -> user.getName(), user -> Lists.newArrayList(user)));
//        System.out.println(usersMap);

        Map<Integer, String> stringMap = users.stream().collect(Collectors.toMap(User::getId, User::getName, (String s1, String s2) -> s2));// s1 老数据，s2新数据
        System.out.println(stringMap);
    }


    @Test
    public void test2() {

        Map<Integer, List<Integer>> listMap = new HashMap<>();
        listMap.put(new Integer(1), Lists.newArrayList(1,2,3));
        listMap.put(new Integer(2), Lists.newArrayList(4,5,6));

        List<Integer> integers = listMap.values().stream().flatMap(ints -> ints.stream()).collect(toList());
        System.out.println(integers);

    }

    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());

    public String toString() {
        return "Hello World";
    }

    @Test
    public void test3() {

        new Java8Test().r1.run();
        new Java8Test().r2.run();

        Function<String, String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("aaaaa"));
    }

    @Test
    public void test4() {
        List<Integer> list = Lists.newArrayList(1, 4, 3, -2, 0, 4, 2, 9, -4, 0, 4, 1, -4, -9, -3, 5, 8, 0);
//        Collections.sort(list, Comparator.comparing(Integer::intValue));
//        System.out.println(list);
        list.sort(Comparator.comparing(Integer::intValue).reversed());
        System.out.println(list);
    }

    @Test
    public void test5() {

        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 3, 2);

        List<User> list1 = Lists.newArrayList(new User(1, "liuqingwen"), new User(1, "liuqingwen1"), new User(2, "liuqingwen2"));


        try {
            list.stream().collect(Collectors.toMap(i -> i, i -> i));
        } catch(Exception e) {}

//        groupingBy(classifier, HashMap::new, downstream)
        System.out.println(list1.stream().collect(Collectors.groupingBy(User::getId, toList())));

    }

    @Test
    public void test6() {

        List<String> list = Lists.newArrayList();
        System.out.println(list.stream().reduce("", (v1, v2) -> v1.concat(",").concat(v2)).substring(1));


    }

    @Test
    public void test7() {

        List<Integer> list = Lists.newArrayList(1, 2, 3, 6, 4, 2, 2, 3, 4);
        Map<Integer, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(v -> v, toList()));
        System.out.println(collect);
    }

    @Test
    public void test8() {

        List<String> parameterKeys = Lists.newArrayList("b_ ", "_d_", " a ", " f", "__c", "e").stream().map(key -> key.trim().replaceAll("_", "")).collect(toList());
        parameterKeys.sort(Comparator.comparing(String::toString));
        System.out.println(parameterKeys);

    }

    @Test
    public void test9() {
        ArrayList<String> list = Lists.newArrayList("Hello", "World");
        list.stream().map(word -> word.split("")).distinct().forEach(System.out::print);
        System.out.println();
        list.stream().flatMap(word -> Stream.of(word.split(""))).distinct().forEach(System.out::print);

    }

    @Test
    public void test10() {
        List<Integer> ints1 = Lists.newArrayList(1,2,3);
        List<Integer> ints2 = Lists.newArrayList(3, 4);

        ints1.stream().flatMap(i -> ints2.stream().map(j -> new Integer[]{i, j})).forEach(arr -> System.out.println(Arrays.toString(arr)));
        ints1.stream().flatMap(i -> ints2.stream().filter(j -> (j + i) % 3 == 0).map(j -> new Integer[]{i, j})).forEach(arr -> System.out.println(Arrays.toString(arr)));

    }

    @Test
    public void test11() {

        String arrs = "\"'menuItem:share:appMessage'\", \"'menuItem:share:timeline'\", \"'menuItem:share:qq'\", \"'menuItem:share:weiboApp'\", \"'menuItem:share:facebook'\", \"'menuItem:share:QZone'\",\"'menuItem:openWithQQBrowser'\",\"'menuItem:openWithSafari'\",\"'menuItem:copyUrl'\",\"'menuItem:share:email'\",\"'menuItem:favorite'\",\"'menuItem:readMode'\",\"'menuItem:share:brand'\"";
        List<String> fibs = Lists.newArrayList(arrs.split(",")).stream().map(v -> v.replaceAll("\"", "")).collect(toList());
        System.out.println(fibs);

    }

    @Test
    public void test12() {
        List<String> list = Lists.newArrayList("1", "2");
        String join = list.stream().collect(joining(","));
        System.out.println(join);
    }

    @Test
    public void test13() {

        UnaryOperator<String> one = (v1) -> "1 -" + v1;
        UnaryOperator<String> two = (v2) -> "2 -" + v2;
        Function<String, String> pipeline = one.andThen(two);
        String apply = pipeline.apply("3");
        System.out.println(apply);

    }
}
