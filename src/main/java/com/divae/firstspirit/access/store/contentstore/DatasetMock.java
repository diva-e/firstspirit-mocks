package com.divae.firstspirit.access.store.contentstore;

import com.divae.firstspirit.access.store.contentstore.Content2Mock.Content2Builder;
import com.divae.firstspirit.access.store.pagestore.DataProviderMock.DataProviderBuilder;
import com.divae.firstspirit.access.store.pagestore.DataProviderMock.DefaultDataProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.TableTemplateMock.TableTemplateBuilder;
import com.divae.firstspirit.or.schema.EntityMock.EntityBuilder;
import de.espirit.firstspirit.access.store.contentstore.Dataset;

import static org.mockito.Mockito.when;

public final class DatasetMock {

    private DatasetMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static DatasetBuilder datasetWith(String name, long id, Content2Builder parent) {
        return new DefaultDatasetBuilder(name, id, parent);
    }

    public interface DatasetBuilder extends DataProviderBuilder<Dataset, DatasetBuilder> {
        DatasetBuilder anEntity(EntityBuilder entity);

        DatasetBuilder aTableTemplate(TableTemplateBuilder tableTemplate);
    }

    public static final class DefaultDatasetBuilder extends DefaultDataProviderBuilder<Dataset, DatasetBuilder, DefaultDatasetBuilder> implements DatasetBuilder {

        private DefaultDatasetBuilder(String name, long id, Content2Builder parent) {
            super(name, id, parent);
        }

        @Override
        public final DatasetBuilder anEntity(EntityBuilder entity) {
            when(getBuildable().getEntity()).thenReturn(getBuildable(entity));
            return getBuilder();
        }

        @Override
        public final DatasetBuilder aTableTemplate(TableTemplateBuilder tableTemplate) {
            when(getBuildable().getTableTemplate()).thenReturn(getBuildable(tableTemplate));
            return getBuilder();
        }

    }

}
