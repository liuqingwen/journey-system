package com.spring.notice.needs;

import org.springframework.context.ApplicationListener;

/**
 * @author liuqingwen
 * @date 2018/11/6.
 */
public class DemoApplicationListener implements ApplicationListener<DemoApplicationEvent> {

    @Override
    public void onApplicationEvent(DemoApplicationEvent event) {
        System.out.println(event);
    }
}
