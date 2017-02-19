package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.globalstore.GlobalStoreRoot;
import de.espirit.firstspirit.access.store.globalstore.ProjectProperties;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.globalStoreRootWith;
import static com.divae.firstspirit.access.store.globalstore.ProjectPropertiesMock.projectPropertiesWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GlobalStoreRootMockTest extends MockTest {

	@Test
	public void testGlobalStoreRootWith() {
		assertThat(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE"))), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return GlobalStoreRootMock.class;
	}


	@Test
	public void testWithProjectProperties() {
		GlobalStoreRoot globalStoreRoot = build(globalStoreRootWith(1, projectWith("test", 0, languageWith("DE"))).projectProperties(parent -> projectPropertiesWith("uid", 2, parent)));
		ProjectProperties projectProperties = globalStoreRoot.getProjectProperties();
		assertThat(projectProperties.getName(), is("uid"));
		assertThat(projectProperties.getStore().getId(), is(1L));
	}
}
