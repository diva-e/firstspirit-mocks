package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import org.junit.Test;

import static com.divae.firstspirit.access.store.templatestore.PageTemplatesMock.pageTemplatesWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PageTemplatesMockTest extends MockTest {

	@Test
	public void testPageTemplatesWith() {
		assertThat(pageTemplatesWith("test", 2, null), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return PageTemplatesMock.class;
	}

}
