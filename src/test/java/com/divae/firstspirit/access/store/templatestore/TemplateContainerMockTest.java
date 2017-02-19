package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.templatestore.TemplateContainerMock.TemplateContainerBuilder;
import org.junit.Test;

import static com.divae.firstspirit.access.store.templatestore.TemplateContainerMock.templateContainerWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TemplateContainerMockTest extends MockTest {

	@Test
	public void testTemplateContainerWith() {
		TemplateContainerBuilder templateContainerBuilder = templateContainerWith("test", 2, null);
		assertThat(templateContainerBuilder, is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return TemplateContainerMock.class;
	}

}
