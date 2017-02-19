package com.divae.firstspirit.access.store.mediastore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import de.espirit.firstspirit.access.DuplicateReferenceNameException;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.store.ElementDeletedException;
import de.espirit.firstspirit.access.store.LockException;
import de.espirit.firstspirit.access.store.mediastore.MediaFolder;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.mediastore.MediaFolderMock.mediaFolderWith;
import static com.divae.firstspirit.access.store.mediastore.MediaMock.mediaWith;
import static com.divae.firstspirit.access.store.mediastore.MediaStoreRootMock.mediaStoreRootWith;
import static com.google.common.collect.ImmutableMap.of;
import static de.espirit.firstspirit.access.store.ReferenceType.MEDIAFOLDER;
import static de.espirit.firstspirit.access.store.mediastore.Media.FILE;
import static java.lang.Boolean.TRUE;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class MediaFolderMockTest extends MockTest {

	@Test
	public void testMediaFolderWith() {
		String uid = "test";
		assertThat(mediaFolderWith(uid, 2, null), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return MediaFolderMock.class;
	}

	@Test
	public void testCreatesMediaFolderMediaFolder() throws DuplicateReferenceNameException, LockException, ElementDeletedException {
		String uid = "child";
		LanguageBuilder languageBuilder = languageWith("DE");
		MediaFolder mediaFolder = (MediaFolder) build(mediaStoreRootWith(1, projectWith("test", 0, languageBuilder)).children(parent -> {
			try {
				return singletonList(mediaFolderWith("parent", 2, parent).createsMediaFolder(mediaFolderParent -> mediaFolderWith(uid, 3, mediaFolderParent)));
			} catch (LockException | ElementDeletedException e) {
				fail(e.getMessage());
				return emptyList();
			}
		})).getChildren().iterator().next();
		MediaFolder mediaFolderChild = mediaFolder.createMediaFolder(uid, true);
		assertThat(mediaFolderChild.getUid(), is(uid));
		assertThat(mediaFolderChild.getParent().getId(), is(2L));
	}

	@Test
	public void testCreatesMediaMediaIntegerLanguage() throws DuplicateReferenceNameException, LockException, ElementDeletedException {
		LanguageBuilder languageBuilder = languageWith("DE");
		ProjectBuilder projectBuilder = projectWith("test", 0, languageBuilder);
		String uid = "child";
		MediaFolder mediaFolder = (MediaFolder) build(mediaStoreRootWith(1, projectBuilder).children(parent -> {
			try {
				return singletonList(mediaFolderWith("parent", 2, parent).createsMedia(mediaFolderParent -> mediaWith(uid, 3, mediaFolderParent), FILE, languageBuilder));
			} catch (LockException | ElementDeletedException e) {
				fail(e.getMessage());
				return emptyList();
			}
		})).getChildren().iterator().next();
		assertThat(mediaFolder.createMedia(uid, uid, FILE, false, of(build(languageBuilder),
				uid), true).getUid(), is(uid));
	}

	@Test
	public void testAStoredUrl() {
		LanguageBuilder languageBuilder = languageWith("DE").isMasterLanguage();
		MediaFolder mediaFolder = build(mediaFolderWith("parent", 2, null).aStoredUrl("test", languageBuilder));
		Language masterLanguage = build(languageBuilder);
		assertThat(mediaFolder.getStoredUrl(masterLanguage), is("test"));
	}

	@Test
	public void testDefaults() {
		String uid = "test";
		MediaFolder mediaFolder = build(mediaFolderWith(uid, 2, null));
		assertThat(mediaFolder.getReferenceName(), is(MEDIAFOLDER.prefix() + uid));
		assertThat(mediaFolder.isFolder(), is(TRUE));
	}
}
