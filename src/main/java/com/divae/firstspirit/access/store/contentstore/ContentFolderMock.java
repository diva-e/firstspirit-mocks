package com.divae.firstspirit.access.store.contentstore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.contentstore.ContentFolder;

import static org.mockito.Mockito.when;

public final class ContentFolderMock {

    private ContentFolderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends ContentFolder, OT extends ContentFolder, OTBUILDER extends ContentFolderBuilder<OT, OTBUILDER>> TruncatedContentFolderBuilder<T> contentFolderWith(String name, long id, OTBUILDER parent) {
        return new TruncatedDefaultContentFolderBuilder<>(name, id, parent);
    }

    public static <T extends ContentFolder, OTUILDER extends ContentFolderBuilder<T, OTUILDER>> TruncatedContentFolderBuilder<T> contentFolderWith(OTUILDER contentFolder) {
        return new TruncatedDefaultContentFolderBuilder<>(contentFolder);
    }

    public interface ContentFolderBuilder<T extends ContentFolder, TBUILDER extends ContentFolderBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
    }

    public static class DefaultContentFolderBuilder<T extends ContentFolder, EBUILDER extends ContentFolderBuilder<T, EBUILDER>, TBUILDER extends DefaultContentFolderBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements ContentFolderBuilder<T, EBUILDER> {

        protected <OT extends ContentFolder, OTBUILDER extends ContentFolderBuilder<OT, OTBUILDER>> DefaultContentFolderBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
            withName(name);
        }

        protected <OTBUILDER extends ContentFolderBuilder<T, OTBUILDER>> DefaultContentFolderBuilder(OTBUILDER contentFolder) {
            super(contentFolder);
        }

        private void withName(String name) {
            when(getBuildable().getName()).thenReturn(name);
        }

    }

    public interface TruncatedContentFolderBuilder<T extends ContentFolder> extends ContentFolderBuilder<T, TruncatedContentFolderBuilder<T>> {
    }

    private static final class TruncatedDefaultContentFolderBuilder<T extends ContentFolder> extends DefaultContentFolderBuilder<T, TruncatedContentFolderBuilder<T>, TruncatedDefaultContentFolderBuilder<T>> implements TruncatedContentFolderBuilder<T> {

        private <OT extends ContentFolder, OTBUILDER extends ContentFolderBuilder<OT, OTBUILDER>> TruncatedDefaultContentFolderBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
        }

        private <OTUILDER extends ContentFolderBuilder<T, OTUILDER>> TruncatedDefaultContentFolderBuilder(OTUILDER contentFolder) {
            super(contentFolder);
        }
    }
}
