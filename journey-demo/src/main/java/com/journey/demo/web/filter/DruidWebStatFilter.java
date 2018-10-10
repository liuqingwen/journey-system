package com.journey.demo.web.filter;

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author liuqingwen
 * @date 2018/10/10.
 */
@Configuration
@WebFilter(urlPatterns = "/*", initParams = {
        @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,*.jsp,/druid/*"),
        @WebInitParam(name = "sessionStatMaxCount", value = "2000"),
        @WebInitParam(name = "sessionStatEnable", value = "true"),
        @WebInitParam(name = "profileEnable", value = "true")})
public class DruidWebStatFilter extends WebStatFilter {

}
