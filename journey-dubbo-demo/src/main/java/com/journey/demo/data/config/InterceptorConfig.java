package com.journey.demo.data.config;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;

/**
 * @author liuqingwen
 * @date 2018/10/25.
 */
public class InterceptorConfig {


    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("*Service");
        beanNameAutoProxyCreator.setInterceptorNames("methodNameAutoDataSourceRouting");
        return beanNameAutoProxyCreator;
    }

}
