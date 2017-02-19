package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreElementMock.DefaultTemplateStoreElementBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreElementMock.TemplateStoreElementBuilder;
import com.divae.firstspirit.or.SessionMock.SessionBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.templatestore.Schema;
import de.espirit.or.Session;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static de.espirit.firstspirit.access.store.templatestore.Schema.UID_TYPE;
import static org.mockito.Mockito.when;

public final class SchemaMock {

	private SchemaMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> SchemaBuilder schemaWith(String uid, long id, TBUILDER parent) {
		return new DefaultSchemaBuilder(uid, id, parent);
	}

	public interface SchemaBuilder extends TemplateStoreElementBuilder<Schema, SchemaBuilder> {
		SchemaBuilder aSession(Supplier<SessionBuilder> supplier);
	}

	public static final class DefaultSchemaBuilder extends DefaultTemplateStoreElementBuilder<Schema, SchemaBuilder, DefaultSchemaBuilder> implements SchemaBuilder {

		private <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> DefaultSchemaBuilder(String uid, long id, TBUILDER parent) {
			super(uid, id, UID_TYPE, parent);
		}

		@Override
		public final SchemaBuilder aSession(Supplier<SessionBuilder> supplier) {
			Session session = build(supplier.get());
			when(getBuildable().getSession()).thenReturn(session);
			return getBuilder();
		}
	}
}
