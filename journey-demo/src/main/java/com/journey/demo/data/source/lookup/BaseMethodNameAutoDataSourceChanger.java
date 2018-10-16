package com.journey.demo.data.source.lookup;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author liuqingwen
 * @date 2018/10/16.
 */
public abstract class BaseMethodNameAutoDataSourceChanger implements MethodBeforeAdvice {

    /**
     * 数据库切换规则
     */
    private Map<String, List<Pattern>> sourceRulesMap;
    // 切分
    private static final Pattern SYMBOL_PATTERN = Pattern.compile("[,，\\s]+");

    public void setRulesMap(final Map<String, String> rulesMap) {

        if (rulesMap == null) {
            synchronized (rulesMap) {
                if (rulesMap == null) {

                    for (Map.Entry<String, String> entry : rulesMap.entrySet()) {

                        String[] split = SYMBOL_PATTERN.split(entry.getValue());
                        if (split != null && split.length > 0) {

                            List<Pattern> patterns = this.sourceRulesMap.get(entry.getKey());
                            if (patterns == null) {
                                this.sourceRulesMap.put(entry.getKey(), new ArrayList<>());
                                patterns = this.sourceRulesMap.get(entry.getKey());
                            }

                            for (String regex : split) {
                                patterns.add(Pattern.compile(regex));
                            }
                        }

                    }
                }
            }
        }
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        String lookupKey = setDataSourceLookupKey(this.sourceRulesMap, method);
        if (lookupKey != null) {
            setMasterOrSlaveDataSource(lookupKey, method);
        }
    }

    protected abstract String setDataSourceLookupKey(Map<String, List<Pattern>> sourceRulesMap, Method method);

    protected abstract void setMasterOrSlaveDataSource(String lookupKey, Method method);

}
