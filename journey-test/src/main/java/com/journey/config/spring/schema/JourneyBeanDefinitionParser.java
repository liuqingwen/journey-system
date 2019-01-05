package com.journey.config.spring.schema;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @author liuqingwen
 * @date 2018/10/18.
 */
public class JourneyBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {

        String id = element.getAttribute("id");
        String name = element.getAttribute("name");
        String age = element.getAttribute("age");

        builder.addPropertyValue("id", id);
        builder.addPropertyValue("name", name);
        builder.addPropertyValue("age", age);

        return ;
    }
}
