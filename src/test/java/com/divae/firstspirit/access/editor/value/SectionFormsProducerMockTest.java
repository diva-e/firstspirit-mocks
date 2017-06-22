package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.editor.fslist.IdProvidingFormDataMock.IdProvidingFormDataBuilder;
import com.divae.firstspirit.access.store.templatestore.SectionTemplateMock.TruncatedSectionTemplateBuilder;
import de.espirit.firstspirit.access.editor.fslist.IdProvidingFormData;
import de.espirit.firstspirit.access.editor.value.SectionFormsProducer;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplate;
import org.junit.Test;

import java.util.Collection;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.editor.fslist.IdProvidingFormDataMock.idProvidingFormDataWith;
import static com.divae.firstspirit.access.editor.value.SectionFormsProducerMock.sectionFormsProducerWith;
import static com.divae.firstspirit.access.store.templatestore.SectionTemplateMock.sectionTemplateWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SectionFormsProducerMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return SectionFormsProducerMock.class;
	}

	@Test
	public void testCreates() {
        TruncatedSectionTemplateBuilder<SectionTemplate> sectionTemplateBuilder = sectionTemplateWith("test", 2, TEMPLATESTORE, null);
        IdProvidingFormDataBuilder idProvidingFormDataBuilder = idProvidingFormDataWith(0L);
        SectionFormsProducer sectionFormsProducer = build(sectionFormsProducerWith().creates(() -> idProvidingFormDataBuilder, sectionTemplateBuilder));
		IdProvidingFormData idProvidingFormData = build(idProvidingFormDataBuilder);
		SectionTemplate sectionTemplate = build(sectionTemplateBuilder);
		assertThat(sectionFormsProducer.create(sectionTemplate), is(idProvidingFormData));
	}

	@Test
	public void testAllowedTemplates() {
        TruncatedSectionTemplateBuilder<SectionTemplate> sectionTemplateBuilder = sectionTemplateWith("test", 2, TEMPLATESTORE, null);
        SectionFormsProducer sectionFormsProducer = build(sectionFormsProducerWith().allowedTemplates(singletonList(sectionTemplateBuilder)));
		SectionTemplate sectionTemplate = build(sectionTemplateBuilder);
		Collection<SectionTemplate> allowedTemplates = sectionFormsProducer.getAllowedTemplates();
		assertThat(allowedTemplates.size(), is(1));
		assertThat(allowedTemplates.iterator().next(), is(sectionTemplate));
	}
}
