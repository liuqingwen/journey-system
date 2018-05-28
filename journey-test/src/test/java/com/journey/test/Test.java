package com.journey.test;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.journey.entity.WeiXinUser;
import com.journey.enums.aop.EAopLogTypes;
import com.journey.enums.aop.ResponseReturnType;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.journey.enums.aop.EAopLogTypes.AOP_LOG;

/**
 * Created by liuqingwen on 2017/10/12.
 */
public class Test {

    {
        System.out.println(1);
        System.out.println("我是测试");
    }

    public static void main(String[] args) throws Exception {

        String userId = "112408574";
        String asyncFraudApiInvokerWhiteUser = "112408574,112408574";
        System.out.println(Arrays.toString(asyncFraudApiInvokerWhiteUser.split(",")));
        System.out.println(Arrays.asList(asyncFraudApiInvokerWhiteUser.split(",")));
        boolean contains = Arrays.asList(asyncFraudApiInvokerWhiteUser.split(",")).contains(userId);
        System.out.println(contains);
    }

    /**
     * 检查手机
     *
     * @param mobile
     * @return
     */
    public static boolean checkPhoneNum(String mobile) {
        if(Strings.isNullOrEmpty(mobile)){
            return false;
        }
        String regex = "^((1[0-9]))\\d{9}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(mobile);
        if (!m.find()) {
            return false;
        } else {
            return true;
        }
    }

    @org.junit.Test
    public void test() {

        int plus = 2;
        while (plus-- > 0) {
            System.out.println(plus);
        }
    }

    @org.junit.Test
    public void test2() {

        List<Integer> list = Lists.newArrayList(1, 2, 3);
        list.addAll(new ArrayList<>());

        System.out.println(list);

    }

    @org.junit.Test
    public void test3() {
        List<String> arrs = Lists.newArrayList("1", "2", "3");
        String s = arrs.stream().reduce((v1, v2) -> v1.concat("=").concat(v1).concat("&").concat(v2).concat("=").concat(v2).concat("&")).orElse("1122");
        System.out.println(s.substring(0, s.length() - 1));
    }

    @org.junit.Test
    public void test4() {
        System.out.println(String.format("%s", "123"));
    }

    @org.junit.Test
    public void test5() {

        Pattern pattern = Pattern.compile("^1[3-9]\\d{9}$");
        Matcher matcher = pattern.matcher("18644034293");
        System.out.println(matcher.matches());


        Supplier<WeiXinUser> supplier = WeiXinUser::new;
        WeiXinUser weiXinUser = supplier.get();

    }

    @org.junit.Test
    public void test6() {
        WeiXinUser weiXinUser = new WeiXinUser();
        weiXinUser.setNAME("开开心心");
        System.out.println(JSON.toJSONString(weiXinUser));
    }

    @org.junit.Test
    public void test7() {

        long nowTimeMS = System.currentTimeMillis();
        System.out.println(Long.SIZE);
        System.out.println(Long.toBinaryString(nowTimeMS));
        System.out.println(Long.toBinaryString(nowTimeMS).length());
        System.out.println((nowTimeMS << 22));
        System.out.println(Long.toBinaryString((nowTimeMS << 22)));
        System.out.println(Long.toBinaryString((nowTimeMS << 22)).length());
        System.out.println((nowTimeMS << 23));
        System.out.println(Long.toBinaryString((nowTimeMS << 23)));
        System.out.println(Long.toBinaryString((nowTimeMS << 23)).length());
        System.out.println((nowTimeMS << 24));
        System.out.println(Long.toBinaryString((nowTimeMS << 24)));
        System.out.println(Long.toBinaryString((nowTimeMS << 24)).length());
        System.out.println("-------------------------");
        System.out.println(nowTimeMS);
        System.out.println(nowTimeMS << 24);
        System.out.println((nowTimeMS << 22));
        System.out.println(nowTimeMS << 16);
        System.out.println(nowTimeMS);
        System.out.println((nowTimeMS << 56) >>> 1);

    }

    @org.junit.Test
    public void test8() {

        long lNS = System.nanoTime();
        long lNS1 = System.nanoTime() / 1000000;
        long lMS = System.currentTimeMillis();
        System.out.println(lNS);
        System.out.println(lNS1);
        System.out.println(lMS);

    }

    @org.junit.Test
    public void test9() {
        System.out.println(Math.PI);
        System.out.println(Math.sqrt(Math.PI));

        System.out.println(StrictMath.PI);

        System.out.println(1 << 67);
        System.out.println(1 << 3);

        System.out.println("Java\u2122");
    }

