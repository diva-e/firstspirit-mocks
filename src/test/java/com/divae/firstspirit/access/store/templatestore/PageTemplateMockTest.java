package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.project.TemplateSetMock;
import de.espirit.firstspirit.access.project.TemplateSet;
import de.espirit.firstspirit.access.store.templatestore.PageTemplate;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.project.TemplateSetMock.templateSetWith;
import static com.divae.firstspirit.access.store.templatestore.PageTemplateMock.pageTemplateWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PageTemplateMockTest extends MockTest {

	@Test
	public void testLinkTemplateWith() {
		assertThat(pageTemplateWith("tgif", 2, null), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return PageTemplateMock.class;
	}

	@Test
	public void testAChannelSource() {
		TemplateSetMock.TemplateSetBuilder templateSetBuilder = templateSetWith("test");
		PageTemplate pageTemplate = build(pageTemplateWith("test", 2, null).aChannelSource("insert coin here", templateSetBuilder));
		TemplateSet templateSet = build(templateSetBuilder);
		assertThat(pageTemplate.getChannelSource(templateSet), is("insert coin here"));
	}
}
