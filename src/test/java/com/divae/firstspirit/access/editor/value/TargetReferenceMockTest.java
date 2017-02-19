package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.sitestore.PageRefMock.PageRefBuilder;
import de.espirit.firstspirit.access.editor.value.TargetReference;
import de.espirit.firstspirit.access.store.sitestore.PageRef;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.editor.value.TargetReferenceMock.targetReferenceWith;
import static com.divae.firstspirit.access.store.sitestore.PageRefMock.pageRefWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TargetReferenceMockTest extends MockTest {

	@Test
	public void testTargetReferenceWith() {
		assertThat(targetReferenceWith("test"), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return TargetReferenceMock.class;
	}

	@Test
	public void testAValue() {
		PageRefBuilder pageRefBuilder = pageRefWith("test", 2, null);
		TargetReference targetReference = build(targetReferenceWith("test").aValue(pageRefBuilder));
		PageRef pageRef = build(pageRefBuilder);
		assertThat(targetReference.get(), is(pageRef));
	}
}
