package com.journey.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author liuqingwen
 * @date 2018/9/2.
 */
public class UnSafeTest {


    private String head = new String("liu");
    private static long headOffset;

    public String getHead() {
        return head;
    }

    static Unsafe unsafe = null;
    static {
        try{
            Class<?> clazz = Unsafe.class;
            Field f;
            f = clazz.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(clazz);
            Class c = UnSafeTest.class;
            headOffset = unsafe.staticFieldOffset(c.getDeclaredField("head"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        UnSafeTest unSafeTest = new UnSafeTest();
        boolean update = unSafeTest.update();
        System.out.println(update);
        System.out.println(unSafeTest.getHead());

    }

    public boolean update() {
        return unsafe.compareAndSwapObject(this, headOffset, "liu", "liu1");
    }



}
