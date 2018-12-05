package com.classloader;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.junit.Test;
import sun.misc.Unsafe;

import java.util.List;

/**
 * @author liuqingwen
 * @date 2018/12/1.
 */
public class ClassLoaderTest {

    @Test
    public void test() {

        System.out.println(List.class.getClassLoader());
        System.out.println(Unsafe.class.getClassLoader());
        System.out.println(FabricMySQLDriver.class.getClassLoader());

    }


}
