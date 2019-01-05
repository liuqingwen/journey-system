package com.journey.demo.data.source.lookup;

import com.journey.demo.tool.Strings;

/**
 * @author liuqingwen
 * @date 2018/10/16.
 */
public class RoutingDataSourceHolder {

    private static final ThreadLocal<String> dataSourceLookup = ThreadLocal.withInitial(() -> null);

    public static void setDataSourceLookupKey(String lookupKey) {
        dataSourceLookup.set(lookupKey);
    }

    public static void setMasterDataSourceLookupKey(String lookupKey) {
        RoutingDataSourceHolder.setDataSourceLookupKey(Strings.joint("", lookupKey, "-master").toString());
    }

    public static void setSlaveDataSourceLookupKey(String lookupKey) {
        RoutingDataSourceHolder.setDataSourceLookupKey(Strings.joint("", lookupKey, "-slave").toString());
    }

    public static String getDataSourceLookupKey() {
        return dataSourceLookup.get();
    }
}
