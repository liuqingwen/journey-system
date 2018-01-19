package com.journey.enums.aop;

import java.util.Arrays;

/**
 * 请求返回结果
 *
 * Created by liuqingwen on 2017/9/21.
 */
public enum ResponseReturnType {

    SUCCESS(1, "成功"), FAIL(2, "失败");

    private int code;
    private String description;
    private String key;

    ResponseReturnType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }


    public String getDescription() {
        return description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public static ResponseReturnType fromCode(int code) {
        return Arrays.asList(ResponseReturnType.values()).stream()
                .filter(responseReturnType -> responseReturnType.getCode() == code)
                .findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "ResponseReturnType{" +
                "code=" + code +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}
