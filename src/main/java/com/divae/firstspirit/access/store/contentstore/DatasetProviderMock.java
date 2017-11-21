package com.divae.firstspirit.access.store.contentstore;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.store.contentstore.DatasetMock.DatasetBuilder;
import com.divae.firstspirit.access.store.templatestore.SchemaMock.SchemaBuilder;
import com.divae.firstspirit.or.schema.EntityMock.EntityBuilder;
import de.espirit.firstspirit.access.store.contentstore.Dataset;
import de.espirit.firstspirit.access.store.contentstore.DatasetProvider;
import de.espirit.or.schema.Entity;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class DatasetProviderMock {

    private DatasetProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends DatasetProvider, TBUILDER extends DatasetProviderBuilder<T, TBUILDER>> TruncatedDatasetProviderBuilder<T> datasetProviderWith() {
        return new TruncatedDefaultDatasetProviderBuilder<>();
    }

    public static <T extends DatasetProvider, OTBUILDER extends DatasetProviderBuilder<T, OTBUILDER>> TruncatedDatasetProviderBuilder<T> datasetProviderWith(OTBUILDER idProvider) {
        return new TruncatedDefaultDatasetProviderBuilder<>(idProvider);
    }

    public interface DatasetProviderBuilder<T extends DatasetProvider, TBUILDER extends DatasetProviderBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
        TBUILDER aSchema(SchemaBuilder schema);

        TBUILDER aDataset(Function<TBUILDER, DatasetBuilder> datasetFunction, Supplier<EntityBuilder> entitySupplier);
    }

    public static class DefaultDatasetProviderBuilder<T extends DatasetProvider, EBUILDER extends DatasetProviderBuilder<T, EBUILDER>, TBUILDER extends DefaultDatasetProviderBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements DatasetProviderBuilder<T, EBUILDER> {

        private DefaultDatasetProviderBuilder() {
        }

        protected <OTBUILDER extends DatasetProviderBuilder<T, OTBUILDER>> DefaultDatasetProviderBuilder(OTBUILDER datasetProvider) {
            super(datasetProvider);
        }

        @Override
        public final EBUILDER aSchema(SchemaBuilder schema) {
            when(getBuildable().getSchema()).thenReturn(getBuildable(schema));
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER aDataset(Function<EBUILDER, DatasetBuilder> datasetFunction, Supplier<EntityBuilder> entitySupplier) {
            EntityBuilder entity = entitySupplier.get();
            DatasetBuilder datasetBuilder = datasetFunction.apply(getInterfaceBuilder()).anEntity(entity);
            Dataset dataset = build(datasetBuilder);
            return aDataset(dataset, build(entity));
        }

        public EBUILDER aDataset(final Dataset dataset, final Entity entity) {
            when(getBuildable().getDataset(entity)).thenReturn(dataset);
            return getInterfaceBuilder();
        }
    }

    public interface TruncatedDatasetProviderBuilder<T extends DatasetProvider> extends DatasetProviderBuilder<T, TruncatedDatasetProviderBuilder<T>> {
        DatasetProviderBuilder<T, TruncatedDatasetProviderBuilder<T>> aDataset(Dataset dataset, Entity entity);
    }

    private static final class TruncatedDefaultDatasetProviderBuilder<T extends DatasetProvider> extends DefaultDatasetProviderBuilder<T, TruncatedDatasetProviderBuilder<T>, TruncatedDefaultDatasetProviderBuilder<T>> implements TruncatedDatasetProviderBuilder<T> {

        private TruncatedDefaultDatasetProviderBuilder() {
        }

        private <OTBUILDER extends DatasetProviderBuilder<T, OTBUILDER>> TruncatedDefaultDatasetProviderBuilder(OTBUILDER datasetProvider) {
            super(datasetProvider);
        }
    }
}
