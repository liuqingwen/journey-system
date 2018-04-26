package com.journey.io;

import org.junit.Test;

import java.io.*;
import java.util.List;

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

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(zipFileName))))){

            List<String> collect = bufferedReader.lines().collect(toList());
            System.out.println(collect);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
