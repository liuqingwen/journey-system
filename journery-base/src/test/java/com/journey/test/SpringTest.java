package com.journey.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author liuqingwen
 * @date 2018/4/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Test-ApplicationContext.xml"})
public class SpringTest {

    @Resource(name = "myField") private Integer fieldRetrievingFactoryBean;
    @Resource(name = "java.sql.Connection.TRANSACTION_SERIALIZABLE") private Integer fieldRetrievingFactoryBean1;

    @Test
    public void test() {

        System.out.println(fieldRetrievingFactoryBean);
        System.out.println(fieldRetrievingFactoryBean1);

    }

}
