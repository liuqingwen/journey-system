package com.journey.test;

import java.io.FileNotFoundException;

/**
 * @author liuqingwen
 * @date 2018/2/9.
 */
public class ExceptionTest {

    public void test() {


        try {

            throw new FileNotFoundException();

        }catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {

        }


    }

}
