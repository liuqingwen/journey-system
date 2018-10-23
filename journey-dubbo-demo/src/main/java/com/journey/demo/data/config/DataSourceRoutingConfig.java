package com.journey.demo.data.config;

import com.journey.demo.data.source.lookup.BaseMethodNameAutoDataSourceRouting;
import com.journey.demo.data.source.lookup.defaults.DefaultMethodNameAutoDataSourceRouting;
import org.springframework.context.annotation.Bean;

/**
 * @author liuqingwen
 * @date 2018/10/22.
 */
public class DataSourceRoutingConfig {

    @Bean
    public BaseMethodNameAutoDataSourceRouting getBaseMethodNameAutoDataSourceChanger() {
        return new DefaultMethodNameAutoDataSourceRouting();
    }

}
