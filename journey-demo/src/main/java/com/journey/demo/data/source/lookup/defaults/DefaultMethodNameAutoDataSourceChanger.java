package com.journey.demo.data.source.lookup.defaults;

import com.journey.demo.data.source.lookup.BaseMethodNameAutoDataSourceChanger;
import com.journey.demo.data.source.lookup.RoutingDataSourceHolder;
import com.journey.demo.tool.Strings;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author liuqingwen
 * @date 2018/10/16.
 */
public class DefaultMethodNameAutoDataSourceChanger extends BaseMethodNameAutoDataSourceChanger {

    /**
     * 主从库选择 master || slave
     */
    private List<Pattern> masterChanger;
    private List<Pattern> slaveChanger;

    public void setMasterChanger(final List<String> masterChanger) {
        packageChanger(masterChanger, this.masterChanger);
    }

    public void setSlaveChanger(final List<String> slaveChanger) {
        packageChanger(slaveChanger, this.slaveChanger);
    }

    private final void packageChanger(final List<String> changers, List<Pattern> targetChangers) {
        List<String> unmodifiableChangers = Collections.unmodifiableList(changers);
        if (targetChangers == null) {
            synchronized (changers) {
                if (targetChangers == null) {
                    for (String changer : unmodifiableChangers) {
                        targetChangers.add(Pattern.compile(changer));
                    }
                }
            }
        }
        return ;
    }

    @Override
    protected String setDataSourceLookupKey(Map<String, List<Pattern>> sourceRulesMap, Method method) {

        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String packageVerifyStr = Strings.joint("", className, methodName).toString();

        for (Map.Entry<String, List<Pattern>> entry : sourceRulesMap.entrySet()) {
            List<Pattern> patterns = entry.getValue();
            for (Pattern pattern : patterns) {
                if (pattern.matcher(packageVerifyStr).matches()) {
                    return entry.getKey();
                }
            }
        }

        return null;
    }

    protected void setMasterOrSlaveDataSource(String lookupKey, Method method) {

        if (masterChanger == null || slaveChanger == null) {
            RoutingDataSourceHolder.setMasterDataSourceLookupKey(lookupKey);
            return ;
        }

        for (Pattern pattern2 : masterChanger) {
            if (pattern2.matcher(method.getName()).matches()) {
                RoutingDataSourceHolder.setMasterDataSourceLookupKey(lookupKey);
                return ;
            }
        }

        for (Pattern pattern2 : slaveChanger) {
            if (pattern2.matcher(method.getName()).matches()) {
                RoutingDataSourceHolder.setSlaveDataSourceLookupKey(lookupKey);
                return ;
            }
        }

        return ;
    }
}
