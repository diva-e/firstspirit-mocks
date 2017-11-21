package com.divae.firstspirit.access.store.mediastore;

import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaMock.MediaBuilder;
import de.espirit.firstspirit.access.store.ElementDeletedException;
import de.espirit.firstspirit.access.store.LockException;
import de.espirit.firstspirit.access.store.mediastore.Media;
import de.espirit.firstspirit.access.store.mediastore.MediaFolder;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static com.google.common.collect.ImmutableMap.of;
import static de.espirit.firstspirit.access.store.ReferenceType.MEDIAFOLDER;
import static de.espirit.firstspirit.access.store.mediastore.MediaFolder.UID_TYPE;
import static org.mockito.Mockito.when;

public final class MediaFolderMock {

    private MediaFolderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends MediaFolder, OT extends MediaFolder, OTBUILDER extends MediaFolderBuilder<OT, OTBUILDER>> TruncatedMediaFolderBuilder<T> mediaFolderWith(String uid, long id, OTBUILDER parent) {
        return new TruncatedDefaultMediaFolderBuilder<>(uid, id, parent);
    }

    public static <T extends MediaFolder, OTUILDER extends MediaFolderBuilder<T, OTUILDER>> TruncatedMediaFolderBuilder<T> mediaFolderWith(OTUILDER mediaFolder) {
        return new TruncatedDefaultMediaFolderBuilder<>(mediaFolder);
    }

    public interface MediaFolderBuilder<T extends MediaFolder, TBUILDER extends MediaFolderBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
        <OT extends MediaFolder, OTBUILDER extends MediaFolderBuilder<OT, OTBUILDER>> TBUILDER createsMediaFolder(Function<TBUILDER, OTBUILDER> function) throws LockException, ElementDeletedException;

        <OT extends MediaFolder, OTBUILDER extends MediaFolderBuilder<OT, OTBUILDER>> TBUILDER createsMediaFolderWith(Supplier<OTBUILDER> supplier) throws LockException, ElementDeletedException;

        TBUILDER aStoredUrl(String storedUrl, LanguageBuilder language);

        TBUILDER createsMedia(Function<TBUILDER, MediaBuilder> function, int mediaType, LanguageBuilder masterLanguage) throws LockException, ElementDeletedException;

        TBUILDER createsMedia(Supplier<MediaBuilder> supplier, int mediaType, LanguageBuilder masterLanguage) throws LockException, ElementDeletedException;
    }

    public static class DefaultMediaFolderBuilder<T extends MediaFolder, EBUILDER extends MediaFolderBuilder<T, EBUILDER>, TBUILDER extends DefaultMediaFolderBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements MediaFolderBuilder<T, EBUILDER> {

        protected <OT extends MediaFolder, OTBUILDER extends MediaFolderBuilder<OT, OTBUILDER>> DefaultMediaFolderBuilder(String uid, long id, OTBUILDER parent) {
            super(uid, id, UID_TYPE, parent);
            aReferenceName(MEDIAFOLDER.prefix() + uid);
            isFolder(true);
        }

        protected <OTBUILDER extends MediaFolderBuilder<T, OTBUILDER>> DefaultMediaFolderBuilder(OTBUILDER mediaFolder) {
            super(mediaFolder);
        }

        @Override
        public final <OT extends MediaFolder, OTBUILDER extends MediaFolderBuilder<OT, OTBUILDER>> EBUILDER createsMediaFolder(Function<EBUILDER, OTBUILDER> function) throws LockException, ElementDeletedException {
            return createsMediaFolderWith(() -> function.apply(getInterfaceBuilder()));
        }

        @Override
        public <OT extends MediaFolder, OTBUILDER extends MediaFolderBuilder<OT, OTBUILDER>> EBUILDER createsMediaFolderWith(Supplier<OTBUILDER> supplier) throws LockException, ElementDeletedException {
            OT mediaFolder = build(supplier.get());
            when(getBuildable().createMediaFolder(mediaFolder.getUid(), true)).thenReturn(mediaFolder);
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER aStoredUrl(String storedUrl, LanguageBuilder language) {
            when(getBuildable().getStoredUrl(getBuildable(language))).thenReturn(storedUrl);
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER createsMedia(Function<EBUILDER, MediaBuilder> function, int mediaType, LanguageBuilder masterLanguage) throws LockException, ElementDeletedException {
            return createsMedia(() -> function.apply(getInterfaceBuilder()), mediaType, masterLanguage);
        }

        @Override
        public EBUILDER createsMedia(Supplier<MediaBuilder> supplier, int mediaType, LanguageBuilder masterLanguage) throws LockException, ElementDeletedException {
            Media media = build(supplier.get());
            String uid = media.getUid();
            when(getBuildable().createMedia(uid, uid, mediaType, false, of(getBuildable(masterLanguage), uid),
                    true)).thenReturn(media);
            return getInterfaceBuilder();
        }
    }

    public interface TruncatedMediaFolderBuilder<T extends MediaFolder> extends MediaFolderBuilder<T, TruncatedMediaFolderBuilder<T>> {
    }

    private static final class TruncatedDefaultMediaFolderBuilder<T extends MediaFolder> extends DefaultMediaFolderBuilder<T, TruncatedMediaFolderBuilder<T>, TruncatedDefaultMediaFolderBuilder<T>> implements TruncatedMediaFolderBuilder<T> {

        private <OT extends MediaFolder, OTBUILDER extends MediaFolderBuilder<OT, OTBUILDER>> TruncatedDefaultMediaFolderBuilder(String uid, long id, OTBUILDER parent) {
            super(uid, id, parent);
        }

        private <OTUILDER extends MediaFolderBuilder<T, OTUILDER>> TruncatedDefaultMediaFolderBuilder(OTUILDER mediaFolder) {
            super(mediaFolder);
        }
    }
}
