package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.globalstore.GCAFolder;

public final class GCAFolderMock {

    private GCAFolderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends IDProvider, E extends IDProvider, EBUILDER extends IDProviderBuilder<E, EBUILDER>> TruncatedGCAFolderBuilder gcaFolderWith(String name, long id, EBUILDER parent) {
        return new DefaultTruncatedGCAFolderBuilder(name, id, parent);
    }

    public interface GCAFolderBuilder<T extends GCAFolder, TBUILDER extends GCAFolderBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
    }

    public static class DefaultGCAFolderBuilder<T extends GCAFolder, EBUILDER extends GCAFolderBuilder<T, EBUILDER>, TBUILDER extends DefaultGCAFolderBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements GCAFolderBuilder<T, EBUILDER> {

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultGCAFolderBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
        }
    }

    public interface TruncatedGCAFolderBuilder<T extends GCAFolder> extends GCAFolderBuilder<T, TruncatedGCAFolderBuilder<T>> {
    }

    private static final class DefaultTruncatedGCAFolderBuilder<T extends GCAFolder> extends DefaultGCAFolderBuilder<T, TruncatedGCAFolderBuilder<T>, DefaultTruncatedGCAFolderBuilder<T>> implements TruncatedGCAFolderBuilder<T> {

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultTruncatedGCAFolderBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
        }
    }
}
