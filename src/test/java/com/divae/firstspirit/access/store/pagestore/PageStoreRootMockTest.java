package com.divae.firstspirit.access.store.pagestore;

import com.divae.firstspirit.MockTest;
import org.junit.Test;

import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.pagestore.PageStoreRootMock.pageStoreRootWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PageStoreRootMockTest extends MockTest {

	@Test
	public void testPageStoreRootWith() {
		assertThat(pageStoreRootWith(1, projectWith("test", 0, languageWith("DE"))), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return PageStoreRootMock.class;
	}
}
