package com.divae.firstspirit.storage;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.store.BasicElementInfoMock.BasicElementInfoBuilder;
import com.divae.firstspirit.storage.RevisionChangeDetailMock.RevisionChangeDetailBuilder;
import com.divae.firstspirit.storage.RevisionOperationMock.RevisionOperationBuilder;
import de.espirit.firstspirit.access.store.BasicElementInfo;
import de.espirit.firstspirit.storage.ChangeType;
import de.espirit.firstspirit.storage.RevisionChangeDetail;
import de.espirit.firstspirit.storage.RevisionMetaData;
import de.espirit.firstspirit.storage.RevisionOperation;
import org.mockito.Mockito;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static java.util.stream.Collectors.toMap;
import static org.mockito.Mockito.when;

public final class RevisionMetaDataMock {

    private RevisionMetaDataMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static RevisionMetaDataBuilder revisionMetaDataWith() {
        return new DefaultRevisionMetaDataBuilder();
    }

    public interface RevisionMetaDataBuilder extends Builder<RevisionMetaData, RevisionMetaDataBuilder> {
        <E, T extends RevisionOperation<E>, TBUILDER extends RevisionOperationBuilder<E, T, TBUILDER>> RevisionMetaDataBuilder anOperation(Supplier<TBUILDER> supplier);

        <TBUILDER extends RevisionChangeDetailBuilder<RevisionChangeDetail, TBUILDER>> RevisionMetaDataBuilder changedStoreElements(Map<BasicElementInfoBuilder, Map<ChangeType, TBUILDER>> changedStoreElements);
    }

    public static final class DefaultRevisionMetaDataBuilder extends DefaultBuilder<RevisionMetaData, RevisionMetaDataBuilder, DefaultRevisionMetaDataBuilder> implements RevisionMetaDataBuilder {

        private DefaultRevisionMetaDataBuilder() {
        }

        @Override
        public final <E, T extends RevisionOperation<E>, TBUILDER extends RevisionOperationBuilder<E, T, TBUILDER>> RevisionMetaDataBuilder anOperation(Supplier<TBUILDER> supplier) {
            T revisionOperation = build(supplier.get());
            Mockito.<Object>when(getBuildable().getOperation()).thenReturn(revisionOperation);
            return getBuilder();
        }

        @Override
        public final <TBUILDER extends RevisionChangeDetailBuilder<RevisionChangeDetail, TBUILDER>> RevisionMetaDataBuilder changedStoreElements(Map<BasicElementInfoBuilder, Map<ChangeType, TBUILDER>> changedStoreElements) {
            Map<BasicElementInfo, Map<ChangeType, RevisionChangeDetail>> changedStoreElementsMap = changedStoreElements.entrySet().stream().collect(toMap(changedStoreElementEntry ->
                    getBuildable(changedStoreElementEntry.getKey()), changedStoreElementEntry ->
                    changedStoreElementEntry.getValue().entrySet().stream().collect(toMap(Entry::getKey, changeTypeRevisionChangeDetailBuilderEntry ->
                            getBuildable(changeTypeRevisionChangeDetailBuilderEntry.getValue()))))
            );
            when(getBuildable().getChangedStoreElements()).thenReturn(changedStoreElementsMap);
            return getBuilder();
        }
    }
}
