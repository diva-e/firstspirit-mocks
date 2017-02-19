package com.divae.firstspirit.or;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.or.query.ConstraintMock;
import com.divae.firstspirit.or.query.SelectMock;
import de.espirit.or.EntityList;
import de.espirit.or.Session;
import de.espirit.or.query.Select;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.or.EntityListMock.entityListWith;
import static com.divae.firstspirit.or.SessionMock.sessionWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SessionMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return SessionMock.class;
	}

	@Test
	public void testASelectStringSelectEntityList() {
		String entityTypeName = "test";
		EntityList entityList = build(entityListWith());
		Session session = build(sessionWith().aSelect(SelectMock::selectWith, entityTypeName, entityList));
		Select select = session.createSelect(entityTypeName);
		assertThat(select, is(notNullValue()));
		assertThat(session.executeQuery(select), is(entityList));
		assertThat(session.executeQuery(select.clone()), is(entityList));
	}

	@Test
	public void testASelectStringConstraint() {
		String entityTypeName = "test";
		Session session = build(sessionWith().aSelect(ConstraintMock::constraintWith, entityTypeName));
		assertThat(session.createSelect(entityTypeName).getConstraint(), is(notNullValue()));
	}
}
