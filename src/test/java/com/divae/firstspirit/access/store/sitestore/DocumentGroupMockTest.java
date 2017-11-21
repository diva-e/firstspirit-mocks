package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.sitestore.DocumentGroup;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.project.TemplateSetMock.templateSetWith;
import static com.divae.firstspirit.access.store.sitestore.DocumentGroupMock.documentGroupWith;
import static de.espirit.firstspirit.access.store.ReferenceType.DOCUMENTGROUP;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class DocumentGroupMockTest extends MockTest {

    @Test
    public void testDocumentGroupWithStringLongLanguageInfoLanguageInfo() {
        String uid = "test";
        assertThat(documentGroupWith(uid, 2, null), is(notNullValue()));
    }

    @Test
    public void testDocumentGroupWithStringLongStringTemplateSetLanguageInfoLanguageInfo() {
        String uid = "test";
        assertThat(documentGroupWith(uid, 2, "test", templateSetWith("test"), null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return DocumentGroupMock.class;
    }

    @Test
    public void testDefaults() {
        String uid = "test";
        DocumentGroup documentGroup = build(documentGroupWith(uid, 2, null));
        assertThat(documentGroup.getReferenceName(), is(DOCUMENTGROUP.prefix() + uid));
    }
}
