package com.divae.firstspirit.storage;

import com.divae.firstspirit.access.store.BasicElementInfoMock.BasicElementInfoBuilder;
import com.divae.firstspirit.storage.RevisionOperationMock.DefaultRevisionOperationBuilder;
import com.divae.firstspirit.storage.RevisionOperationMock.RevisionOperationBuilder;
import de.espirit.firstspirit.access.store.BasicElementInfo;
import de.espirit.firstspirit.storage.DeleteOperation;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class DeleteOperationMock {

    private DeleteOperationMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static DeleteOperationBuilder deleteOperationWith() {
        return new DefaultDeleteOperationBuilder();
    }

    public interface DeleteOperationBuilder extends RevisionOperationBuilder<BasicElementInfo, DeleteOperation, DeleteOperationBuilder> {
        DeleteOperationBuilder deletesRootElement(Supplier<BasicElementInfoBuilder> supplier);
    }

    public static final class DefaultDeleteOperationBuilder extends DefaultRevisionOperationBuilder<BasicElementInfo, DeleteOperation, DeleteOperationBuilder, DefaultDeleteOperationBuilder> implements DeleteOperationBuilder {

        private DefaultDeleteOperationBuilder() {
        }

        @Override
        public final DeleteOperationBuilder deletesRootElement(Supplier<BasicElementInfoBuilder> supplier) {
            BasicElementInfo basicElementInfo = build(supplier.get());
            when(getBuildable().getDeleteRootElement()).thenReturn(basicElementInfo);
            return getBuilder();
        }
    }
}
