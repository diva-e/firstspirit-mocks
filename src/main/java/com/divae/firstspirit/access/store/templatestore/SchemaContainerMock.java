package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.templatestore.SchemaContainer;

public final class SchemaContainerMock {

	private SchemaContainerMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> SchemaContainerBuilder schemaContainerWith(String name, long id, TBUILDER parent) {
		return new DefaultSchemaContainerBuilder(name, id, parent);
	}

	public interface SchemaContainerBuilder extends IDProviderBuilder<SchemaContainer, SchemaContainerBuilder> {
	}

	public static final class DefaultSchemaContainerBuilder extends DefaultIDProviderBuilder<SchemaContainer, SchemaContainerBuilder, DefaultSchemaContainerBuilder> implements SchemaContainerBuilder {

		private <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> DefaultSchemaContainerBuilder(String name, long id, TBUILDER parent) {
			super(name, id, parent);
		}
	}
}
