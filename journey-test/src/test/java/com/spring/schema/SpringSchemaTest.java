package com.spring.schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuqingwen
 * @date 2018/10/18.
 */
public class SpringSchemaTest {

    public static void main(String[] args) {

       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-context-defined.xml");
       Object bean = applicationContext.getBean("89757");
       System.out.println(bean);

    }

}
