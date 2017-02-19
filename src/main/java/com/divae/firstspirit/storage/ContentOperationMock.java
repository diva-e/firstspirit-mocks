package com.divae.firstspirit.storage;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.or.EntityInfoMock.EntityInfoBuilder;
import com.divae.firstspirit.storage.RevisionOperationMock.DefaultRevisionOperationBuilder;
import com.divae.firstspirit.storage.RevisionOperationMock.RevisionOperationBuilder;
import de.espirit.firstspirit.storage.ContentOperation;
import de.espirit.or.EntityInfo;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class ContentOperationMock {

	private ContentOperationMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static ContentOperationBuilder contentOperationWith() {
		return new DefaultContentOperationBuilder();
	}

	public interface ContentOperationBuilder extends RevisionOperationBuilder<EntityInfo, ContentOperation, ContentOperationBuilder> {
		ContentOperationBuilder changedEntities(Supplier<Collection<EntityInfoBuilder>> supplier);

		ContentOperationBuilder createdEntities(Supplier<Collection<EntityInfoBuilder>> supplier);

		ContentOperationBuilder deletedEntities(Supplier<Collection<EntityInfoBuilder>> supplier);

		ContentOperationBuilder releasedEntities(Supplier<Collection<EntityInfoBuilder>> supplier);
	}

	public static final class DefaultContentOperationBuilder extends DefaultRevisionOperationBuilder<EntityInfo, ContentOperation, ContentOperationBuilder, DefaultContentOperationBuilder> implements ContentOperationBuilder {

		private DefaultContentOperationBuilder() {
		}

		@Override
		public final ContentOperationBuilder changedEntities(Supplier<Collection<EntityInfoBuilder>> supplier) {
			List<EntityInfo> entityInfo = supplier.get().stream().map(BuilderMock::build).collect(toList());
			when(getBuildable().getChangedEntities()).thenReturn(entityInfo);
			return getBuilder();
		}

		@Override
		public final ContentOperationBuilder createdEntities(Supplier<Collection<EntityInfoBuilder>> supplier) {
			List<EntityInfo> entityInfo = supplier.get().stream().map(BuilderMock::build).collect(toList());
			when(getBuildable().getCreatedEntities()).thenReturn(entityInfo);
			return getBuilder();
		}

		@Override
		public final ContentOperationBuilder deletedEntities(Supplier<Collection<EntityInfoBuilder>> supplier) {
			List<EntityInfo> entityInfo = supplier.get().stream().map(BuilderMock::build).collect(toList());
			when(getBuildable().getDeletedEntities()).thenReturn(entityInfo);
			return getBuilder();
		}

		@Override
		public final ContentOperationBuilder releasedEntities(Supplier<Collection<EntityInfoBuilder>> supplier) {
			List<EntityInfo> entityInfo = supplier.get().stream().map(BuilderMock::build).collect(toList());
			when(getBuildable().getReleasedEntities()).thenReturn(entityInfo);
			return getBuilder();
		}
	}
}
