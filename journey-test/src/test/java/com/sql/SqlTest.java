package com.sql;

import com.journey.string2.Strings;

import java.io.*;

/**
 * @author liuqingwen
 * @date 2019/1/17.
 */
public class SqlTest {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/liuqingwen/Downloads/delete.txt")));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/liuqingwen/Downloads/delete-2.txt")))) {

            int count = 0;
            String uid = bufferedReader.readLine();
            while (Strings.isNotBlank(uid)) {
//                bufferedWriter.write("insert task_package_result_"+uid.substring(uid.length() - 2)+" (userid, taskPackageNo, source, `status`, createTime, updateTime) SELECT "+uid+", 'unlock_DUJIAJIYI', 'vip-center-1', 1, now(), now() FROM DUAL WHERE NOT EXISTS(SELECT * FROM task_package_result_"+uid.substring(uid.length() - 2)+" WHERE userid = "+uid+");");
                bufferedWriter.write("delete from task_package_result_"+uid.substring(uid.length() - 2)+" where userId = "+uid+";");
                bufferedWriter.newLine();
                uid = bufferedReader.readLine();
                System.out.println(++count);
            }

//            for (int count = 0; count < 100; count++) {
//                bufferedWriter.write("select * from task_package_result_"+count+" u where u.source = 'vip-center-1';");
//                bufferedWriter.newLine();
////                uid = bufferedReader.readLine();
////                System.out.println(++count);
//            }

            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
