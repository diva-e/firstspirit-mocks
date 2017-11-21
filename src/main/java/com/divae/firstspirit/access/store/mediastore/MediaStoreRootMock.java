package com.divae.firstspirit.access.store.mediastore;

import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.store.StoreMock.DefaultStoreBuilder;
import com.divae.firstspirit.access.store.StoreMock.StoreBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaFolderMock.MediaFolderBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaFolderMock.TruncatedMediaFolderBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaMock.MediaBuilder;
import de.espirit.firstspirit.access.store.ElementDeletedException;
import de.espirit.firstspirit.access.store.LockException;
import de.espirit.firstspirit.access.store.mediastore.Media;
import de.espirit.firstspirit.access.store.mediastore.MediaFolder;
import de.espirit.firstspirit.access.store.mediastore.MediaStoreRoot;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.mediastore.MediaFolderMock.mediaFolderWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.MEDIASTORE_FOLDER;
import static de.espirit.firstspirit.access.store.Store.Type.MEDIASTORE;
import static de.espirit.firstspirit.access.store.mediastore.Media.UID_TYPE;
import static org.mockito.Mockito.when;

public final class MediaStoreRootMock {

    private MediaStoreRootMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static MediaStoreRootBuilder mediaStoreRootWith(long id, ProjectBuilder project) {
        return new DefaultMediaStoreRootBuilder(id, project);
    }

    public interface MediaStoreRootBuilder extends StoreBuilder<MediaStoreRoot, MediaStoreRootBuilder>, MediaFolderBuilder<MediaStoreRoot, MediaStoreRootBuilder> {
        MediaStoreRootBuilder aMediaByUid(Function<MediaStoreRootBuilder, MediaBuilder> function, String uid);
    }

    public static final class DefaultMediaStoreRootBuilder extends DefaultStoreBuilder<MediaStoreRoot, MediaStoreRootBuilder, DefaultMediaStoreRootBuilder> implements MediaStoreRootBuilder {

        private final TruncatedMediaFolderBuilder<MediaStoreRoot> mediaFolderBuilder;

        private DefaultMediaStoreRootBuilder(long id, ProjectBuilder project) {
            super(id, MEDIASTORE_FOLDER, MEDIASTORE, project);
            mediaFolderBuilder = mediaFolderWith(getBuilder());
        }

        @Override
        public final MediaStoreRootBuilder aMediaByUid(Function<MediaStoreRootBuilder, MediaBuilder> function, String uid) {
            Media media = build(function.apply(getBuilder()));
            when(getBuildable().getMediaByUid(uid)).thenReturn(media);
            aStoreElement(media, uid, UID_TYPE);
            return getBuilder();
        }

        @Override
        public <T extends MediaFolder, TBUILDER extends MediaFolderBuilder<T, TBUILDER>> MediaStoreRootBuilder createsMediaFolder(Function<MediaStoreRootBuilder, TBUILDER> function) throws LockException, ElementDeletedException {
            return createsMediaFolderWith(() -> function.apply(getBuilder()));
        }

        @Override
        public <T extends MediaFolder, TBUILDER extends MediaFolderBuilder<T, TBUILDER>> MediaStoreRootBuilder createsMediaFolderWith(Supplier<TBUILDER> supplier) throws LockException, ElementDeletedException {
            mediaFolderBuilder.createsMediaFolderWith(supplier);
            return getBuilder();
        }

        @Override
        public MediaStoreRootBuilder aStoredUrl(String storedUrl, LanguageBuilder language) {
            mediaFolderBuilder.aStoredUrl(storedUrl, language);
            return getBuilder();
        }

        @Override
        public MediaStoreRootBuilder createsMedia(Function<MediaStoreRootBuilder, MediaBuilder> function, int mediaType, LanguageBuilder masterLanguage) throws LockException, ElementDeletedException {
            return createsMedia(() -> function.apply(getBuilder()), mediaType, masterLanguage);
        }

        @Override
        public MediaStoreRootBuilder createsMedia(Supplier<MediaBuilder> supplier, int mediaType, LanguageBuilder masterLanguage) throws LockException, ElementDeletedException {
            mediaFolderBuilder.createsMedia(supplier, mediaType, masterLanguage);
            return getBuilder();
        }
    }
}
