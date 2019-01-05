package com.journey.config.spring.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author liuqingwen
 * @date 2018/10/18.
 */
public class JourneyNameSpaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("journey", new JourneyBeanDefinitionParser());
    }
}
