package com.divae.firstspirit.access.store.mediastore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.mediastore.MediaStoreRoot;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.mediastore.MediaMock.mediaWith;
import static com.divae.firstspirit.access.store.mediastore.MediaStoreRootMock.mediaStoreRootWith;
import static de.espirit.firstspirit.access.store.mediastore.Media.UID_TYPE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class MediaStoreRootMockTest extends MockTest {

	@Test
	public void testMediaStoreRootWith() {
		assertThat(mediaStoreRootWith(1, projectWith("test", 0, languageWith("DE"))), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return MediaStoreRootMock.class;
	}

	@Test
	public void testAMediaByUid() {
		long id = 2;
		MediaStoreRoot mediaStoreRoot = build(mediaStoreRootWith(1, projectWith("test", 0, languageWith("DE"))).aMediaByUid(parent -> mediaWith("test", id, parent), "test"));
		assertThat(mediaStoreRoot.getMediaByUid("test").getId(), is(id));
		assertThat(mediaStoreRoot.getStoreElement("test", UID_TYPE).getId(), is(id));
	}
}
