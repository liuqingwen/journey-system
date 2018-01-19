package com.journey.aop.redis;

import com.google.common.base.Preconditions;
import com.journey.enums.aop.EAopLogTypes;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by liuqingwen on 2017/6/19.
 */
@Aspect
public class RedisBeforeExecuteAOP {

    private Logger logger = LoggerFactory.getLogger(RedisBeforeExecuteAOP.class);

    @Before("execution(* com.journey.redis.*.*(..))")
    public void redisBeforeCheck(JoinPoint joinpoint) throws Throwable {
        Object[] args = joinpoint.getArgs();
        logger.info("{} Jedis 操作参数 {} ", new Object[]{EAopLogTypes.AOP_LOG.getDescription(), args == null || args.length == 0 ? null : Arrays.toString(args)});
        Preconditions.checkArgument(!(args == null || args.length == 0), "key不允许为空");
    }

}
