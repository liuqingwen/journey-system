package com.journey.test;

import com.alibaba.fastjson.JSON;
import com.journey.enums.aop.ResponseReturnType;

/**
 * Created by liuqingwen on 2017/7/20.
 */
public class EnumTest {

    public static void main(String[] args) {


//        KK.KK_2.kk("sss");

//        System.out.println(JSON.toJSON(ResponseReturnType.SUCCESS));

        ResponseReturnType responseReturnType = ResponseReturnType.SUCCESS;
        responseReturnType.setKey("sssss");

        boolean o = ResponseReturnType.SUCCESS == responseReturnType;
        System.out.println(o);

    }


    public enum KK {

        KK_1(1, "1") {
            @Override
            public void kk(String s) {
                super.kk(s);
            }
        }, KK_2(2, "2") {
            @Override
            public void kk(String s) {
                super.kk(s);
            }
        };

        private int code;
        private String description;

        KK(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public void kk(String s) {
            System.out.println(s + this.code + this.description);
        }
    }

}
