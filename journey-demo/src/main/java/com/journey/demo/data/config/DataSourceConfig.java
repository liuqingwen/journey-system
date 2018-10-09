package com.journey.demo.data.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author liuqingwen
 * @date 2018/10/9.
 */
public class DataSourceConfig {

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(@Autowired DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate getSqlSessionTemplate(@Autowired SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean.getObject());
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionTemplateBeanName("sqlSessionTemplate");
        mapperScannerConfigurer.setBasePackage("com.journey.demo.data.mapper");
        return mapperScannerConfigurer;
    }

}
