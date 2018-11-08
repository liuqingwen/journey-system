package com.journey.design_pattern;

import java.util.List;

/**
 * @author liuqingwen
 * @date 2018/11/8.
 */
public class DefaultFilterChain implements FilterChain {

    List<Filter> filterList;
    private int count = 0;

    public DefaultFilterChain(List<Filter> filterList) {
        this.filterList = filterList;
    }

    @Override
    public void doFilter(String username) {

        if (count == filterList.size()) {
            System.out.println("filer over");
        } else {
            Filter filter = filterList.get(count++);
            filter.doFilter(username + count, this);
        }
    }
}
