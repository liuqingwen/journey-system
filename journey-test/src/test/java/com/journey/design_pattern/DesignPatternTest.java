package com.journey.design_pattern;

import com.google.common.collect.Lists;
import org.junit.Test;

/**
 * @author liuqingwen
 * @date 2018/11/8.
 */
public class DesignPatternTest {

    @Test
    public void test() {

        DefaultFilterChain defaultFilterChain = new DefaultFilterChain(Lists.newArrayList(new DefaultFilter(), new DefaultFilter(), new DefaultFilter(), new DefaultFilter(), new DefaultFilter()));
        defaultFilterChain.doFilter("熊猫");

    }

}
