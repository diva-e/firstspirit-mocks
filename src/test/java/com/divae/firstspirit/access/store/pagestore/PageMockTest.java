package com.divae.firstspirit.access.store.pagestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.templatestore.PageTemplateMock.PageTemplateBuilder;
import com.divae.firstspirit.forms.FormDataMock;
import de.espirit.firstspirit.access.store.pagestore.Page;
import de.espirit.firstspirit.access.store.templatestore.PageTemplate;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.project.TemplateSetMock.templateSetWith;
import static com.divae.firstspirit.access.store.pagestore.PageMock.pageWith;
import static com.divae.firstspirit.access.store.templatestore.PageTemplateMock.pageTemplateWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PageMockTest extends MockTest {

    @Test
    public void testPageWithStringLongLanguageInfoLanguageInfo() {
        String uid = "test";
        assertThat(pageWith(uid, 2, null), is(notNullValue()));
    }

    @Test
    public void testPageWithStringLongStringTemplateSetLanguageInfoLanguageInfo() {
        String uid = "test";
        assertThat(pageWith(uid, 2, "test", templateSetWith("test"), null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return PageMock.class;
    }

    @Test
    public void testAFormData() {
        Page page = build(pageWith("uid", 2, null).aFormData(FormDataMock::formDataWith));
        assertThat(page.getFormData(), is(notNullValue()));
    }

    @Test
    public void testATemplate() {
        PageTemplateBuilder pageTemplateBuilder = pageTemplateWith("tgif", 2, null);
        PageTemplate template = build(pageTemplateBuilder);
        Page page = build(pageWith("uid", 3, null).aTemplate(pageTemplateBuilder));
        assertThat(page.getTemplate(), is(template));
    }
}
