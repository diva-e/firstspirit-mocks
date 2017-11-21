package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.pagestore.Page;
import de.espirit.firstspirit.access.store.sitestore.PageRef;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.project.TemplateSetMock.templateSetWith;
import static com.divae.firstspirit.access.store.pagestore.PageMock.pageWith;
import static com.divae.firstspirit.access.store.sitestore.Content2ParamsMock.content2ParamsWith;
import static com.divae.firstspirit.access.store.sitestore.PageRefMock.pageRefWith;
import static com.divae.firstspirit.access.store.sitestore.SiteStoreRootMock.siteStoreRootWith;
import static de.espirit.firstspirit.access.store.ReferenceType.PAGEREF;
import static java.lang.Boolean.TRUE;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PageRefMockTest extends MockTest {

    @Test
    public void testPageRefWithStringLongLanguageInfoLanguageInfo() {
        assertThat(pageRefWith("test", 2, null), is(notNullValue()));
    }

    @Test
    public void testPageRefWithStringLongStringTemplateSetLanguageInfoLanguageInfo() {
        assertThat(pageRefWith("test", 2, "Test", templateSetWith("test"), null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return PageRefMock.class;
    }

    @Test
    public void testAContent2Params() {
        String uid = "test";
        PageRef pageRef = (PageRef) build(siteStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> singletonList(pageRefWith(uid, 2, parent).aContent2Params(pageRefParent -> content2ParamsWith("content2Params", pageRefParent))))).getChildren().iterator().next();
        assertThat(pageRef.getContent2Params(), is(notNullValue()));
    }

    @Test
    public void testAPage() {
        String uid = "test";
        Page page = build(pageWith("test", 2, null));
        PageRef pageRef = build(pageRefWith(uid, 2, null).aPage(page));
        assertThat(pageRef.getPage(), is(page));
    }

    @Test
    public void testIsStartNode() {
        PageRef pageRef = build(pageRefWith("test", 2, null).isStartNode(true));
        assertThat(pageRef.isStartNode(), is(TRUE));
    }

    @Test
    public void testDefaults() {
        String uid = "test";
        PageRef pageRef = build(pageRefWith(uid, 2, null));
        assertThat(pageRef.getReferenceName(), is(PAGEREF.prefix() + uid));
    }
}
