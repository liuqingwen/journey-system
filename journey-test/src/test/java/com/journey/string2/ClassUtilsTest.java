package com.journey.string2;

import org.junit.Test;
import org.springframework.util.ClassUtils;

/**
 * @author liuqingwen
 * @date 2018/6/17.
 */
public class ClassUtilsTest {

    @Test
    public void test() {

        String classPackage = ClassUtils.classPackageAsResourcePath(ClassUtilsTest.class);
        System.out.println(classPackage);

    }

}
