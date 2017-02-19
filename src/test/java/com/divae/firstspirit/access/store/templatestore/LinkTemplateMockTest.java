package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock;
import com.divae.firstspirit.access.link.LinkMock;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.store.templatestore.LinkTemplate;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.store.templatestore.LinkTemplateMock.linkTemplateWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class LinkTemplateMockTest extends MockTest {

	@Test
	public void testLinkTemplateWith() {
		assertThat(linkTemplateWith("test", 2, null), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return LinkTemplateMock.class;
	}

	@Test
	public void testCreatesLink() {
		LanguageMock.LanguageBuilder languageBuilder = languageWith("DE");
		LinkTemplate linkTemplate = build(linkTemplateWith("test", 2, null).createsLink(LinkMock::linkWith, languageBuilder));
		Language language = build(languageBuilder);
		assertThat(linkTemplate.createLink(language), is(notNullValue()));
	}
}
