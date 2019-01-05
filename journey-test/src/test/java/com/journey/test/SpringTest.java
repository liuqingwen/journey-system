package com.journey.test;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author liuqingwen
 * @date 2018/2/5.
 */
public class SpringTest {

    @Test
    public void test() {

        String[] toke = StringUtils.tokenizeToStringArray("1,2,3,4,5", ",");
        System.out.println(Arrays.toString(toke));

    }

    @Test
    public void test2() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    @Test
    public void test3() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    @Test
    public void test4() {
        ExpressionParser parser = new SpelExpressionParser();
//         invokes 'getBytes()'
        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
        int message_length = (int)exp.getValue();
        System.out.println(message_length);
    }

}