    @org.junit.Test
    public void test10() {

        System.out.println((1 << (Integer.SIZE - 3)));
        System.out.println(Integer.toBinaryString((1 << (Integer.SIZE - 3))));
        System.out.println((1 << (Integer.SIZE - 3)) - 1);
        System.out.println(Integer.toBinaryString((1 << (Integer.SIZE - 3)) - 1));

        int index = 0;
        rec:
        for (index = 0;;index++) {
            if (index > 5) {
                break rec;
            }
            if (index < 5) {
                System.out.println("retry");
                continue rec;
            }
        }
    }

    @org.junit.Test
    public void test11() {

        System.out.println(-1 << (Integer.SIZE - 3));
        System.out.println(Integer.toBinaryString(-1 << (Integer.SIZE - 3)));
        System.out.println(~(-1 << (Integer.SIZE - 3)));

        System.out.println("--------");
        final int COUNT_BITS = Integer.SIZE - 3;
        final int CAPACITY   = (1 << COUNT_BITS) - 1;

        // runState is stored in the high-order bits
        final int RUNNING    = -1 << COUNT_BITS;
        final int SHUTDOWN   =  0 << COUNT_BITS;
        final int STOP       =  1 << COUNT_BITS;
        final int TIDYING    =  2 << COUNT_BITS;
        final int TERMINATED =  3 << COUNT_BITS;

        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(RUNNING+1);
        System.out.println(Integer.toBinaryString(RUNNING+1));
        System.out.println(Integer.toBinaryString(CAPACITY));
        System.out.println(Integer.toBinaryString(~CAPACITY));

    }

    @org.junit.Test
    public void test12() {
        Properties properties = System.getProperties();
        Enumeration<?> enumerations = properties.propertyNames();
        while (enumerations.hasMoreElements()) {
            Object key = enumerations.nextElement();
            System.out.println(String.format("%s : %s", key, properties.get(key)));
        }

        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");

        Map<String, String> env = System.getenv();
        for (String key : env.keySet()) {
            System.out.println(String.format("%s : %s", key, properties.get(key)));
        }

        System.out.println(1 ^ 2 ^ 1);

    }

    @org.junit.Test
    public void test13() {

        Integer[][] arrss = {
                {1,2,3,4},
                {5,6,7,8}
        };
        for (int index = 0; index < arrss.length; index++) {
            for (int index1 = 0; index1 < arrss[index].length; index1++) {
                System.out.print(arrss[index][index1] + ",");
            }
            System.out.println();
        }

    }

    @org.junit.Test
    public void test14() {

        WeiXinUser weiXinUser = new WeiXinUser();
        weiXinUser.setNAME("liu");

//        weiXinUser.getNAME().replace("1212");
        System.out.println(weiXinUser.getNAME());


    }

    @org.junit.Test
    public void test15() {

        WeiXinUser weiXinUser = new WeiXinUser();
        eidit(weiXinUser);
        System.out.println(weiXinUser == null ? null : JSON.toJSONString(weiXinUser));

    }

    private WeiXinUser eidit(WeiXinUser weiXinUser) {
        weiXinUser.setNAME("liu");
        return weiXinUser;
    }

    @org.junit.Test
    public void test16() {

        System.out.println("a".compareTo("b"));
        System.out.println(AOP_LOG.ordinal());
        System.out.println(ResponseReturnType.FAIL.ordinal());
        System.out.println("1&2&3".replaceAll("&", "[|]").replaceAll("\\[\\|\\]", "&"));

    }

    @org.junit.Test
    public void test17() {

        Integer[] is = new Integer[20];
        List<Integer> ls = new ArrayList<>(20);
        System.out.println(is.length);
        System.out.println(ls.size());

    }

    @org.junit.Test
    public void test18() {

        byte[] bytes = new byte[]{};
        System.out.println(bytes.getClass().getName());

    }

    @org.junit.Test
    public void test19() {

        System.out.println(Math.log(4));
        System.out.println(Math.log(10));
        System.out.println(Math.log(Math.E));
        System.out.println(Math.log(10_000_000_000L));

    }

    @org.junit.Test
    public void test20() {
        HashFunction md5 = Hashing.md5();
        System.out.println(md5.hashBytes("liu".getBytes()).toString());
        System.out.println(md5.hashBytes("liu".getBytes()).toString());
        System.out.println(md5.hashBytes("liu".getBytes()).toString().length());
        System.out.println(md5.hashBytes("qing".getBytes()).toString());
        System.out.println(md5.hashBytes("wen".getBytes()).toString());

    }

    @org.junit.Test
    public void test21() {

        List<String> s = new ArrayList<String>(){{add("1"); add("2");}};

        System.out.println(s);

        System.out.println(new Object(){}.getClass().getEnclosingClass());
    }

    @org.junit.Test
    public void test22() {

        try {

            List<@NonNull User> users = new ArrayList<>();
            User user1 = null;
            users.add(user1);
            System.out.println(user1);

            User user = new User(1, null);
            @NonNull String name = user.getName();
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test23() {

        Map<String, Object> map = new HashMap<>(6);
        map.put("liu", "庆文");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "-" + value);
        }


    }

