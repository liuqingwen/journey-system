package com.journey.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * @author liuqingwen
 * @date 2018/8/21.
 */
public class ReflectTest {

    @Test
    public void test() {

        A2 a = new A2();
        B b = new B(a);
        A proxyObject = (A)b.getProxyObject();
        proxyObject.send();

    }

    interface A {

        void send();

    }

    class A2 implements A {

        @Override
        public void send() {
            System.out.println("A2");
        }
    }

    class B implements InvocationHandler {

        private Object proxyObject;

        private Object realObject;

        public Object getProxyObject() {
            return proxyObject;
        }

        public B(Object realObject) {
            this.proxyObject = Proxy.newProxyInstance(realObject.getClass().getClassLoader(), realObject.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("start");
            method.invoke(realObject, args);
            System.out.println("end");
            return null;
        }
    }

    @Test
    public void test2() {

        System.out.println(Modifier.PUBLIC);
        System.out.println(Modifier.FINAL);
        System.out.println(Modifier.STATIC);

    }

}
