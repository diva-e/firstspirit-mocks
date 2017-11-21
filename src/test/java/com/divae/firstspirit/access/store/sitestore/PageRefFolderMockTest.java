package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.sitestore.PageRefFolder;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.sitestore.PageRefFolderMock.pageRefFolderWith;
import static de.espirit.firstspirit.access.store.ReferenceType.PAGEREFFOLDER;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PageRefFolderMockTest extends MockTest {

    @Test
    public void testPageRefFolderWith() {
        assertThat(pageRefFolderWith("test", 2, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return PageRefFolderMock.class;
    }

    @Test
    public void testDefaults() {
        String uid = "test";
        PageRefFolder pageRefFolder;
        pageRefFolder = build(pageRefFolderWith(uid, 2, null));
        assertThat(pageRefFolder.getReferenceName(), is(PAGEREFFOLDER.prefix() + uid));
        assertThat(pageRefFolder.isFolder(), is(TRUE));
    }
}
