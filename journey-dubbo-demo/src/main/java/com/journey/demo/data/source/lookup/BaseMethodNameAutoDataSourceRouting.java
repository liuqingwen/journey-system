package com.journey.demo.data.source.lookup;

import com.journey.demo.tool.Patterns;
import com.journey.demo.tool.Strings;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author liuqingwen
 * @date 2018/10/16.
 */
@ConfigurationProperties(prefix = "datasource.routing")
public abstract class BaseMethodNameAutoDataSourceRouting implements MethodBeforeAdvice {

    /** 数据库切换规则 */
    private Map<String, List<Pattern>> sourceRulesMap;

    public void setSourceRulesMap(final Map<String, String> rulesMap) {

        if (this.sourceRulesMap == null && rulesMap != null) {
            synchronized (this) {
                if (this.sourceRulesMap == null) {
                    this.sourceRulesMap = new HashMap<>(rulesMap.size());
                    packageSourceRule(rulesMap);
                }
            }
        }
    }

    private void packageSourceRule(final Map<String, String> rulesMap) {

        for (Map.Entry<String, String> entry : rulesMap.entrySet()) {
            String key = Strings.trim(entry.getKey()), value = Strings.trim(entry.getValue());
            if (!Strings.isNullOrEmpty(value) && !Strings.isNullOrEmpty(key)) {
                List<Pattern> patterns = this.sourceRulesMap.get(key);
                if (patterns == null) {
                    this.sourceRulesMap.put(key, new ArrayList<>());
                    patterns = this.sourceRulesMap.get(key);
                }
                patterns.addAll(Arrays.stream(Patterns.SYMBOL_PATTERN.split(value)).filter(rule -> !Strings.isNullOrEmpty(rule))
                        .map(rule -> Pattern.compile(Strings.trim(rule))).collect(Collectors.toList()));
            }
        }
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

        String lookupKey = determineCurrentDataSourceLookupKey(this.sourceRulesMap, method);
        if (lookupKey != null) determineCurrentMSeDataSource(lookupKey, method);
    }

    protected abstract String determineCurrentDataSourceLookupKey(Map<String, List<Pattern>> sourceRulesMap, Method method);

    protected abstract void determineCurrentMSeDataSource(String lookupKey, Method method);

}
