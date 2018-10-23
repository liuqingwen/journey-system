package com.journey.demo.data.source.lookup;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;

/**
 * @author liuqingwen
 * @date 2018/10/16.
 */
@ConfigurationProperties(prefix = "datascource")
public class RoutingDataSource extends AbstractRoutingDataSource implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private Map<Object, Object> targetDataSources;

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        this.targetDataSources = targetDataSources;
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = super.getConnection();
        connection.prepareStatement("set names utf8mb4").executeQuery();
        return connection;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return RoutingDataSourceHolder.getDataSourceLookupKey();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    @Override
    public void afterPropertiesSet() {
        Objects.requireNonNull(this.targetDataSources, "targetDataSources is not null.");
        for (Map.Entry<Object, Object> entry : this.targetDataSources.entrySet()) {
            this.targetDataSources.put(entry.getKey(), getBean(String.valueOf(entry.getValue())));
        }

        super.setTargetDataSources(this.targetDataSources);
        super.afterPropertiesSet();
    }
}
