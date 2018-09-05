package com.journey.annotation;

import org.junit.Test;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liuqingwen
 * @date 2018/9/3.
 */
@AnnotationTest2
public class AnnotationTest {

    @Test
    public void test() {

        boolean annotationPresent = AnnotationTest.class.isAnnotationPresent(AnnotationTest2.class);
        if (annotationPresent) {
            Annotation[] annotations = AnnotationTest.class.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            AnnotationTest2 annotation = AnnotationTest.class.getAnnotation(AnnotationTest2.class);
            System.out.println(annotation.value());
            System.out.println(annotation.msg());
        }
    }

    @Test1
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {

        Class<User> userClass = User.class;

        DBTable dbTable = userClass.getAnnotation(DBTable.class);
        if (dbTable == null || dbTable.name().equals("")) {
            System.out.println("dbTable 不允许为空");
            return ;
        }

        StringBuilder stringBuilder = new StringBuilder(1 << 6);
        stringBuilder.append("create table ").append(dbTable.name()).append(" ( ").append("\n");

        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field field : declaredFields) {
            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
            if (declaredAnnotations != null && declaredAnnotations.length > 0) {
                Annotation declaredAnnotation = declaredAnnotations[0];
                if (declaredAnnotation instanceof SQLInteger) {
                    SQLInteger sqlInteger = (SQLInteger)declaredAnnotation;
                    stringBuilder.append(sqlInteger.column()).append(" ").append(" int(11)").append(sqlInteger.constraints().isNull()).append(" ")
                            .append(sqlInteger.constraints().isPrimary()).append(",").append("\n");
                    continue;
                }

                if (declaredAnnotation instanceof SQLString) {
                    SQLString sqlString = (SQLString)declaredAnnotation;
                    stringBuilder.append(sqlString.column()).append(" varchar(").append(sqlString.size()).append(") ").append(sqlString.constraints().isNull()).append(" ")
                            .append(sqlString.constraints().isPrimary()).append(",").append("\n");
                    continue;
                }
            }
        }

        stringBuilder.append(")").replace(stringBuilder.length() - 3, stringBuilder.length() - 2, "");
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {

        AnnotationTest annotationTest = new AnnotationTest();
        Class<AnnotationTest> annotationTestClass = AnnotationTest.class;
        Method[] declaredMethods = annotationTestClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            try {
                if (method.isAnnotationPresent(Test1.class)) {
                    method.setAccessible(true);
                    method.invoke(annotationTest, null);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationTest2 {

    int value() default -1;

    String msg() default "Liu";
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test1 {
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DBTable {

    String name();
}

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface SQLString {

    String column();

    int size() default 21;

    Constraints constraints() default @Constraints;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLInteger {

    String column();

    Constraints constraints() default @Constraints;
}

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Constraints {

    String isNull() default " NOT NULL";

    String isPrimary() default " PRIMARY KEY";
}

@DBTable(name = "user")
class User {

    @SQLString(column = "username", size = 32, constraints = @Constraints(isPrimary = ""))
    private String username;

    @SQLInteger(column = "age", constraints = @Constraints(isNull = "", isPrimary = ""))
    private Integer age;

    @SQLInteger(column = "ID")
    private Integer ID;

}