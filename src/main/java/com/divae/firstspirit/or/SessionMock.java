package com.divae.firstspirit.or;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.or.query.ConstraintMock.ConstraintBuilder;
import com.divae.firstspirit.or.query.SelectMock.SelectBuilder;
import de.espirit.or.EntityList;
import de.espirit.or.Session;
import de.espirit.or.query.Select;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.or.EntityListMock.entityListWith;
import static com.divae.firstspirit.or.query.SelectMock.selectWith;
import static org.mockito.Mockito.when;

public final class SessionMock {

	private SessionMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static SessionBuilder sessionWith() {
		return new DefaultSessionBuilder();
	}

	public interface SessionBuilder extends Builder<Session, SessionBuilder> {
		SessionBuilder aSelect(Supplier<SelectBuilder> supplier, String entityTypeName, EntityList queryResult);

		SessionBuilder aSelect(Supplier<ConstraintBuilder> supplier, String entityTypeName);
	}

	public static final class DefaultSessionBuilder extends DefaultBuilder<Session, SessionBuilder, DefaultSessionBuilder> implements SessionBuilder {

		private DefaultSessionBuilder() {
		}

		@Override
		public final SessionBuilder aSelect(Supplier<SelectBuilder> supplier, String entityTypeName, EntityList queryResult) {
			Select select = build(supplier.get());
			when(getBuildable().createSelect(entityTypeName)).thenReturn(select);
			when(getBuildable().executeQuery(select)).thenReturn(queryResult);
			return getBuilder();
		}

		@Override
		public final SessionBuilder aSelect(Supplier<ConstraintBuilder> supplier, String entityTypeName) {
			EntityList queryResult = build(entityListWith());
			return aSelect(() -> selectWith().aConstraint(supplier), entityTypeName, queryResult);
		}
	}
}
