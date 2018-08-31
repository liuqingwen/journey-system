package com.journey.test;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liuqingwen
 * @date 2018/2/9.
 */
public class ProxyTest {

    @Test
    public void test() {

        A a = new B();
        C c = new C(a);
        A a2 = (A)c.getProxyObject();
        a2.test();
        a2.test2();

    }

    class C implements InvocationHandler {

        private Object realObject;

        private Object proxyObject;

        public Object getProxyObject() {
            return proxyObject;
        }

        public C(Object realObject) {
            this.realObject = realObject;
            this.proxyObject = Proxy.newProxyInstance(realObject.getClass().getClassLoader(), realObject.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            this.proxyObject = proxy;
//            System.out.println(proxy.getClass());
//            System.out.println(proxy instanceof A);
//            System.out.println(proxy instanceof B);
//            System.out.println(A.class.isAssignableFrom(proxy.getClass()));
//            System.out.println(B.class.isAssignableFrom(proxy.getClass()));
            System.out.println("proxy-"+method.getName());
            return method.invoke(realObject, args);
        }

    }

    interface A {

        void test();

        void test2();

    }

    class B implements A {

        @Override
        public void test() {
            System.out.println("B -> 1");
        }

        @Override
        public void test2() {
            System.out.println("B -> 2");
        }
    }

    @Test
    public void test2() {

        A a = new B();
        System.out.println(a.getClass());
        System.out.println(a instanceof B);
        System.out.println(a instanceof A);
        System.out.println(a.getClass().isAssignableFrom(B.class));
        System.out.println(a.getClass().isAssignableFrom(A.class));
        System.out.println(B.class.isAssignableFrom(a.getClass()));
        System.out.println(A.class.isAssignableFrom(a.getClass()));

    }

    @Test
    public void test3() {

        System.out.println(Object.class.isAssignableFrom(String.class));
        System.out.println(String.class.isAssignableFrom(Object.class));
        System.out.println(A.class.isAssignableFrom(B.class));
        System.out.println(B.class.isAssignableFrom(A.class));

    }
}
