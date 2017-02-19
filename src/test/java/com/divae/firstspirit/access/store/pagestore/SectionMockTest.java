package com.divae.firstspirit.access.store.pagestore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.pagestore.Section;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplate;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.pagestore.SectionMock.sectionWith;
import static com.divae.firstspirit.access.store.templatestore.SectionTemplateMock.sectionTemplateWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SectionMockTest extends MockTest {

	@Test
	public void testSectionWith() {
		assertThat(sectionWith("test", 2, null), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return SectionMock.class;
	}

	@Test
	public void testWithTemplate() {
		SectionTemplate sectionTemplate = build(sectionTemplateWith("tgif", 2, TEMPLATESTORE, null));
		Section<SectionTemplate> section = build(sectionWith("test", 2, null).aTemplate(sectionTemplate));

		assertThat(section.getTemplate(), is(sectionTemplate));
	}
}
