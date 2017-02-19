package com.divae.firstspirit.or.schema;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.or.schema.EntityType;

import static org.mockito.Mockito.when;

public final class EntityTypeMock {

	private EntityTypeMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static EntityTypeBuilder entityTypeWith() {
		return new DefaultEntityTypeBuilder();
	}

	public interface EntityTypeBuilder extends Builder<EntityType, EntityTypeBuilder> {
		EntityTypeBuilder aName(String name);
	}

	public static final class DefaultEntityTypeBuilder extends DefaultBuilder<EntityType, EntityTypeBuilder, DefaultEntityTypeBuilder> implements EntityTypeBuilder {

		private DefaultEntityTypeBuilder() {
		}

		@Override
		public final EntityTypeBuilder aName(String name) {
			when(getBuildable().getName()).thenReturn(name);
			return getBuilder();
		}
	}

}
