package com.journey.demo.web.config.servlet;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

/**
 * @author liuqingwen
 * @date 2018/10/10.
 */
@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<? super Servlet> getServletRegistrationBean() {
        ServletRegistrationBean<? super Servlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "test1234");
        return servletRegistrationBean;
    }

}
