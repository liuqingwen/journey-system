package base.java8.test;

import java.io.Console;
import java.util.Scanner;

/**
 * @author liuqingwen
 * @date 2018/1/19.
 */
public class ScannerTest {

    public static void main(String[] args) throws Exception {

//        System.out.println("My I know you name ?");
//        Scanner read = new Scanner(System.in);
//        String name = read.next();
//        System.out.println(String.format("My name is %s", name));

        Console console = System.console();
        char[] password = console.readPassword("input your password :");
        System.out.println(new String(password));
    }

}
