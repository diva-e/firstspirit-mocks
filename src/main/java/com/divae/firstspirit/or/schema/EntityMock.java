package com.divae.firstspirit.or.schema;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.or.schema.EntityTypeMock.EntityTypeBuilder;
import de.espirit.or.schema.Entity;

import java.util.UUID;

import static com.divae.firstspirit.or.schema.EntityTypeMock.entityTypeWith;
import static org.mockito.Mockito.when;

public final class EntityMock {

	private EntityMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static EntityBuilder entityWith(UUID gid) {
		return new DefaultEntityBuilder(gid);
	}

	public interface EntityBuilder extends Builder<Entity, EntityBuilder> {
		EntityBuilder aType(String entityTypeName);

		EntityBuilder aType(EntityTypeBuilder entityType);

		EntityBuilder gets(Object key, Object value);

		EntityBuilder aValue(String key, Object value);
	}

	public static final class DefaultEntityBuilder extends DefaultBuilder<Entity, EntityBuilder, DefaultEntityBuilder> implements EntityBuilder {

		private DefaultEntityBuilder(UUID gid) {
			super(gid);
			anGid(gid);
		}

		@Override
		public final EntityBuilder aType(String entityTypeName) {
			return aType(entityTypeWith().aName(entityTypeName));
		}

		@Override
		public final EntityBuilder aType(EntityTypeBuilder entityType) {
			when(getBuildable().getEntityType()).thenReturn(getBuildable(entityType));
			return getBuilder();
		}

		@Override
		@SuppressWarnings("SuspiciousMethodCalls")
		public final EntityBuilder gets(Object key, Object value) {
			when(getBuildable().get(key)).thenReturn(value);
			return getBuilder();
		}

		@Override
		public final EntityBuilder aValue(String key, Object value) {
			when(getBuildable().getValue(key)).thenReturn(value);
			return getBuilder();
		}

		private void anGid(UUID gid) {
			when(getBuildable().getGid()).thenReturn(gid);
		}

	}
}
