package com.divae.firstspirit.common.util;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.common.util.Filter.TypedFilter;

public final class TypedFilterMock {

    private TypedFilterMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T> TypedFilterBuilder<T> typedFilterWith() {
        return new DefaultTypedFilterBuilder<>();
    }

    public interface TypedFilterBuilder<T> extends Builder<TypedFilter<T>, TypedFilterBuilder<T>> {
    }

    private static final class DefaultTypedFilterBuilder<T> extends DefaultBuilder<TypedFilter<T>, TypedFilterBuilder<T>, DefaultTypedFilterBuilder<T>> implements TypedFilterBuilder<T> {

        private DefaultTypedFilterBuilder() {
        }
    }

}