    @org.junit.Test
    public void test24() {

        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.getAndIncrement());

    }

    @org.junit.Test
    public void test25() {

        System.out.println(String.valueOf((char)(0+65)));

    }

    @org.junit.Test
    public void test26() {

        List<Integer> list = new ArrayList<Integer>() {{add(1); add(2); add(4);}};
        list.iterator().forEachRemaining(System.out::println);

    }

    @org.junit.Test
    public void test27() {

        HashSet<Integer> objects = Sets.newHashSet();
        System.out.println(objects.add(1));
        System.out.println(objects.add(1));


    }

    @org.junit.Test
    public void test28() {

        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3);

        ListIterator<Integer> integerListIterator = integers.listIterator();
        System.out.println(integerListIterator.nextIndex());
        integerListIterator.next();
        System.out.println(integerListIterator.nextIndex());
        System.out.println(integerListIterator.nextIndex());


        System.out.println(Arrays.toString(integers.toArray(new Integer[0])));
        synchronized (integers) {
            Iterator<Integer> iterator = integers.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        System.out.println(integers);

    }

    @org.junit.Test
    public void test29() {

        System.out.println(String.format("%s", "我是好人"));

    }

    @org.junit.Test
    public void test30() {

        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
//        objectObjectHashMap.put("name", 1);
//        objectObjectHashMap.putIfAbsent("name", 0);
//        System.out.println(objectObjectHashMap.get("name"));

        objectObjectHashMap.put("name", 1);
        objectObjectHashMap.compute("name", (o1, o2) -> null);
        System.out.println(objectObjectHashMap.containsKey("name"));


    }

    @org.junit.Test
    public void test31() {

        Map<String, Object> map = new LinkedHashMap<String, Object>(10, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 10;
            }
        };
        IntStream.range(0, 15).forEach(value -> map.put(String.valueOf(value), String.valueOf(value)));
        map.forEach((key, value) -> System.out.println(key + "-" + value));

    }

    @org.junit.Test
    public void test32() {

        System.out.println( 91 * 11);
        IntStream.range(1, 9).forEach(v -> System.out.println(v * 91));

        System.out.println(1001 * 234);

    }

    @org.junit.Test
    public void test33() {

        int[] ints = new int[10];
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        System.out.print(ints.length);

    }

    @org.junit.Test
    public void test34() {

        System.out.println(File.separator);
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);

        System.out.println("--------------------------------\\n");
        System.out.println("\\"+System.getProperty("line.separator").replaceAll("\\\\", "\\\\"));
    }

    @org.junit.Test
    public void test35() {

        String s = "hello";
        System.out.println(s.codePointCount(0, s.length()));
        System.out.println((char)s.offsetByCodePoints(0, 2));
        System.out.println((char)s.codePointAt(2));

    }

    @org.junit.Test
    public void test36() {
//        set(0.1);
    }

    private int set(int i) {
        System.out.println(i);
        return i;
    }

    @org.junit.Test
    public void test37() {

        EAopLogTypes aop_log = EAopLogTypes.valueOf("");
        System.out.println(aop_log.getDescription());

    }

    @org.junit.Test
    public void test38() {

        String s = "123:456";
        System.out.println(s.substring(0, s.indexOf(":")));
        System.out.println(s.substring(s.indexOf(":")+1, s.length()));

    }

    @org.junit.Test
    public void test39() {

        String combinations = "1:3,4,5;2:6,7,8;";
        List<String> collect = Arrays.stream(combinations.split(";")).collect(Collectors.toList());
        Map<String, Integer> collect1 = collect.stream().flatMap(value -> {
            String substring = value.substring(0, value.indexOf(":"));
            String substring2 = value.substring(value.indexOf(":") + 1, value.length());
            return Arrays.stream(substring2.split(",")).map(value2 -> new StringBuilder(substring).append("-").append(value2).toString());
        }).collect(Collectors.toMap(String::toString, value -> 1));

        System.out.println(collect1);

    }

    @org.junit.Test
    public void test40() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("s", 1);
        map.put("r", 2);
        System.out.println(map.size());
        System.out.println(map.keySet().size());

    }

    @org.junit.Test
    public void test41() {

        String s = "1:2";
        String s2 = "2:3";
        System.out.println(s.substring(2));
        System.out.println(s.charAt(0));
        System.out.println(s2.charAt(0));
        System.out.println(s.charAt(0) + 1 == s2.charAt(0));

    }

    @org.junit.Test
    public void test42() {

        Integer[] ints = new Integer[10];
        ints[2] = 1;
        ints[4] = 4;
        System.out.println(ints.length);
        for (Integer it : ints) {
            System.out.println(it);
        }

    }
}
