package com.journey.io;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author liuqingwen
 * @date 2018/4/24.
 */
public class FileTest {

    String[] arrs = new String[]{"我", "叫", "胡", "汗", "三"};
    String zipFilePath = "/data/web/";
    String fileName = "/data/web/test/user.txt";
    String zipFileName = "/data/web/user.zip";


    @Test
    public void test() {

        File path = new File(zipFilePath);
        if (!path.exists()) {
            path.mkdirs();
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileName), true)))) {
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


//        File file = new File("/data/web/ImGroupMsg/75172378/201804/64.zip");
//        System.out.println(file.getAbsolutePath());
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))){

            bufferedReader.lines().forEach(System.out::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test3() {

        System.out.println(new File(fileName).exists());
        System.out.println(new File(fileName).renameTo(new File("/data/web/user1.zip")));
        System.out.println(new File(fileName).exists());
        System.out.println(new File("/data/web/user1.zip").exists());
        System.out.println(new File("/data/web/user1.zip").renameTo(new File(fileName)));
        System.out.println(new File(fileName).exists());
        System.getProperty("line.separator");

    }

    @Test
    public void test4() {

        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName, true));
            File pathFile = new File(zipFilePath);
            Arrays.stream(pathFile.listFiles((dir, name) -> name.endsWith(".txt"))).forEach(file -> {
                try {
                    ZipEntry zipEntry = new ZipEntry(file.getAbsolutePath());
                    zipOutputStream.putNextEntry(zipEntry);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    String oneLine;
                    while ((oneLine = bufferedReader.readLine()) != null) {
                        zipOutputStream.write(oneLine.getBytes());
                        zipOutputStream.write(System.getProperty("line.separator").getBytes());
                    }
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() {

        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName, true));
            ZipEntry zipEntry = new ZipEntry("/data/web/test/");
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.closeEntry();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test6() {

        try {

            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFileName));
            ZipEntry nextEntry;
            while ((nextEntry = zipInputStream.getNextEntry()) != null) {

                System.out.println(nextEntry.getName());
                Scanner scanner = new Scanner(zipInputStream);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }

                zipInputStream.closeEntry();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
