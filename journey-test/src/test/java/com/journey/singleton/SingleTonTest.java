package com.journey.singleton;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/5/5.
 */
public class SingleTonTest {

    @Test
    public void test() {

        System.out.println(L.l.getName());

    }

}


class L {

    public static final L l = new L("liu");

    private String name;

    private L(String name) {
        this.name = name;
        if (l != null) {
            throw new RuntimeException("不允许创建对象");
        }
    }

    public String getName() {
        return name;
    }
}
