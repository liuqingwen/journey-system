package com.journey.test;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class StringUtils {

    public static boolean allIsNotNull(String... s){

        return isNotNullOrEmpty(Types.TYPE_NULL, s);
    }

    public static boolean allIsNotEmpty(String... s){

        return StringUtils.allIsNotNull(s) ? isNotNullOrEmpty(Types.TYPE_EMPTY, s) : false;
    }

    private static boolean isNotNullOrEmpty(Types type, String... s) {

        if(s == null || s.length == 0) {
            return false;
        }

        int len = s.length;
        for(int index = 0; index < (len%2 > 0 ? len/2 + 1 : len/2); index++) {
            if(type == Types.TYPE_NULL) {
                if(s[index] == null) {
                    return false;
                }

                if(s[len - 1 - index] == null) {
                    return false;
                }
            }else {
                if(s[index].trim().equals("")) {
                    return false;
                }

                if(s[len - 1 - index].trim().equals("")) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

//        String[] strs = new String[]{"1", "2"," 1 ", "2", "3", null, " 1 ", "5"};
//        System.out.println(StringUtils.allIsNotNull(strs));
//        System.out.println(StringUtils.allIsNotEmpty(strs));


//        System.out.println(String.format("%s, %s", 1, 2));
//
//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//
//        for (int index = 0; index < 10; index++) {
//            final String s = index + "";
//            executorService.submit(() -> System.out.println(s));
//        }

//        System.out.println(UUID.randomUUID());

//        System.out.println(String.format("safsadf%s我的", "什么鬼"));


//        String[][] a = new String[][]{{"1", "2"}, {"1", "2"}};
//        m(a);


//        StringBuffer param = new StringBuffer();
//        param.append("username=");
//        param.append(1);
//        param.append("&password=");
//        param.append(2);
//
//        System.out.println(param.toString());

//        m("1", "2", "3");


        Map<String, Object> map = new HashMap<>();
        map.put("use", 1);
        map.put("wap", "guodu");
        map.put("pc", "guodu");
        map.put("app", "xuanwu");
        System.out.println(JSON.toJSONString(map));

    }

    private static void m(String... mobile) {
        System.out.println(mobile);
        System.out.println(Arrays.toString(mobile));
        Optional<String> reduce = Arrays.asList(mobile).stream().reduce((mobiles, item) -> mobiles.concat("%20").concat(item));
        System.out.println(reduce.get());
    }

    public enum Types {

        TYPE_NULL(0, "NULL"), TYPE_EMPTY(1, "EMPTY");

        private int code;
        private String description;

        Types(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return this.code;
        }

        public String getDescription() {
            return this.description;
        }
    }
}



