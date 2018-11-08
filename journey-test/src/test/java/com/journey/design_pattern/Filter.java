package com.journey.design_pattern;

/**
 * @author liuqingwen
 * @date 2018/11/8.
 */
public interface Filter {

    void doFilter(String username, FilterChain filterChain);

}
