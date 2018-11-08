package com.journey.design_pattern;

/**
 * @author liuqingwen
 * @date 2018/11/8.
 */
public class DefaultFilter implements Filter {

    @Override
    public void doFilter(String username, FilterChain filterChain) {
        System.out.println(username);
        filterChain.doFilter(username);
    }
}
