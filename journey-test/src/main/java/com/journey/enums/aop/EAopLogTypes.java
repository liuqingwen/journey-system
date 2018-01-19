package com.journey.enums.aop;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by liuqingwen on 2017/6/19.
 */
public enum EAopLogTypes {

    AOP_LOG(1, "AOP Redis日志 : ");

    private int code;
    private String description;

    EAopLogTypes(int code, String decription) {
        this.code = code;
        this.description = decription;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public static EAopLogTypes fromCode(final int code) {
        return Arrays.asList(EAopLogTypes.values()).stream().collect(Collectors.toMap(EAopLogTypes::getCode, aopLogType -> aopLogType)).get(Integer.valueOf(code));
    }
}
