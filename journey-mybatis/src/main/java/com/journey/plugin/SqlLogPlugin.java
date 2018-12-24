package com.journey.plugin;

import com.journey.core.TimeCalculate;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.log4j.Logger;

import java.sql.Statement;
import java.util.Properties;

/**
 * @author liuqingwen
 * @date 2018/12/24.
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}),
        @Signature(type = StatementHandler.class, method = "batch", args = { Statement.class })})
public class SqlLogPlugin implements Interceptor {

    private static final Logger LOGGER = Logger.getLogger(SqlLogPlugin.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        String mark = TimeCalculate.mark();
        try {
            Object target = invocation.getTarget();
            if (target instanceof StatementHandler) {
                StatementHandler statementHandler = (StatementHandler) target;
                LOGGER.info(statementHandler.getBoundSql().getSql());
            }

            return invocation.proceed();
        } finally {
            LOGGER.info(String.format("sql 执行时间: %s %s", TimeCalculate.calculate(mark), "MS"));
        }
    }

    @Override
    public Object plugin(Object target) {
        LOGGER.info("插件已加载");
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
