package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.editor.fslist.IdProvidingFormDataMock.IdProvidingFormDataBuilder;
import com.divae.firstspirit.access.store.templatestore.LinkTemplateMock.LinkTemplateBuilder;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.editor.fslist.IdProvidingFormData;
import de.espirit.firstspirit.access.editor.value.LinkFormsProducer;
import de.espirit.firstspirit.access.store.templatestore.LinkTemplate;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.editor.fslist.IdProvidingFormDataMock.idProvidingFormDataWith;
import static com.divae.firstspirit.access.editor.value.LinkFormsProducerMock.linkFormsProducerWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.templatestore.LinkTemplateMock.linkTemplateWith;
import static com.divae.firstspirit.access.store.templatestore.LinkTemplatesMock.linkTemplatesWith;
import static com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.templateStoreRootWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LinkFormsProducerMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return LinkFormsProducerMock.class;
    }

    @Test
    public void testCreate() {
        LanguageBuilder languageBuilder = languageWith("DE");
        LinkTemplateBuilder linkTemplateBuilder = linkTemplateWith("test", 3, linkTemplatesWith("linkTemplates", 2, templateStoreRootWith(1, projectWith("test", 0, languageBuilder))));
        IdProvidingFormDataBuilder idProvidingFormDataBuilder = idProvidingFormDataWith(4L);
        LinkFormsProducer linkFormsProducer = build(linkFormsProducerWith().creates(() -> idProvidingFormDataBuilder, linkTemplateBuilder, languageBuilder));
        LinkTemplate linkTemplate = build(linkTemplateBuilder);
        IdProvidingFormData idProvidingFormData = build(idProvidingFormDataBuilder);
        Language masterLanguage = build(languageBuilder);
        assertThat(linkFormsProducer.create(linkTemplate, masterLanguage), is(idProvidingFormData));
    }
}
