package com.journey.reflect;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.*;
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

    class D implements InvocationHandler {

        private Object realObject;

        public D(Object realObject) {
            this.realObject = realObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("我是代理invoke");
            return method.invoke(realObject, args);
        }
    }

    interface A {

        void test();

        void test2();

    }

    class B implements A {

        public B() {
        }

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

    @Test
    public void test4() {

        B b = new B();
        D d = new D(b);

        A a = (A)Proxy.newProxyInstance(b.getClass().getClassLoader(), b.getClass().getInterfaces(), d);
        System.out.println(a);

    }

    class E implements MethodInterceptor {

//        private Object realObject ;

//        public E(Object realObject) {
//            this.realObject = realObject;
//        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            System.out.println("我是enhancer代理方法");
//            return method.invoke(realObject, args);
            return proxy.invokeSuper(obj, args);
        }
    }

    public class F {

        public void test() {
            System.out.println("F -> test");
        }

    }

    @Test
    public void test5() {

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(RealF.class.getClassLoader());
        enhancer.setSuperclass(RealF.class);
        enhancer.setInterfaces(RealF.class.getInterfaces());
        enhancer.setCallback(new E());
        enhancer.setCallbackFilter((method) -> 0);

        RealF b2 = (RealF)enhancer.create();
        b2.test();

    }

    @Test
    public void test6() {

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/log/web/");

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(IUserService.class.getClassLoader());
        enhancer.setSuperclass(IUserService.class);
        enhancer.setCallbacks(new Callback[]{NoOp.INSTANCE, (MethodInterceptor)(obj, method, args, methodProxy) ->  {
            if (method.getName().indexOf("create") > -1 || method.getName().indexOf("delete") > -1) {
                System.out.println("没有权限");
                return null;
            }
            return methodProxy.invokeSuper(obj, args);
        }});
        enhancer.setCallbackFilter((method) -> method.getName().indexOf("create") > -1 ? 1 : 0);
        IUserService iUserService = (IUserService)enhancer.create();
        iUserService.create();
        iUserService.delete();
        iUserService.update();
        iUserService.query();
    }
}
