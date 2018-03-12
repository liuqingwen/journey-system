package com.journey.func;

import com.journey.enums.aop.ResponseReturnType;
import org.junit.Test;

import java.util.function.Supplier;

/**
 * @author liuqingwen
 * @date 2018/3/12.
 */
public class FunctionTest {

    @Test
    public void test() {

        ResponseReturnType responseReturnType = ResponseReturnType.FAIL;
        System.out.println(((Supplier<String>)(() -> {switch(responseReturnType) {
            case FAIL: return ResponseReturnType.FAIL.getDescription();
            case SUCCESS: return ResponseReturnType.SUCCESS.getDescription();
            default: return "不知道什么情况";
        }})).get());

    }

}
