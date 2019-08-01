package com.yanglf.mvc.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @author yanglf
 * @description
 * @since 2019/2/25
 **/
public class ServiceLogFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        if("service".equals(event.getLoggerName())){
            return FilterReply.ACCEPT;
        }
        return FilterReply.DENY;
    }
}
