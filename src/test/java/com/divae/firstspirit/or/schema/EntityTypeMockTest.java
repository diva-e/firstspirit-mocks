package com.divae.firstspirit.or.schema;

import com.divae.firstspirit.MockTest;
import de.espirit.or.schema.EntityType;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.or.schema.EntityTypeMock.entityTypeWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EntityTypeMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return EntityTypeMock.class;
	}

	@Test
	public void testAName() {
		String name = "test";
		EntityType entityType = build(entityTypeWith().aName(name));
		assertThat(entityType.getName(), is(name));
	}
}
