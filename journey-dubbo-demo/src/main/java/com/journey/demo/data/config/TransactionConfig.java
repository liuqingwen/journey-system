package com.journey.demo.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author liuqingwen
 * @date 2018/10/25.
 */
public class TransactionConfig {

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager();
    }


}
