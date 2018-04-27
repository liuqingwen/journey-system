package com.journey.io;

import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

/**
 * @author liuqingwen
 * @date 2018/4/24.
 */
public class FileTest {

    String[] arrs = new String[]{"我", "叫", "胡", "汗", "三"};
    String zipFilePath = "/data/web/";
    String zipFileName = "/data/web/user.zip";

    @Test
    public void test() {

        File path = new File(zipFilePath);
        if (!path.exists()) {
            path.mkdirs();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(zipFileName), true)))) {
            for (String arr : arrs) {
                bufferedWriter.write(arr);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {


        File file = new File("/data/web/ImGroupMsg/75172378/201804/64.zip");
        System.out.println(file.getAbsolutePath());
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){

            bufferedReader.lines().forEach(System.out::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test3() {

        System.out.println(new File(zipFileName).exists());
        System.out.println(new File(zipFileName).renameTo(new File("/data/web/user1.zip")));
        System.out.println(new File(zipFileName).exists());
        System.out.println(new File("/data/web/user1.zip").exists());
        System.out.println(new File("/data/web/user1.zip").renameTo(new File(zipFileName)));
        System.out.println(new File(zipFileName).exists());


    }

}

class A {
    private static A a = new A();
    private A() {

    }

    private static A get() {
        return a;
    }
}
