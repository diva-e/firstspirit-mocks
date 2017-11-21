package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplates;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.templatestore.SectionTemplateMock.sectionTemplateWith;
import static com.divae.firstspirit.access.store.templatestore.SectionTemplatesMock.sectionTemplatesWith;
import static com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.templateStoreRootWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SectionTemplatesMockTest extends MockTest {

    @Test
    public void testSectionTemplatesWith() {
        assertThat(sectionTemplatesWith("test", 2, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return SectionTemplatesMock.class;
    }

    @Test
    public void testATemplate() {
        SectionTemplates sectionTemplates = build(templateStoreRootWith(1, projectWith("test", 0, languageWith("DE"))).aSectionTemplates(parent -> sectionTemplatesWith("sectionTemplates", 2, parent).aTemplate(sectionTemplateParent -> sectionTemplateWith("sectionTemplate", 3, TEMPLATESTORE, sectionTemplateParent)))).getSectionTemplates();
        assertThat(sectionTemplates.getTemplate("sectionTemplate"), is(sectionTemplates.getChildren().iterator().next()));
    }
}
