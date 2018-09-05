package com.journey.reflect;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * // TODO 一定要懂
 *
 * @author liuqingwen
 * @date 2018/9/4.
 */
public class MethodHandleTest {

    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset
                    (AbstractQueuedSynchronizer.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset
                    (AbstractQueuedSynchronizer.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset
                    (AbstractQueuedSynchronizer.class.getDeclaredField("tail"));

        } catch (Exception ex) { throw new Error(ex); }
    }

    @Test
    public void test() {

        Son son = new Son();
        son.thinking();

    }

}

class Grandfather {

    public void thinking() {
        System.out.println("i am grandfather");
    }

}

class Father extends Grandfather {

    public void thinking() {
        System.out.println("i am father");
    }

}

class Son extends Father {

    public void thinking() {

        MethodType methodType = MethodType.methodType(void.class);
        try {
            MethodHandle thinking = MethodHandles.lookup().findSpecial(Grandfather.class, "thinking", methodType, Grandfather.class);
            thinking.invoke(new Son());
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}

//class Son extends Father {
//
//    public void thinking() {
//
//        try {
//            MethodType methodType = MethodType.methodType(void.class);
//            Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
//            IMPL_LOOKUP.setAccessible(true);
//            MethodHandles.Lookup lookup = (MethodHandles.Lookup)IMPL_LOOKUP.get(null);
//            MethodHandle thinking = lookup.findSpecial(Grandfather.class, "thinking", methodType, Grandfather.class);
//            thinking.invoke(new Son());
//        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}