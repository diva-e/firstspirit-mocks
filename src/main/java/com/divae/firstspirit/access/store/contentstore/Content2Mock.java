package com.divae.firstspirit.access.store.contentstore;


import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.access.store.contentstore.ContentFolderMock.ContentFolderBuilder;
import com.divae.firstspirit.access.store.contentstore.DatasetMock.DatasetBuilder;
import com.divae.firstspirit.access.store.templatestore.SchemaMock.SchemaBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateProviderMock.DefaultTemplateProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateProviderMock.TemplateProviderBuilder;
import com.divae.firstspirit.or.schema.EntityMock.EntityBuilder;
import de.espirit.firstspirit.access.store.contentstore.Content2;
import de.espirit.firstspirit.access.store.contentstore.ContentFolder;
import de.espirit.firstspirit.access.store.contentstore.Dataset;
import de.espirit.firstspirit.access.store.templatestore.TableTemplate;
import de.espirit.or.schema.EntityType;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.or.schema.EntityTypeMock.entityTypeWith;
import static de.espirit.firstspirit.access.store.contentstore.Content2.UID_TYPE;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class Content2Mock {

	private Content2Mock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends ContentFolder, TBUILDER extends ContentFolderBuilder<T, TBUILDER>> Content2Builder content2With(String uid, long id, TBUILDER parent) {
		return new DefaultContent2Builder(uid, id, parent);
	}

	public interface Content2Builder extends TemplateProviderBuilder<TableTemplate, Content2, Content2Builder> {
		Content2Builder aSchema(SchemaBuilder schema);

		Content2Builder anEntityTypeName(String entityTypeName);

		Content2Builder aName(String name);

		Content2Builder datasets(Function<Content2Builder, List<DatasetBuilder>> function);

		Content2Builder aDataset(Function<Content2Builder, DatasetBuilder> datasetFunction, Supplier<EntityBuilder> entitySupplier);
	}

	public static final class DefaultContent2Builder extends DefaultTemplateProviderBuilder<TableTemplate, Content2, Content2Builder, DefaultContent2Builder> implements Content2Builder {

		private <T extends ContentFolder, TBUILDER extends ContentFolderBuilder<T, TBUILDER>> DefaultContent2Builder(String uid, long id, TBUILDER parent) {
			super(uid, id, UID_TYPE, parent);
		}

		@Override
		public final Content2Builder aSchema(SchemaBuilder schema) {
			when(getBuildable().getSchema()).thenReturn(getBuildable(schema));
			return getBuilder();
		}

		@Override
		public final Content2Builder anEntityTypeName(String entityTypeName) {
			EntityType entityType = build(entityTypeWith().aName(entityTypeName));
			when(getBuildable().getEntityType()).thenReturn(entityType);
			return getBuilder();
		}

		@Override
		public final Content2Builder aName(String name) {
			when(getBuildable().getName()).thenReturn(name);
			return getBuilder();
		}

		@Override
		public final Content2Builder datasets(Function<Content2Builder, List<DatasetBuilder>> function) {
			dataset(function.apply(getBuilder()));
			return getBuilder();
		}

		private void dataset(List<DatasetBuilder> dataset) {
			when(getBuildable().getDatasets()).thenReturn(dataset.stream().map(BuilderMock::build).collect(toList()));
		}

		@Override
		public final Content2Builder aDataset(Function<Content2Builder, DatasetBuilder> datasetFunction, Supplier<EntityBuilder> entitySupplier) {
			EntityBuilder entity = entitySupplier.get();
			DatasetBuilder datasetBuilder = datasetFunction.apply(getBuilder()).anEntity(entity);
			Dataset dataset = build(datasetBuilder);
			when(getBuildable().getDataset(build(entity))).thenReturn(dataset);
			dataset(singletonList(datasetBuilder));
			return getBuilder();
		}

	}
}
