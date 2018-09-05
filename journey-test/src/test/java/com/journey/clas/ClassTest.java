package com.journey.clas;

import com.journey.test.User;
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

    @Test
    public void test2() {

        Class<Object> objectClass = Object.class;
        Class<String> stringClass = String.class;
//        System.out.println(objectClass == User.class);
        System.out.println(stringClass);

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

