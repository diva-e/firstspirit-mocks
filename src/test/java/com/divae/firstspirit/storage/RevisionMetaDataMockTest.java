package com.divae.firstspirit.storage;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.storage.RevisionOperationMock.TruncatedRevisionOperationBuilder;
import de.espirit.firstspirit.storage.RevisionMetaData;
import de.espirit.firstspirit.storage.RevisionOperation;
import org.hamcrest.Matchers;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.storage.RevisionMetaDataMock.revisionMetaDataWith;
import static com.divae.firstspirit.storage.RevisionOperationMock.revisionOperationWith;
import static java.util.Collections.emptyMap;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class RevisionMetaDataMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return RevisionMetaDataMock.class;
	}

	@Test
	public void testAnOperation() {
		TruncatedRevisionOperationBuilder<Object, RevisionOperation<Object>> revisionOperationBuilder = revisionOperationWith();
		RevisionMetaData revisionMetaData = build(revisionMetaDataWith().anOperation(() -> revisionOperationBuilder));
		RevisionOperation revisionOperation = build(revisionOperationBuilder);
		assertThat(revisionMetaData.getOperation(), Matchers.<Object>is(revisionOperation));
	}

	@Test
	public void testChangedStoreElements() {
		RevisionMetaData revisionMetaData = build(revisionMetaDataWith().changedStoreElements(emptyMap()));
		assertThat(revisionMetaData.getChangedStoreElements(), is(notNullValue()));
	}
}
