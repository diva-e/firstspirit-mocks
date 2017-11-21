package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.templatestore.ScriptContainer;

public final class ScriptContainerMock {

    private ScriptContainerMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> ScriptContainerBuilder scriptContainerWith(String name, long id, TBUILDER parent) {
        return new DefaultScriptContainerBuilder(name, id, parent);
    }

    public interface ScriptContainerBuilder extends IDProviderBuilder<ScriptContainer, ScriptContainerBuilder> {
    }

    private static final class DefaultScriptContainerBuilder extends DefaultIDProviderBuilder<ScriptContainer, ScriptContainerBuilder, DefaultScriptContainerBuilder> implements ScriptContainerBuilder {

        private <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> DefaultScriptContainerBuilder(String name, long id, TBUILDER parent) {
            super(name, id, parent);
        }

    }
}
