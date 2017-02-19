package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.MockTest;
import org.junit.Test;

import static com.divae.firstspirit.access.project.TemplateSetMock.templateSetWith;
import static com.divae.firstspirit.access.store.globalstore.GCAPageMock.gcaPageWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GCAPageMockTest extends MockTest {

	@Test
	public void testGcaPageWithStringLongGlobalStoreRootBuilder() {
		assertThat(gcaPageWith("ui", 2, null), is(notNullValue()));
	}

	@Test
	public void testGcaPageWithStringLongStringTemplateSetGlobalStoreRootBuilder() {
		assertThat(gcaPageWith("ui", 2, "extension", templateSetWith("test"), null), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return GCAPageMock.class;
	}

}
