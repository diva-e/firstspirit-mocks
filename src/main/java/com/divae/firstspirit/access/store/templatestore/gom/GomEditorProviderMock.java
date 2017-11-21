package com.divae.firstspirit.access.store.templatestore.gom;


import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.store.templatestore.gom.GomFormElementMock.GomFormElementBuilder;
import de.espirit.firstspirit.access.store.templatestore.gom.GomEditorProvider;
import de.espirit.firstspirit.access.store.templatestore.gom.GomElement;
import de.espirit.firstspirit.access.store.templatestore.gom.GomFormElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public final class GomEditorProviderMock {

    private GomEditorProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static GomEditorProviderBuilder gomEditorProviderWith(String uid) {
        return new DefaultGomEditorProviderBuilder(uid);
    }

    public interface GomEditorProviderBuilder extends Builder<GomEditorProvider, GomEditorProviderBuilder> {
        GomEditorProviderBuilder values(Supplier<List<GomFormElementBuilder>> supplier);
    }

    public static class DefaultGomEditorProviderBuilder extends DefaultBuilder<GomEditorProvider, GomEditorProviderBuilder, DefaultGomEditorProviderBuilder> implements GomEditorProviderBuilder {

        private final List<GomFormElement> gomFormElements = new ArrayList<>();

        private DefaultGomEditorProviderBuilder(String uid) {
            super(uid);
            anUid(uid);
            mockList();

            when(getBuildable().get(anyInt())).thenAnswer(invocation -> {
                int index = invocation.getArgument(0);
                if (getBuildable().isEmpty() || getBuildable().size() < index) {
                    throw new IndexOutOfBoundsException();
                }
                return gomFormElements.get(index);
            });
        }

        private void mockList() {
            when(getBuildable().iterator()).thenReturn(new ArrayList<GomElement>(gomFormElements).iterator());
            when(getBuildable().isEmpty()).thenReturn(gomFormElements.isEmpty());
            when(getBuildable().size()).thenReturn(gomFormElements.size());
            when(getBuildable().forms()).thenReturn(gomFormElements);
        }

        @Override
        public final GomEditorProviderBuilder values(Supplier<List<GomFormElementBuilder>> supplier) {
            List<GomFormElement> gomFormElements = supplier.get().stream().map(BuilderMock::build).collect(toList());
            this.gomFormElements.addAll(gomFormElements);

            mockList();

            for (int i = 0; i < this.gomFormElements.size(); i++) {
                findEditor((GomFormElement) getBuildable().get(i));
            }

            return getBuilder();
        }

        private void anUid(String uid) {
            when(getBuildable().getUid()).thenReturn(uid);
        }

        private void findEditor(GomFormElement gomFormElement) {
            when(getBuildable().findEditor(gomFormElement.name())).thenReturn(gomFormElement);
        }
    }

}
