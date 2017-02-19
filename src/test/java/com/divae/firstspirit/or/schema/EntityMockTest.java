package com.divae.firstspirit.or.schema;

import com.divae.firstspirit.MockTest;
import de.espirit.or.schema.Entity;
import de.espirit.or.schema.EntityType;
import org.junit.Test;

import java.util.UUID;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.or.schema.EntityMock.entityWith;
import static com.divae.firstspirit.or.schema.EntityTypeMock.entityTypeWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EntityMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return EntityMock.class;
	}

	@Test
	public void testATypeString() {
		String entityTypeName = "test";
		Entity entity = build(entityWith(new UUID(0, 0)).aType(entityTypeName));
		assertThat(entity.getEntityType().getName(), is(entityTypeName));
	}

	@Test
	public void testATypeEntityType() {
		EntityTypeMock.EntityTypeBuilder entityTypeBuilder = entityTypeWith();
		Entity entity = build(entityWith(new UUID(0, 0)).aType(entityTypeBuilder));
		EntityType entityType = build(entityTypeBuilder);
		assertThat(entity.getEntityType(), is(entityType));
	}

	@Test
	public void testGets() {
		String key = "key";
		String value = "value";
		Entity entity = build(entityWith(new UUID(0, 0)).gets(key, value));
		assertThat(entity.get(key), is(value));
	}

	@Test
	public void testAValue() {
		String key = "key";
		String value = "value";
		Entity entity = build(entityWith(new UUID(0, 0)).aValue(key, value));
		assertThat(entity.getValue(key), is(value));
	}
}
