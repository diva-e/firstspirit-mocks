package com.divae.firstspirit.access;

import com.divae.firstspirit.access.editor.value.OptionFactoryMock.OptionFactoryBuilder;
import com.divae.firstspirit.access.editor.value.OptionFactoryProviderMock.OptionFactoryProviderBuilder;
import com.divae.firstspirit.access.editor.value.OptionFactoryProviderMock.TruncatedOptionFactoryProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.gom.GomElementMock.DefaultGomElementBuilder;
import com.divae.firstspirit.access.store.templatestore.gom.GomElementMock.GomElementBuilder;
import de.espirit.firstspirit.access.editor.value.OptionFactoryProvider;
import de.espirit.firstspirit.access.store.templatestore.gom.GomIncludeConfiguration;

import static com.divae.firstspirit.access.editor.value.OptionFactoryProviderMock.optionFactoryProviderWith;

public final class GomIncludeConfigurationAndOptionFactoryProviderMock {

    private GomIncludeConfigurationAndOptionFactoryProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static GomIncludeConfigurationAndOptionFactoryProviderBuilder gomIncludeConfigurationWith() {
        return new DefaultGomIncludeConfigurationAndOptionFactoryProviderBuilder();
    }

    public interface GomIncludeConfigurationAndOptionFactoryProviderBuilder<T extends GomIncludeConfiguration & OptionFactoryProvider, TBUILDER extends GomIncludeConfigurationAndOptionFactoryProviderBuilder<T, TBUILDER>> extends GomElementBuilder<T, TBUILDER>, OptionFactoryProviderBuilder<T, TBUILDER> {
    }

    public static class DefaultGomIncludeConfigurationAndOptionFactoryProviderBuilder<T extends GomIncludeConfiguration & OptionFactoryProvider, EBUILDER extends GomIncludeConfigurationAndOptionFactoryProviderBuilder<T, EBUILDER>, TBUILDER extends DefaultGomIncludeConfigurationAndOptionFactoryProviderBuilder<T, EBUILDER, TBUILDER>> extends DefaultGomElementBuilder<T, EBUILDER, TBUILDER> implements GomIncludeConfigurationAndOptionFactoryProviderBuilder<T, EBUILDER> {

        private final TruncatedOptionFactoryProviderBuilder<T> optionFactoryProvider;

        protected DefaultGomIncludeConfigurationAndOptionFactoryProviderBuilder() {
            super();
            optionFactoryProvider = optionFactoryProviderWith(getInterfaceBuilder());
        }

        @Override
        public EBUILDER anOptionFactory(final OptionFactoryBuilder optionFactory) {
            optionFactoryProvider.anOptionFactory(optionFactory);
            return getInterfaceBuilder();
        }
    }
}
