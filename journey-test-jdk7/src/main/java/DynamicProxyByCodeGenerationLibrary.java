import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liuqingwen
 * @date 2018/9/10.
 */
public class DynamicProxyByCodeGenerationLibrary implements MethodInterceptor {

    private Object realObject;

    public DynamicProxyByCodeGenerationLibrary(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

//        System.out.println("我是DynamicProxyByCodeGenerationLibrary#intercept -> start");
        proxy.invokeSuper(obj, args);
//        System.out.println("我是DynamicProxyByCodeGenerationLibrary#intercept -> end");
        return null;
    }

    public <E> E newProxyInstance() {

        long stime = System.currentTimeMillis();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(realObject.getClass());
        enhancer.setCallback(this);
        enhancer.setClassLoader(realObject.getClass().getClassLoader());
        E e = (E)enhancer.create();
        System.out.println("[CodeGenerationLibrary] " + (System.currentTimeMillis() - stime));

        return e;
    }
}
