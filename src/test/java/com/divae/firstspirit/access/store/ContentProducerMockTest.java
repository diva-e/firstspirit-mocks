package com.divae.firstspirit.access.store;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import de.espirit.firstspirit.access.project.TemplateSet;
import de.espirit.firstspirit.access.store.ContentProducer;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.TemplateSetMock.templateSetWith;
import static com.divae.firstspirit.access.store.ContentProducerMock.contentProducerWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.GLOBALSTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ContentProducerMockTest extends MockTest {

	@Test
	public void testContentProducerWithStringLongListLanguageInfo() {
		assertThat(build(contentProducerWith("test", 2, GLOBALSTORE, null)), is(notNullValue()));
	}


	@Test
	public void testContentProducerWithStringLongStringTemplateSetListLanguageInfo() {
		assertThat(contentProducerWith("test", 2, GLOBALSTORE, "", templateSetWith("test"), null), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return ContentProducerMock.class;
	}

	@Test
	public void testDefaults() {
		ContentProducer contentProducer = build(contentProducerWith("test", 2, GLOBALSTORE, null));
		TemplateSet templateSet = build(templateSetWith("test"));
		assertThat(contentProducer.getExtension(templateSet), is(""));
	}

	@Test
	public void testWithExtension() {
		String extension = "test";
		TemplateSetBuilder templateSetBuilder = templateSetWith("test");
		ContentProducer contentProducer = build(contentProducerWith("test", 2, GLOBALSTORE, extension, templateSetBuilder, null));
		TemplateSet templateSet = build(templateSetBuilder);
		assertThat(contentProducer.getExtension(templateSet), is(extension));
	}

	@Test
	public void testWithGetStoredUrl() {
		LanguageBuilder languageBuilder = languageWith("DE");
		TemplateSetBuilder templateSetBuilder = templateSetWith("test");
		TemplateSet templateSet = build(templateSetBuilder);

		ContentProducer contentProducer = build(contentProducerWith("test", 2, GLOBALSTORE, null).aStoredUrl("test", languageBuilder, templateSetBuilder, null));
		assertThat(contentProducer.getStoredUrl(build(languageBuilder), templateSet, null), is("test"));
	}
}
