package com.divae.firstspirit.listable;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.common.util.Listable;
import de.espirit.firstspirit.access.store.StoreElement;

import java.util.List;

import static org.mockito.Mockito.when;

public final class ListableMock {

    private ListableMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends StoreElement> ListableBuilder<T> listableWith() {
        return new DefaultListableBuilder<>();
    }

    public interface ListableBuilder<T extends StoreElement> extends Builder<Listable<T>, ListableBuilder<T>> {
        ListableBuilder<T> elements(final List<T> elements);
    }

    public static final class DefaultListableBuilder<T extends StoreElement> extends DefaultBuilder<Listable<T>, ListableBuilder<T>, DefaultListableBuilder<T>> implements ListableBuilder<T> {

        private DefaultListableBuilder() {
        }

        @Override
        public final ListableBuilder<T> elements(final List<T> elements) {
            when(getBuildable().iterator()).thenAnswer(invocation -> elements.iterator());
            when(getBuildable().toList()).thenReturn(elements);
            return getBuilder();
        }
    }

}
