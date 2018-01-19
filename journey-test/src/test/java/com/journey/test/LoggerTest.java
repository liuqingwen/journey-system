package com.journey.test;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.util.StatusPrinter;
import com.journey.base.BaseTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by liuqingwen on 2017/10/16.
 */
public class LoggerTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test public void test() throws Exception {
        while (true) {
            for (int index = 0; index < 1000; index++) {
                logger.debug("日志很明显日志很明显");
                logger.info("日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显");
                logger.warn("日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显");
                if (index < 10) {
                    logger.error("日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显", new Exception("我是一个Exception异常"));
                }
                Thread.sleep(1000);
            }
            break;
        }


    }

    @Test public void test1() throws Exception {
        logger.debug("日志很明显日志很明显");
        logger.info("日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显");
        logger.warn("日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显");
        logger.error("日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显日志很明显");
    }

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(LoggerTest.class);
        LoggerContext loggerContext = ((ch.qos.logback.classic.Logger) logger).getLoggerContext();
        loggerContext.reset();

        PatternLayoutEncoder patternLayoutEncoder = new PatternLayoutEncoder();
        patternLayoutEncoder.setContext(loggerContext);
        patternLayoutEncoder.setPattern("%-5level %logger{2} [%thread]: %msg%n");
        patternLayoutEncoder.start();

        ConsoleAppender<ILoggingEvent> consoleAppender = new ConsoleAppender();
        consoleAppender.setEncoder(patternLayoutEncoder);
        consoleAppender.setContext(loggerContext);
        consoleAppender.start();

        ((ch.qos.logback.classic.Logger) logger).addAppender(consoleAppender);

        logger.info("我是中国人");
        logger.error("我也是中国人");

    }

}
