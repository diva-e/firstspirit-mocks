package com.divae.firstspirit.access.store.pagestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.DuplicateReferenceNameException;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.store.ElementDeletedException;
import de.espirit.firstspirit.access.store.LockException;
import de.espirit.firstspirit.access.store.pagestore.PageFolder;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static de.espirit.firstspirit.access.store.pagestore.PageFolder.UID_TYPE;
import static org.mockito.Mockito.when;

public final class PageFolderMock {

    private PageFolderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends PageFolder, OT extends PageFolder, OTBUILDER extends PageFolderBuilder<OT, OTBUILDER>> TruncatedPageFolderBuilder<T> pageFolderWith(String uid, long id, OTBUILDER parent) {
        return new TruncatedDefaultPageFolderBuilder<>(uid, id, parent);
    }

    public static <T extends PageFolder, OTBUILDER extends PageFolderBuilder<T, OTBUILDER>> TruncatedPageFolderBuilder<T> pageFolderWith(OTBUILDER builder) {
        return new TruncatedDefaultPageFolderBuilder<>(builder);
    }

    public interface PageFolderBuilder<T extends PageFolder, TBUILDER extends PageFolderBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
        <OT extends PageFolder, OTBUILDER extends PageFolderBuilder<OT, OTBUILDER>> TBUILDER createsPageFolder(Function<TBUILDER, OTBUILDER> function, String uid, Map<Language, String> lang2DisplayName, boolean unifyNameOnServer) throws DuplicateReferenceNameException, ElementDeletedException, LockException;

        <OT extends PageFolder, OTBUILDER extends PageFolderBuilder<OT, OTBUILDER>> TBUILDER createsPageFolderWith(Supplier<OTBUILDER> supplier, String uid, Map<Language, String> lang2DisplayName, boolean unifyNameOnServer) throws DuplicateReferenceNameException, ElementDeletedException, LockException;
    }

    public static class DefaultPageFolderBuilder<T extends PageFolder, EBUILDER extends PageFolderBuilder<T, EBUILDER>, TBUILDER extends DefaultPageFolderBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements PageFolderBuilder<T, EBUILDER> {

        protected <OT extends PageFolder, OTBUILDER extends PageFolderBuilder<OT, OTBUILDER>> DefaultPageFolderBuilder(String uid, long id, OTBUILDER parent) {
            super(uid, id, UID_TYPE, parent);
            isFolder(true);
        }

        protected <OTBUILDER extends PageFolderBuilder<T, OTBUILDER>> DefaultPageFolderBuilder(OTBUILDER builder) {
            super(builder);
            isFolder(true);
        }

        @Override
        public final <OT extends PageFolder, OTBUILDER extends PageFolderBuilder<OT, OTBUILDER>> EBUILDER createsPageFolder(Function<EBUILDER, OTBUILDER> function, String uid, Map<Language, String> lang2DisplayName, boolean unifyNameOnServer) throws DuplicateReferenceNameException, ElementDeletedException, LockException {
            return createsPageFolderWith(() -> function.apply(getInterfaceBuilder()), uid, lang2DisplayName, unifyNameOnServer);
        }

        @Override
        public <OT extends PageFolder, OTBUILDER extends PageFolderBuilder<OT, OTBUILDER>> EBUILDER createsPageFolderWith(Supplier<OTBUILDER> supplier, String uid, Map<Language, String> lang2DisplayName, boolean unifyNameOnServer) throws DuplicateReferenceNameException, ElementDeletedException, LockException {
            OT pageFolder = build(supplier.get());
            when(getBuildable().createPageFolder(uid, lang2DisplayName, unifyNameOnServer)).thenReturn(pageFolder);
            return getInterfaceBuilder();
        }
    }

    public interface TruncatedPageFolderBuilder<T extends PageFolder> extends PageFolderBuilder<T, TruncatedPageFolderBuilder<T>> {
    }

    private static final class TruncatedDefaultPageFolderBuilder<T extends PageFolder> extends DefaultPageFolderBuilder<T, TruncatedPageFolderBuilder<T>, TruncatedDefaultPageFolderBuilder<T>> implements TruncatedPageFolderBuilder<T> {

        private <OT extends PageFolder, OTBUILDER extends PageFolderBuilder<OT, OTBUILDER>> TruncatedDefaultPageFolderBuilder(String uid, long id, OTBUILDER parent) {
            super(uid, id, parent);
        }

        private <OTBUILDER extends PageFolderBuilder<T, OTBUILDER>> TruncatedDefaultPageFolderBuilder(OTBUILDER builder) {
            super(builder);
        }
    }
}
