package com.journey.unsafe;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author liuqingwen
 * @date 2018/9/2.
 */
public class UnSafeTest {

//    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final Unsafe UNSAFE;
//    private static final long stateOffset;
//    private static final long tailOffset;
    private static final long headOffset;

    private String head = "liu";

    public String getHead() {
        return head;
    }

//    static {
//        try {
//            stateOffset = unsafe.objectFieldOffset
//                    (UnSafeTest.class.getDeclaredField("state"));
//            tailOffset = unsafe.objectFieldOffset
//                    (UnSafeTest.class.getDeclaredField("tail"));
////            headOffset = UNSAFE.objectFieldOffset
////                    (UnSafeTest.class.getDeclaredField("tail"));
//        } catch (Exception ex) { throw new Error(ex); }
//    }

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafe.get(null);
            headOffset = UNSAFE.objectFieldOffset
                    (UnSafeTest.class.getDeclaredField("head"));
//            System.out.println(headOffset);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) {

        UnSafeTest unSafeTest = new UnSafeTest();
        boolean update = unSafeTest.update();
        System.out.println(update);
        System.out.println(unSafeTest.getHead());

    }

    public boolean update() {
        Object object = UNSAFE.getObject(this, headOffset);
        System.out.println(object);
        return UNSAFE.compareAndSwapObject(this, headOffset, "liu", "liu1");
    }


    @Test
    public void test() {

        try {
            User user = (User)UNSAFE.allocateInstance(User.class);
            System.out.println(user.getId());

            user.setId(12);
            System.out.println(user.getId());
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }

}

class User {

    private int id;

    private int name;

    private User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}

