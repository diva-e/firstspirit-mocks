package com.divae.firstspirit.storage;

import com.divae.firstspirit.access.store.BasicElementInfoMock.BasicElementInfoBuilder;
import com.divae.firstspirit.storage.RevisionOperationMock.DefaultRevisionOperationBuilder;
import com.divae.firstspirit.storage.RevisionOperationMock.RevisionOperationBuilder;
import de.espirit.firstspirit.access.store.BasicElementInfo;
import de.espirit.firstspirit.storage.CreateOperation;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class CreateOperationMock {

    private CreateOperationMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static CreateOperationBuilder createOperationWith() {
        return new DefaultCreateOperationBuilder();
    }

    public interface CreateOperationBuilder extends RevisionOperationBuilder<BasicElementInfo, CreateOperation, CreateOperationBuilder> {
        CreateOperationBuilder createdElement(Supplier<BasicElementInfoBuilder> supplier);
    }

    public static final class DefaultCreateOperationBuilder extends DefaultRevisionOperationBuilder<BasicElementInfo, CreateOperation, CreateOperationBuilder, DefaultCreateOperationBuilder> implements CreateOperationBuilder {

        private DefaultCreateOperationBuilder() {
        }

        @Override
        public final CreateOperationBuilder createdElement(Supplier<BasicElementInfoBuilder> supplier) {
            BasicElementInfo basicElementInfo = build(supplier.get());
            when(getBuildable().getCreatedElement()).thenReturn(basicElementInfo);
            return getBuilder();
        }
    }
}
