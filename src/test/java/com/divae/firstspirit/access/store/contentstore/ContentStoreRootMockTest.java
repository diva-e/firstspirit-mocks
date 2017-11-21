package com.divae.firstspirit.access.store.contentstore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.contentstore.Content2;
import de.espirit.firstspirit.access.store.contentstore.ContentStoreRoot;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.contentstore.Content2Mock.content2With;
import static com.divae.firstspirit.access.store.contentstore.ContentStoreRootMock.contentStoreRootWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ContentStoreRootMockTest extends MockTest {

    @Test
    public void testContentStoreRootWith() {
        assertThat(contentStoreRootWith(1, projectWith("project", 0, languageWith("DE"))), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return ContentStoreRootMock.class;
    }

    @Test
    public void testWithContent2StringContent2() {
        String content2ByName = "test";
        ContentStoreRoot contentStoreRoot = build(contentStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).aContent2(parent -> content2With("test", 2, parent), content2ByName));
        Content2 content2 = contentStoreRoot.getContent2ByName(content2ByName);
        assertThat(content2.getUid(), is("test"));
        assertThat(content2.getStore().getId(), is(1L));
    }
}
