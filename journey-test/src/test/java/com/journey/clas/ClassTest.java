package com.journey.clas;

import com.journey.clas.bojo.UserBO;
import com.journey.enums.PaymentInvoiceStatusEnum;
import com.journey.test.User;
import org.junit.Test;
import sun.misc.SharedSecrets;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuqingwen
 * @date 2018/9/30.
 */
public class ClassTest {

    @Test
    public void test() {

        System.out.println("test start");

        Class<User> userClass = User.class;
        System.out.println("Object.class = " + userClass.getName());

        User u = new User();
        System.out.println("class  = " + u.getClass().getName());

        try {
            Class<?> aClass = Class.forName("com.journey.test.User");
            System.out.println("class2 = " + aClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() {

        Class integerClass = int.class;

        integerClass = double.class;

        Class<Integer> integerClass2 = Integer.class;

//        integerClass2 = double.class;
    }

    @Test
    public void test3() {

        Class<UserBO> userBOClass = UserBO.class;
        try {
            Constructor<UserBO> declaredConstructor = userBOClass.getDeclaredConstructor(int.class);
            declaredConstructor.setAccessible(true);
            UserBO userBO = declaredConstructor.newInstance(127);
//            userBO.setId(1207);
            System.out.print(userBO);
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test4() {

        Class<UserBO> userBOClass = UserBO.class;
        try {
            Constructor<?>[] declaredConstructors = userBOClass.getDeclaredConstructors();
            for (Constructor constructor : declaredConstructors) {
                System.out.println(constructor.toString());
                Class[] parameterTypes = constructor.getParameterTypes();
                System.out.print("(");
                for (Class clas :parameterTypes) {
                    System.out.print(clas.getName());
                }
                System.out.println(")");
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test5() {

        Class<UserBO> userBOClass = UserBO.class;
        try {
            Constructor<UserBO> declaredConstructor = userBOClass.getDeclaredConstructor(int.class);
            declaredConstructor.setAccessible(true);
            UserBO userBO = declaredConstructor.newInstance(127);
//            userBO.setId(1207);
            System.out.println(userBO);

            Field declaredField = userBO.getClass().getDeclaredField("id");
            System.out.println(declaredField.getName());
            declaredField.setAccessible(true);
            System.out.println(declaredField.get(userBO));

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException
                | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6() {

        Class<User> userClass = User.class;
        int modifiers = userClass.getModifiers();
        System.out.println(Modifier.isPublic(modifiers));

        Map<? extends Enum, String> map = new HashMap<>();

        PaymentInvoiceStatusEnum[] enumConstantsShared = SharedSecrets.getJavaLangAccess().getEnumConstantsShared(PaymentInvoiceStatusEnum.class);
        for (PaymentInvoiceStatusEnum paymentInvoiceStatusEnum : enumConstantsShared) {
            System.out.println(paymentInvoiceStatusEnum);
        }

    }

    @Test
    public void test7() {

        System.out.println(ClassTest.class.getName());

    }

    @Test
    public void  test8() {

        Type genericSuperclass = (new ArrayList<Map<String, String>>() {}).getClass().getGenericSuperclass();
        Type actualTypeArgument = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        System.out.println(actualTypeArgument);

    }
}
