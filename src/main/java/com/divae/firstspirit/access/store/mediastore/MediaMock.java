package com.divae.firstspirit.access.store.mediastore;

import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.ResolutionMock.ResolutionBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.mediastore.FileMock.FileBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaFolderMock.MediaFolderBuilder;
import com.divae.firstspirit.access.store.mediastore.PictureMock.PictureBuilder;
import de.espirit.firstspirit.access.store.mediastore.File;
import de.espirit.firstspirit.access.store.mediastore.Media;
import de.espirit.firstspirit.access.store.mediastore.MediaFolder;
import de.espirit.firstspirit.access.store.mediastore.Picture;

import java.util.function.Function;

import static com.divae.firstspirit.BuilderMock.build;
import static de.espirit.firstspirit.access.store.ReferenceType.MEDIA;
import static de.espirit.firstspirit.access.store.mediastore.Media.*;
import static org.mockito.Mockito.when;

public final class MediaMock {

	private MediaMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends MediaFolder, TBUILDER extends MediaFolderBuilder<T, TBUILDER>> MediaBuilder mediaWith(String uid, long id, TBUILDER parent) {
		return new DefaultMediaBuilder(uid, id, parent);
	}

	public interface MediaBuilder extends IDProviderBuilder<Media, MediaBuilder> {
		MediaBuilder aPicture(Function<MediaBuilder, PictureBuilder> function, LanguageBuilder language);

		MediaBuilder aStoredUrl(String storedUrl, LanguageBuilder language, ResolutionBuilder resolution);

		MediaBuilder aFile(Function<MediaBuilder, FileBuilder> function, LanguageBuilder language);
	}

	public static final class DefaultMediaBuilder extends DefaultIDProviderBuilder<Media, MediaBuilder, DefaultMediaBuilder> implements MediaBuilder {

		private <T extends MediaFolder, TBUILDER extends MediaFolderBuilder<T, TBUILDER>> DefaultMediaBuilder(String uid, long id, TBUILDER parent) {
			super(uid, id, UID_TYPE, parent);
			aReferenceName(MEDIA.prefix() + uid);
		}

		@Override
		public final MediaBuilder aPicture(Function<MediaBuilder, PictureBuilder> function, LanguageBuilder language) {
			Picture picture = build(function.apply(getBuilder()));
			when(getBuildable().getPicture(getBuildable(language))).thenReturn(picture);
			when(getBuildable().getType()).thenReturn(PICTURE);
			return getBuilder();
		}

		@Override
		public final MediaBuilder aStoredUrl(String storedUrl, LanguageBuilder language, ResolutionBuilder resolution) {
			when(getBuildable().getStoredUrl(getBuildable(language), getBuildable(resolution))).thenReturn(storedUrl);
			return getBuilder();
		}

		@Override
		public final MediaBuilder aFile(Function<MediaBuilder, FileBuilder> function, LanguageBuilder language) {
			File file = build(function.apply(getBuilder()));
			when(getBuildable().getFile(getBuildable(language))).thenReturn(file);
			when(getBuildable().getType()).thenReturn(FILE);
			return getBuilder();
		}
	}
}
