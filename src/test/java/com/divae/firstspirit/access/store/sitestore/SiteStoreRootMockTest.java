package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.MockTest;
import org.junit.Test;

import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.sitestore.SiteStoreRootMock.siteStoreRootWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SiteStoreRootMockTest extends MockTest {

	@Test
	public void testSiteStoreRootWithStringLongProject() {
		assertThat(siteStoreRootWith(1, projectWith("test", 0, languageWith("DE"))), is(notNullValue()));
	}

	@Test
	public void testSiteStoreRootWithStringLongListLanguageInfo() {
		assertThat(siteStoreRootWith(1, projectWith("test", 0, languageWith("DE"))), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return SiteStoreRootMock.class;
	}
}
