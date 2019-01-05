package com.journey.demo.data.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.journey.demo.data.source.lookup.RoutingDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author liuqingwen
 * @date 2018/10/9.
 */
public class DataSourceConfig {

    @Bean(value = "main-master", initMethod = "init")
    public DruidDataSource dataSourceMasterMain() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public DataSource dataSource() {
        return new RoutingDataSource();
    }

}
