package com.spring.notice.needs;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author liuqingwen
 * @date 2018/11/6.
 */
public class ActionApplication implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void login(String username, String password) {
        this.applicationContext.publishEvent(new DemoApplicationEvent(username));
    }
}
