package com.journey.demo.data.source.lookup.defaults;

import com.journey.demo.data.source.lookup.BaseMethodNameAutoDataSourceRouting;
import com.journey.demo.data.source.lookup.RoutingDataSourceHolder;
import com.journey.demo.tool.Patterns;
import com.journey.demo.tool.Strings;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author liuqingwen
 * @date 2018/10/16.
 */
@ConfigurationProperties(prefix = "datasource.ms")
public class DefaultMethodNameAutoDataSourceRouting extends BaseMethodNameAutoDataSourceRouting {

    /**
     * 主从库选择 master || slave
     */
    private List<Pattern> masterMethodRegex;
    private List<Pattern> slaveMethodRegex;

    public void setMasterMethodRegex(String masterMethodRegexs) {
        masterMethodRegexs = Strings.trim(masterMethodRegexs);
        if (Strings.isNullOrEmpty(masterMethodRegexs)) return ;
        packageMethodRegex(Patterns.SYMBOL_PATTERN.split(masterMethodRegexs), this.masterMethodRegex);
    }

    public void setSlaveMethodRegex(String slaveMethodRegexs) {
        slaveMethodRegexs = Strings.trim(slaveMethodRegexs);
        if (Strings.isNullOrEmpty(slaveMethodRegexs)) return ;
        packageMethodRegex(Patterns.SYMBOL_PATTERN.split(slaveMethodRegexs), this.slaveMethodRegex);
    }

    private final void packageMethodRegex(final String[] mss, List<Pattern> targetMethodRegex) {

        if (targetMethodRegex == null) {
            synchronized (this) {
                if (targetMethodRegex == null) {
                    targetMethodRegex = new ArrayList<>();
                }
                targetMethodRegex.addAll(Arrays.stream(mss).filter(regex -> !Strings.isNullOrEmpty(regex))
                        .map(regex -> Pattern.compile(Strings.trim(regex))).collect(Collectors.toList()));
            }
        }
        return ;
    }

    @Override
    protected void setCurrentDataSource(Map<String, List<Pattern>> sourceRulesMap, Method method) {

        String classNameVerifyStr = Strings.joint("", method.getDeclaringClass().getName(), method.getName()).toString();
        for (Map.Entry<String, List<Pattern>> entry : sourceRulesMap.entrySet()) {
            for (Pattern pattern : entry.getValue()) {
                if (pattern.matcher(classNameVerifyStr).matches()) {
                    dealCurrentMSeDataSource(entry.getKey(), method);
                    return ;
                }
            }
        }

        return ;
    }

    protected void dealCurrentMSeDataSource(String lookupKey, Method method) {

        if (masterMethodRegex == null || slaveMethodRegex == null) {
            RoutingDataSourceHolder.setMasterDataSourceLookupKey(lookupKey);
            return ;
        }

        for (Pattern pattern : masterMethodRegex) {
            if (pattern.matcher(method.getName()).matches()) {
                RoutingDataSourceHolder.setMasterDataSourceLookupKey(lookupKey);
                return ;
            }
        }

        for (Pattern pattern : slaveMethodRegex) {
            if (pattern.matcher(method.getName()).matches()) {
                RoutingDataSourceHolder.setSlaveDataSourceLookupKey(lookupKey);
                return ;
            }
        }

        return ;
    }
}
