package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.TemplateStoreRootBuilder;
import de.espirit.firstspirit.access.store.templatestore.TemplateStoreRoot;
import org.junit.Assert;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.templatestore.SectionTemplatesMock.sectionTemplatesWith;
import static com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.templateStoreRootWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TemplateStoreRootMockTest extends MockTest {

    @Test
    public void testTemplateStoreRootWith() {
        assertThat(templateStoreRootWith(1, projectWith("test", 0, languageWith("DE"))), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return TemplateStoreRootMock.class;
    }

    @Test
    public void testASectionTemplates() {
        TemplateStoreRootBuilder templateStoreRootBuilder = templateStoreRootWith(1, projectWith("test", 0, languageWith("DE")));
        TemplateStoreRoot templateStoreRoot = build(templateStoreRootBuilder.aSectionTemplates(parent -> sectionTemplatesWith("sectionTemplates", 2, parent)));
        Assert.assertThat(templateStoreRoot.getSectionTemplates().getUid(), is("sectionTemplates"));
    }
}
