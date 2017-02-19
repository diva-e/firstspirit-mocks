package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.project.TemplateSetMock;
import de.espirit.firstspirit.access.project.TemplateSet;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplate;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.project.TemplateSetMock.templateSetWith;
import static com.divae.firstspirit.access.store.templatestore.SectionTemplateMock.sectionTemplateWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SectionTemplateMockTest extends MockTest {

	@Test
	public void testSectionTemplateWith() {
		assertThat(sectionTemplateWith("test", 2, TEMPLATESTORE, null), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return SectionTemplateMock.class;
	}

	@Test
	public void testAChannelSource() {
		TemplateSetMock.TemplateSetBuilder templateSetBuilder = templateSetWith("test");
		String channelSource = "channelSource";
		SectionTemplate sectionTemplate = build(sectionTemplateWith("test", 2, TEMPLATESTORE, null).aChannelSource(channelSource, templateSetBuilder));
		TemplateSet templateSet = build(templateSetBuilder);
		assertThat(sectionTemplate.getChannelSource(templateSet), is(channelSource));
	}
}
