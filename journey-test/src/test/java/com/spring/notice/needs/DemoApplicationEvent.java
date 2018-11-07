package com.spring.notice.needs;

import org.springframework.context.ApplicationEvent;

/**
 * @author liuqingwen
 * @date 2018/11/6.
 */
public class DemoApplicationEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DemoApplicationEvent(Object source) {
        super(source);
    }
}
