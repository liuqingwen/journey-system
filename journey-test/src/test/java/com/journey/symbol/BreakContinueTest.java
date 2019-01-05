package com.journey.symbol;

import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/8/16.
 */
public class BreakContinueTest {

    @Test
    public void test() {

        x:for (int index = 0; index < 10; index++) {
            y:for (int index2 = 0; index2 < 10; index2++) {
                System.out.println("index-" + index + " - index2-" + index2);
                if (index > 2) {
                    break x;
                } else {
                    if (index2 > 2) {
                        continue x;
                    }
                }
            }
        }

    }

}
