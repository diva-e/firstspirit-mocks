package com.divae.firstspirit.access.store.mediastore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.project.ResolutionMock.ResolutionBuilder;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.project.Resolution;
import de.espirit.firstspirit.access.store.mediastore.Media;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.project.ResolutionMock.resolutionWith;
import static com.divae.firstspirit.access.store.mediastore.FileMock.fileWith;
import static com.divae.firstspirit.access.store.mediastore.MediaMock.mediaWith;
import static com.divae.firstspirit.access.store.mediastore.MediaStoreRootMock.mediaStoreRootWith;
import static com.divae.firstspirit.access.store.mediastore.PictureMock.pictureWith;
import static de.espirit.firstspirit.access.store.ReferenceType.MEDIA;
import static de.espirit.firstspirit.access.store.mediastore.Media.FILE;
import static de.espirit.firstspirit.access.store.mediastore.Media.PICTURE;
import static java.lang.Boolean.FALSE;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class MediaMockTest extends MockTest {

	@Test
	public void testMediaWith() {
		String uid = "test";
		assertThat(mediaWith(uid, 2, null), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return MediaMock.class;
	}

	@Test
	public void testAPicture() {
		LanguageBuilder masterLanguage = languageWith("DE");
		ProjectBuilder projectBuilder = projectWith("test", 0, masterLanguage);
		String uid = "test";
		Media media = (Media) build(mediaStoreRootWith(1, projectBuilder).children(parent -> singletonList(mediaWith(uid, 2, parent).aPicture(mediaBuilderParent -> pictureWith("picture", mediaBuilderParent), masterLanguage)))).getChildren().iterator().next();
		assertThat(media.getPicture(build(masterLanguage)), is(notNullValue()));
		assertThat(media.getType(), is(PICTURE));
	}

	@Test
	public void testAFile() {
		LanguageBuilder languageBuilder = languageWith("DE");
		String uid = "test";
		Media media = (Media) build(mediaStoreRootWith(1, projectWith("test", 0, languageBuilder)).children(parent -> singletonList(mediaWith(uid, 2, parent).aFile(mediaBuilderParent -> fileWith("file", mediaBuilderParent), languageBuilder)))).getChildren().iterator().next();
		Language language = build(languageBuilder);
		assertThat(media.getFile(language), is(notNullValue()));
		assertThat(media.getType(), is(FILE));
		assertThat(media.getParseFile(), is(FALSE));
	}

	@Test
	public void testAStoredUrl() {
		LanguageBuilder languageBuilder = languageWith("DE").isMasterLanguage();
		String uid = "test";
		ResolutionBuilder resolutionBuilder = resolutionWith("test");
		Resolution resolution = build(resolutionBuilder);
		Media media = build(mediaWith(uid, 2, null).aStoredUrl("test", languageBuilder, resolutionBuilder));
		Language masterLanguage = build(languageBuilder);
		assertThat(media.getStoredUrl(masterLanguage, resolution), is("test"));
	}


	@Test
	public void testDefaults() {
		String uid = "test";
		Media media = build(mediaWith(uid, 2, null));
		assertThat(media.getReferenceName(), is(MEDIA.prefix() + uid));
	}
}
