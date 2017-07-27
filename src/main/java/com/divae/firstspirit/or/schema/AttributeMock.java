package com.divae.firstspirit.or.schema;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.or.schema.Attribute;

import static org.mockito.Mockito.when;

public final class AttributeMock {

    private AttributeMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T> AttributeBuilder<T> attributeWith() {
        return new DefaultAttributeBuilder<>();
    }

    public interface AttributeBuilder<T> extends Builder<Attribute<T>, AttributeBuilder<T>> {
        AttributeBuilder<T> aName(String name);
    }

    public static final class DefaultAttributeBuilder<T> extends DefaultBuilder<Attribute<T>, AttributeBuilder<T>, DefaultAttributeBuilder<T>> implements AttributeBuilder<T> {

        private DefaultAttributeBuilder() {
        }

        @Override
        public AttributeBuilder<T> aName(final String name) {
            when(getBuildable().getName()).thenReturn(name);
            return getInterfaceBuilder();
        }
    }
}
