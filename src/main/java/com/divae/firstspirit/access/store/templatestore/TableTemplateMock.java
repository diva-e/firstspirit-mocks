package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.access.store.contentstore.DatasetMock.DatasetBuilder;
import com.divae.firstspirit.access.store.contentstore.DatasetProviderMock.DatasetProviderBuilder;
import com.divae.firstspirit.access.store.contentstore.DatasetProviderMock.TruncatedDatasetProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.MappingMock.MappingBuilder;
import com.divae.firstspirit.access.store.templatestore.SchemaMock.SchemaBuilder;
import com.divae.firstspirit.access.store.templatestore.SectionTemplateMock.DefaultSectionTemplateBuilder;
import com.divae.firstspirit.access.store.templatestore.SectionTemplateMock.SectionTemplateBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.TemplateStoreRootBuilder;
import com.divae.firstspirit.or.schema.EntityMock.EntityBuilder;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.contentstore.Dataset;
import de.espirit.firstspirit.access.store.templatestore.TableTemplate;
import de.espirit.firstspirit.access.store.templatestore.TableTemplate.Mapping;
import de.espirit.or.schema.Entity;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.contentstore.DatasetProviderMock.datasetProviderWith;
import static java.util.stream.Stream.of;
import static org.mockito.Mockito.when;

public final class TableTemplateMock {

    private TableTemplateMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static TableTemplateBuilder tableTemplateWith(String uid, long id, UidType uidType, TemplateStoreRootBuilder parent) {
        return new DefaultTableTemplateBuilder(uid, id, uidType, parent);
    }

    public interface TableTemplateBuilder extends SectionTemplateBuilder<TableTemplate, TableTemplateBuilder>, DatasetProviderBuilder<TableTemplate, TableTemplateBuilder> {
        TableTemplateBuilder mappings(Supplier<MappingBuilder[]> supplier);

        TableTemplateBuilder mappings(Supplier<MappingBuilder[]> supplier, boolean release);
    }

    public static final class DefaultTableTemplateBuilder extends DefaultSectionTemplateBuilder<TableTemplate, TableTemplateBuilder, DefaultTableTemplateBuilder> implements TableTemplateBuilder {

        private final TruncatedDatasetProviderBuilder<TableTemplate> datasetProviderBuilder;

        private DefaultTableTemplateBuilder(String uid, long id, UidType uidType, TemplateStoreRootBuilder parent) {
            super(uid, id, uidType, parent);
            datasetProviderBuilder = datasetProviderWith(getInterfaceBuilder());
        }

        @Override
        public TableTemplateBuilder aSchema(final SchemaBuilder schema) {
            datasetProviderBuilder.aSchema(schema);
            return getInterfaceBuilder();
        }

        @Override
        public TableTemplateBuilder aDataset(final Function<TableTemplateBuilder, DatasetBuilder> datasetFunction, final Supplier<EntityBuilder> entitySupplier) {
            EntityBuilder entityBuilder = entitySupplier.get();
            DatasetBuilder datasetBuilder = datasetFunction.apply(getBuilder()).anEntity(entityBuilder);
            Dataset dataset = build(datasetBuilder);
            Entity entity = build(entityBuilder);
            when(getBuildable().getDataset(entity)).thenReturn(dataset);
            datasetProviderBuilder.aDataset(dataset, entity);
            return getInterfaceBuilder();
        }

        @Override
        public TableTemplateBuilder mappings(final Supplier<MappingBuilder[]> supplier) {
            return mappings(supplier, false);
        }

        @Override
        public TableTemplateBuilder mappings(final Supplier<MappingBuilder[]> supplier, boolean release) {
            Mapping[] mappings = of(supplier.get()).map(BuilderMock::build).toArray(Mapping[]::new);
            if (!release) {
                when(getBuildable().getMappings()).thenReturn(mappings);
            }
            when(getBuildable().getMappings(release)).thenReturn(mappings);
            return getInterfaceBuilder();
        }
    }
}
