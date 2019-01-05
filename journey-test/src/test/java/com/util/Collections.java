package com.util;

import java.util.Collection;

/**
 * @author liuqingwen
 * @date 2018/9/27.
 */
public class Collections {

    public static final boolean isBlank(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static final boolean isNotBlank(Collection<?> collection) {
        return !isBlank(collection);
    }

}
