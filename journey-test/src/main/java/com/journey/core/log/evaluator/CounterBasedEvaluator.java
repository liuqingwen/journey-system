package com.journey.core.log.evaluator;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluatorBase;

/**
 * @author liuqingwen
 * @date 2017/11/2.
 */
public class CounterBasedEvaluator extends EventEvaluatorBase<ILoggingEvent> {

    int counter = 0;
    int limit_count = 5;

    @Override
    public boolean evaluate(ILoggingEvent event) throws NullPointerException, EvaluationException {

        try {
            Level level = event.getLevel();
            if (level.levelInt >= Level.ERROR_INT) {
                counter++;
            }

            return counter == limit_count;
        } finally {
            if (counter == limit_count) {
                counter = 0;
            }
        }
    }
}
