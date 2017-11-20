package com.divae.firstspirit.access.store.templatestore.gom;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.store.templatestore.gom.GomIncludeConfigurationMock.GomIncludeConfigurationBuilder;
import de.espirit.firstspirit.access.store.templatestore.gom.GomElement;
import de.espirit.firstspirit.access.store.templatestore.gom.GomIncludeConfiguration;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class GomElementMock {

    private GomElementMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends GomElement> TruncatedGomElementBuilder<T> gomElementWith() {
        return new TruncatedDefaultGomElementBuilder<>();
    }

    public interface GomElementBuilder<T extends GomElement, TBUILDER extends GomElementBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
        <OT extends GomIncludeConfiguration, OTBUILDER extends GomIncludeConfigurationBuilder<OT, OTBUILDER>> TBUILDER anIncludeConfiguration(Supplier<OTBUILDER> supplier);
    }

    public interface TruncatedGomElementBuilder<T extends GomElement> extends GomElementBuilder<T, TruncatedGomElementBuilder<T>> {
    }

    public static class DefaultGomElementBuilder<T extends GomElement, EBUILDER extends GomElementBuilder<T, EBUILDER>, TBUILDER extends DefaultGomElementBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements GomElementBuilder<T, EBUILDER> {

        protected DefaultGomElementBuilder() {
            super();
        }

        @Override
        public final <OT extends GomIncludeConfiguration, OTBUILDER extends GomIncludeConfigurationBuilder<OT, OTBUILDER>> EBUILDER anIncludeConfiguration(Supplier<OTBUILDER> supplier) {
            OT gomIncludeConfiguration = build(supplier.get());
            when(getBuildable().getIncludeConfiguration()).thenReturn(gomIncludeConfiguration);
            return getInterfaceBuilder();
        }
    }

    private static final class TruncatedDefaultGomElementBuilder<T extends GomElement> extends DefaultGomElementBuilder<T, TruncatedGomElementBuilder<T>, TruncatedDefaultGomElementBuilder<T>> implements TruncatedGomElementBuilder<T> {

        TruncatedDefaultGomElementBuilder() {
            super();
        }
    }
}
