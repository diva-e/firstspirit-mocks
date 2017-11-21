package com.divae.firstspirit.storage;

import com.divae.firstspirit.access.store.BasicElementInfoMock.BasicElementInfoBuilder;
import com.divae.firstspirit.storage.RevisionOperationMock.DefaultRevisionOperationBuilder;
import com.divae.firstspirit.storage.RevisionOperationMock.RevisionOperationBuilder;
import de.espirit.firstspirit.access.store.BasicElementInfo;
import de.espirit.firstspirit.storage.ModifyOperation;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class ModifyOperationMock {

    private ModifyOperationMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static ModifyOperationBuilder modifyOperationWith() {
        return new DefaultModifyOperationBuilder();
    }

    public interface ModifyOperationBuilder extends RevisionOperationBuilder<BasicElementInfo, ModifyOperation, ModifyOperationBuilder> {
        ModifyOperationBuilder aModificationRootElement(Supplier<BasicElementInfoBuilder> supplier);

    }

    public static final class DefaultModifyOperationBuilder extends DefaultRevisionOperationBuilder<BasicElementInfo, ModifyOperation, ModifyOperationBuilder, DefaultModifyOperationBuilder> implements ModifyOperationBuilder {

        private DefaultModifyOperationBuilder() {
        }

        @Override
        public final ModifyOperationBuilder aModificationRootElement(Supplier<BasicElementInfoBuilder> supplier) {
            BasicElementInfo basicElementInfo = build(supplier.get());
            when(getBuildable().getModificationRootElement()).thenReturn(basicElementInfo);
            return getBuilder();
        }

    }
}
