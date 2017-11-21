package com.divae.firstspirit.access;

import com.divae.firstspirit.agency.SpecialistsBrokerMock.DefaultSpecialistsBrokerBuilder;
import com.divae.firstspirit.agency.SpecialistsBrokerMock.SpecialistsBrokerBuilder;
import de.espirit.firstspirit.access.ScriptContext;

import static org.mockito.Mockito.when;

public final class ScriptContextMock {

    private ScriptContextMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends ScriptContext> TruncatedScriptContextBuilder<T> scriptContextWith() {
        return new TruncatedDefaultScriptContextBuilder<>();
    }

    public interface ScriptContextBuilder<T extends ScriptContext, TBUILDER extends ScriptContextBuilder<T, TBUILDER>> extends SpecialistsBrokerBuilder<T, TBUILDER> {
        TBUILDER aProperty(Object value, String key);
    }

    public static class DefaultScriptContextBuilder<T extends ScriptContext, EBUILDER extends ScriptContextBuilder<T, EBUILDER>, TBUILDER extends DefaultScriptContextBuilder<T, EBUILDER, TBUILDER>> extends DefaultSpecialistsBrokerBuilder<T, EBUILDER, TBUILDER> implements ScriptContextBuilder<T, EBUILDER> {

        protected DefaultScriptContextBuilder() {
        }

        @Override
        public final EBUILDER aProperty(Object value, String key) {
            when(getBuildable().getProperty(key)).thenReturn(value);
            return getInterfaceBuilder();
        }
    }

    public interface TruncatedScriptContextBuilder<T extends ScriptContext> extends ScriptContextBuilder<T, TruncatedScriptContextBuilder<T>> {
    }

    private static final class TruncatedDefaultScriptContextBuilder<T extends ScriptContext> extends DefaultScriptContextBuilder<T, TruncatedScriptContextBuilder<T>, TruncatedDefaultScriptContextBuilder<T>> implements TruncatedScriptContextBuilder<T> {

        private TruncatedDefaultScriptContextBuilder() {
        }
    }
}