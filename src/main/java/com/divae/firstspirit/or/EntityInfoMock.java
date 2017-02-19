package com.divae.firstspirit.or;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.or.EntityInfo;

public final class EntityInfoMock {

	private EntityInfoMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static EntityInfoBuilder entityInfoWith() {
		return new DefaultEntityInfoBuilder();
	}

	public interface EntityInfoBuilder extends Builder<EntityInfo, EntityInfoBuilder> {
	}

	public static final class DefaultEntityInfoBuilder extends DefaultBuilder<EntityInfo, EntityInfoBuilder, DefaultEntityInfoBuilder> implements EntityInfoBuilder {

		private DefaultEntityInfoBuilder() {
		}
	}
}
