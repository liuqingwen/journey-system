package com.journey.core.appender.smtp;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.net.SMTPAppender;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.helpers.CyclicBuffer;

/**
 * @author liuqingwen
 * @date 2017/11/2.
 */
public class ErrorSMTPAppender extends SMTPAppender {

    /**
     * Perform SMTPAppender specific appending actions, mainly adding the event to
     * a cyclic buffer.
     */
    @Override
    protected void subAppend(CyclicBuffer<ILoggingEvent> cb, ILoggingEvent event) {

        if (event.getLevel().levelInt < Level.ERROR_INT) {
            return ;
        }

        if (isIncludeCallerData()) {
            event.getCallerData();
        }
        event.prepareForDeferredProcessing();
        cb.add(event);
    }

}
