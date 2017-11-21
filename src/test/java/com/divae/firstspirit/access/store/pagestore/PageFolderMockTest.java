package com.divae.firstspirit.access.store.pagestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import de.espirit.firstspirit.access.DuplicateReferenceNameException;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.store.ElementDeletedException;
import de.espirit.firstspirit.access.store.LockException;
import de.espirit.firstspirit.access.store.pagestore.PageFolder;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.pagestore.PageFolderMock.pageFolderWith;
import static com.divae.firstspirit.access.store.pagestore.PageStoreRootMock.pageStoreRootWith;
import static java.lang.Boolean.TRUE;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PageFolderMockTest extends MockTest {

    @Test
    public void testPageFolderWith() {
        String uid = "test";
        assertThat(pageFolderWith(uid, 2, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return PageFolderMock.class;
    }

    @Test
    public void testDefaults() {
        PageFolder pageFolder = build(pageFolderWith("test", 2, null));
        assertThat(pageFolder.isFolder(), is(TRUE));
    }

    @Test
    public void testCreatesPageFolder() throws DuplicateReferenceNameException, ElementDeletedException, LockException {
        LanguageBuilder languageBuilder = languageWith("DE");
        final Map<Language, String> displayNames = new HashMap<>();

        PageFolder pageFolder = (PageFolder) build(pageStoreRootWith(1, projectWith("test", 0, languageBuilder)).children(parent -> {
            try {
                return singletonList(pageFolderWith("pageFolder", 2, parent).createsPageFolder(pageFolderParent -> {
                    displayNames.put(build(languageBuilder), "pageFolderChildDisplayName");
                    return pageFolderWith("pageFolderChild", 3, pageFolderParent);
                }, "pageFolderChild", displayNames, true));
            } catch (DuplicateReferenceNameException | ElementDeletedException | LockException e) {
                Assert.fail(e.getMessage());
                return emptyList();
            }
        })).getChildren().iterator().next();
        assertThat(pageFolder.createPageFolder("pageFolderChild", displayNames, true).getUid(), is("pageFolderChild"));
    }
}
