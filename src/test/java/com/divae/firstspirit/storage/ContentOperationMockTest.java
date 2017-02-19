package com.divae.firstspirit.storage;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.or.EntityInfoMock.EntityInfoBuilder;
import de.espirit.firstspirit.storage.ContentOperation;
import de.espirit.or.EntityInfo;
import org.junit.Test;

import java.util.Collection;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.or.EntityInfoMock.entityInfoWith;
import static com.divae.firstspirit.storage.ContentOperationMock.contentOperationWith;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ContentOperationMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return ContentOperationMock.class;
	}

	@Test
	public void testChangedEntities() {
		EntityInfoBuilder entityInfoBuilder = entityInfoWith();
		ContentOperation contentOperation = build(contentOperationWith().changedEntities(() -> singletonList(entityInfoBuilder)));
		EntityInfo entityInfo = build(entityInfoBuilder);
		Collection<EntityInfo> changedEntities = contentOperation.getChangedEntities();
		assertThat(changedEntities.size(), is(1));
		assertThat(changedEntities.iterator().next(), is(entityInfo));
	}

	@Test
	public void testCreatedEntities() {
		EntityInfoBuilder entityInfoBuilder = entityInfoWith();
		ContentOperation contentOperation = build(contentOperationWith().createdEntities(() -> singletonList(entityInfoBuilder)));
		EntityInfo entityInfo = build(entityInfoBuilder);
		Collection<EntityInfo> createdEntities = contentOperation.getCreatedEntities();
		assertThat(createdEntities.size(), is(1));
		assertThat(createdEntities.iterator().next(), is(entityInfo));
	}

	@Test
	public void testDeletedEntities() {
		EntityInfoBuilder entityInfoBuilder = entityInfoWith();
		ContentOperation contentOperation = build(contentOperationWith().deletedEntities(() -> singletonList(entityInfoBuilder)));
		EntityInfo entityInfo = build(entityInfoBuilder);
		Collection<EntityInfo> deletedEntities = contentOperation.getDeletedEntities();
		assertThat(deletedEntities.size(), is(1));
		assertThat(deletedEntities.iterator().next(), is(entityInfo));
	}

	@Test
	public void testReleasedEntities() {
		EntityInfoBuilder entityInfoBuilder = entityInfoWith();
		ContentOperation contentOperation = build(contentOperationWith().releasedEntities(() -> singletonList(entityInfoBuilder)));
		EntityInfo entityInfo = build(entityInfoBuilder);
		Collection<EntityInfo> releasedEntities = contentOperation.getReleasedEntities();
		assertThat(releasedEntities.size(), is(1));
		assertThat(releasedEntities.iterator().next(), is(entityInfo));
	}
}
