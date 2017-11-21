package com.divae.firstspirit.access.store.templatestore.gom;

import com.divae.firstspirit.access.store.templatestore.gom.GomElementMock.DefaultGomElementBuilder;
import com.divae.firstspirit.access.store.templatestore.gom.GomElementMock.GomElementBuilder;
import de.espirit.firstspirit.access.store.templatestore.gom.GomFormElement;

import static org.mockito.Mockito.when;

public final class GomFormElementMock {

    private GomFormElementMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static GomFormElementBuilder gomFormElementWith(String name) {
        return new DefaultGomFormElementBuilder(name);
    }

    public interface GomFormElementBuilder extends GomElementBuilder<GomFormElement, GomFormElementBuilder> {
    }

    private static final class DefaultGomFormElementBuilder extends DefaultGomElementBuilder<GomFormElement, GomFormElementBuilder, DefaultGomFormElementBuilder> implements GomFormElementBuilder {

        private DefaultGomFormElementBuilder(String name) {
            aName(name);
        }

        private void aName(String name) {
            when(getBuildable().name()).thenReturn(name);
        }
    }
}
