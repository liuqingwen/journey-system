package com.spring.notice;

import com.spring.notice.needs.ActionApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuqingwen
 * @date 2018/11/6.
 */
public class NoticeTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-listener.xml");
        ActionApplication actionApplication = classPathXmlApplicationContext.getBean("actionApplication", ActionApplication.class);
        actionApplication.login("刘庆文", "123");

    }

}
