package com.journey.demo.web.config;

import com.journey.demo.web.filter.NullFilter;
import com.journey.demo.web.filter.delegate.DelegateFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;

/**
 * @author liuqingwen
 * @date 2018/10/10.
 */
@Configuration
public class WebXmlConfig {

    @Bean
    public FilterRegistrationBean<? super Filter> getFilterRegistrationBean() {
        FilterRegistrationBean<? super Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(DelegateFilter.chooseFilter(NullFilter.class));
        filterRegistrationBean.setUrlPatterns(new ArrayList<String>() {{add("/*");}});
        return filterRegistrationBean;
    }
}
