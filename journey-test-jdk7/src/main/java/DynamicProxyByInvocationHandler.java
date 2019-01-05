import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liuqingwen
 * @date 2018/9/10.
 */
public class DynamicProxyByInvocationHandler implements InvocationHandler {

    private Object realObject;

    public DynamicProxyByInvocationHandler(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//        System.out.println("我是DynamicProxyByInvocationHandler#invoke->start");
        method.invoke(realObject, args);
//        System.out.println("我是DynamicProxyByInvocationHandler#invoke->end");
        return null;
    }

    public <E> E newProxyInstance() {
        long stime = System.currentTimeMillis();
        E e = (E)Proxy.newProxyInstance(this.realObject.getClass().getClassLoader(), this.realObject.getClass().getInterfaces(), this);
        System.out.println("[JDK] " + (System.currentTimeMillis() - stime));
        return e;
    }
}
