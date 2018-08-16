package com.journey.clas;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/8/16.
 */
public class ClassTest {

    // 测试类执行顺序
    @Test
    public void test() {
        new B();
    }

}

class A {

    static {
        System.out.println("A-我是静态代码块");
    }

    {
        System.out.println("A-我是代码块");
    }

    public A() {
        System.out.println("A-我是构造方法");
    }
}

class B extends A {

    static {
        System.out.println("B-我是静态代码块");
    }

    {
        System.out.println("B-我是代码块");
    }

    public B() {
        System.out.println("B-我是构造方法");
    }
}
