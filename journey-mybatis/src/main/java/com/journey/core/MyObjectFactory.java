package com.journey.core;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;

/**
 * @author liuqingwen
 * @date 2018/12/23.
 */
public class MyObjectFactory extends DefaultObjectFactory {

    private static final Logger LOGGER = Logger.getLogger(MyObjectFactory.class);

    public MyObjectFactory() {
        super();
    }

    @Override
    public <T> T create(Class<T> type) {
        LOGGER.info("订制对象工厂的 create 方法构建单个对象");
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        LOGGER.info("订制对象工厂的 create 方法构建列表对象");
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    protected Class<?> resolveInterface(Class<?> type) {
        return super.resolveInterface(type);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
