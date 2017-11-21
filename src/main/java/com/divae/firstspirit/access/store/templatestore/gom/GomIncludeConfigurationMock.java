package com.divae.firstspirit.access.store.templatestore.gom;

import com.divae.firstspirit.access.store.templatestore.gom.GomElementMock.DefaultGomElementBuilder;
import com.divae.firstspirit.access.store.templatestore.gom.GomElementMock.GomElementBuilder;
import de.espirit.firstspirit.access.store.templatestore.gom.GomIncludeConfiguration;

public final class GomIncludeConfigurationMock {

    private GomIncludeConfigurationMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends GomIncludeConfiguration> TruncatedGomIncludeConfigurationBuilder<T> gomIncludeConfigurationWith() {
        return new TruncatedDefaultGomIncludeConfigurationBuilder<>();
    }

    public interface GomIncludeConfigurationBuilder<T extends GomIncludeConfiguration, TBUILDER extends GomIncludeConfigurationBuilder<T, TBUILDER>> extends GomElementBuilder<T, TBUILDER> {
    }

    public interface TruncatedGomIncludeConfigurationBuilder<T extends GomIncludeConfiguration> extends GomIncludeConfigurationBuilder<T, TruncatedGomIncludeConfigurationBuilder<T>> {
    }

    public static class DefaultGomIncludeConfigurationBuilder<T extends GomIncludeConfiguration, EBUILDER extends GomIncludeConfigurationBuilder<T, EBUILDER>, TBUILDER extends DefaultGomIncludeConfigurationBuilder<T, EBUILDER, TBUILDER>> extends DefaultGomElementBuilder<T, EBUILDER, TBUILDER> implements GomIncludeConfigurationBuilder<T, EBUILDER> {
        protected DefaultGomIncludeConfigurationBuilder() {
        }
    }

    private static final class TruncatedDefaultGomIncludeConfigurationBuilder<T extends GomIncludeConfiguration> extends DefaultGomIncludeConfigurationBuilder<T, TruncatedGomIncludeConfigurationBuilder<T>, TruncatedDefaultGomIncludeConfigurationBuilder<T>> implements TruncatedGomIncludeConfigurationBuilder<T> {
        private TruncatedDefaultGomIncludeConfigurationBuilder() {
            super();
        }
    }
}
