package com.journey.demo.web.filter.delegate;

import com.journey.demo.web.filter.NullFilter;
import com.journey.demo.web.filter.base.AbstractFilter;

/**
 * @author liuqingwen
 * @date 2018/10/10.
 */
public final class DelegateFilter {

    public final static AbstractFilter chooseFilter(Class<?> clas) {

        if (clas == NullFilter.class) {
            return new NullFilter();
        }

        return new NullFilter();
    }

}
