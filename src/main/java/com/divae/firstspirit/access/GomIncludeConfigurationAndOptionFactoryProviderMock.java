package com.divae.firstspirit.access;

import com.divae.firstspirit.access.editor.value.OptionFactoryMock.OptionFactoryBuilder;
import com.divae.firstspirit.access.editor.value.OptionFactoryProviderMock.OptionFactoryProviderBuilder;
import com.divae.firstspirit.access.editor.value.OptionFactoryProviderMock.TruncatedOptionFactoryProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.gom.GomIncludeConfigurationMock.DefaultGomIncludeConfigurationBuilder;
import com.divae.firstspirit.access.store.templatestore.gom.GomIncludeConfigurationMock.GomIncludeConfigurationBuilder;
import de.espirit.firstspirit.access.editor.value.OptionFactoryProvider;
import de.espirit.firstspirit.access.store.templatestore.gom.GomIncludeConfiguration;

import static com.divae.firstspirit.access.editor.value.OptionFactoryProviderMock.optionFactoryProviderWith;

public final class GomIncludeConfigurationAndOptionFactoryProviderMock {

    private GomIncludeConfigurationAndOptionFactoryProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static GomIncludeConfigurationAndOptionFactoryProviderBuilder gomIncludeConfigurationAndOptionFactoryProviderWith() {
        return new DefaultGomIncludeConfigurationAndOptionFactoryProviderBuilder();
    }

    public interface GomIncludeConfigurationAndOptionFactoryProviderBuilder extends GomIncludeConfigurationBuilder<GomIncludeConfigurationAndOptionFactoryProvider, GomIncludeConfigurationAndOptionFactoryProviderBuilder>, OptionFactoryProviderBuilder<GomIncludeConfigurationAndOptionFactoryProvider, GomIncludeConfigurationAndOptionFactoryProviderBuilder> {
    }

    public interface GomIncludeConfigurationAndOptionFactoryProvider extends GomIncludeConfiguration, OptionFactoryProvider {
    }

    public static class DefaultGomIncludeConfigurationAndOptionFactoryProviderBuilder extends DefaultGomIncludeConfigurationBuilder<GomIncludeConfigurationAndOptionFactoryProvider, GomIncludeConfigurationAndOptionFactoryProviderBuilder, DefaultGomIncludeConfigurationAndOptionFactoryProviderBuilder> implements GomIncludeConfigurationAndOptionFactoryProviderBuilder {

        private final TruncatedOptionFactoryProviderBuilder<GomIncludeConfigurationAndOptionFactoryProvider> optionFactoryProvider;

        private DefaultGomIncludeConfigurationAndOptionFactoryProviderBuilder() {
            optionFactoryProvider = optionFactoryProviderWith(getInterfaceBuilder());
        }

        @Override
        public GomIncludeConfigurationAndOptionFactoryProviderBuilder anOptionFactory(final OptionFactoryBuilder optionFactory) {
            optionFactoryProvider.anOptionFactory(optionFactory);
            return getInterfaceBuilder();
        }
    }
}
