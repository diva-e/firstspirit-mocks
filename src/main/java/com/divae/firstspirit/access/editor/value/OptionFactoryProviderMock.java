package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.editor.value.OptionFactoryMock.OptionFactoryBuilder;
import de.espirit.firstspirit.access.editor.value.OptionFactoryProvider;

import static org.mockito.Mockito.when;

public final class OptionFactoryProviderMock {

    private OptionFactoryProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends OptionFactoryProvider, TBUILDER extends OptionFactoryProviderBuilder<T, TBUILDER>> TruncatedOptionFactoryProviderBuilder<T> optionFactoryProviderWith(TBUILDER optionFactoryProvider) {
        return new TruncatedDefaultOptionFactoryProviderBuilder<>(optionFactoryProvider);
    }

    public static <T extends OptionFactoryProvider> TruncatedOptionFactoryProviderBuilder<T> optionFactoryProviderWith() {
        return new TruncatedDefaultOptionFactoryProviderBuilder<>();
    }

    public interface OptionFactoryProviderBuilder<T extends OptionFactoryProvider, TBUILDER extends OptionFactoryProviderBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
        TBUILDER anOptionFactory(OptionFactoryBuilder optionFactory);
    }

    public interface TruncatedOptionFactoryProviderBuilder<T extends OptionFactoryProvider> extends OptionFactoryProviderBuilder<T, TruncatedOptionFactoryProviderBuilder<T>> {
    }

    public static class DefaultOptionFactoryProviderBuilder<T extends OptionFactoryProvider, EBUILDER extends OptionFactoryProviderBuilder<T, EBUILDER>, TBUILDER extends DefaultOptionFactoryProviderBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements OptionFactoryProviderBuilder<T, EBUILDER> {

        protected DefaultOptionFactoryProviderBuilder() {
        }

        protected <OTBUILDER extends Builder<T, OTBUILDER>> DefaultOptionFactoryProviderBuilder(OTBUILDER optionFactoryProvider) {
            super(optionFactoryProvider);
        }

        @Override
        public final EBUILDER anOptionFactory(OptionFactoryBuilder optionFactory) {
            when(getBuildable().getOptionFactory()).thenReturn(getBuildable(optionFactory));
            return getInterfaceBuilder();
        }
    }

    private static final class TruncatedDefaultOptionFactoryProviderBuilder<T extends OptionFactoryProvider> extends DefaultOptionFactoryProviderBuilder<T, TruncatedOptionFactoryProviderBuilder<T>, TruncatedDefaultOptionFactoryProviderBuilder<T>> implements TruncatedOptionFactoryProviderBuilder<T> {

        private TruncatedDefaultOptionFactoryProviderBuilder() {
        }

        private <TBUILDER extends OptionFactoryProviderBuilder<T, TBUILDER>> TruncatedDefaultOptionFactoryProviderBuilder(TBUILDER optionFactoryProvider) {
            super(optionFactoryProvider);
        }
    }
}
