package com.divae.firstspirit.logging;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.logging.LogListener;

public final class LogListenerMock {

    private LogListenerMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static LogListenerBuilder logListenerWith() {
        return new DefaultLogListenerBuilder();
    }

    public interface LogListenerBuilder extends Builder<LogListener, LogListenerBuilder> {
    }

    private static final class DefaultLogListenerBuilder extends DefaultBuilder<LogListener, LogListenerBuilder, DefaultLogListenerBuilder> implements LogListenerBuilder {

        private DefaultLogListenerBuilder() {
        }
    }
}
