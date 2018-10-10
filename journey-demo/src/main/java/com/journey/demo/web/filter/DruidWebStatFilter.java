package com.journey.demo.web.filter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author liuqingwen
 * @date 2018/10/10.
 */
@WebFilter(urlPatterns = "/*", initParams = {
        @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,*.jsp,/druid/*,*.json"),
        @WebInitParam(name = "sessionStatMaxCount", value = "2000"),
        @WebInitParam(name = "sessionStatEnable", value = "true"),
        @WebInitParam(name = "profileEnable", value = "true")})
public class DruidWebStatFilter extends WebStatFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        super.doFilter(request, response, chain);
    }
}
