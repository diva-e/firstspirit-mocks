package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import org.junit.Test;

import static com.divae.firstspirit.access.store.templatestore.TemplateProviderMock.templateProviderWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TemplateProviderMockTest extends MockTest {

	@Test
	public void testTemplateProviderWithStringLongTemplateStoreRootBuilder() {
		assertThat(templateProviderWith("test", 2, null), is(notNullValue()));
	}

	@Test
	public void testTemplateProviderWithStringLongUidTypeTemplateStoreRootBuilder() {
		assertThat(templateProviderWith("test", 2, TEMPLATESTORE, null), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return TemplateProviderMock.class;
	}
}
