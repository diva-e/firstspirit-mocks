package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.access.store.globalstore.GCAFolderMock.DefaultGCAFolderBuilder;
import com.divae.firstspirit.access.store.globalstore.GCAFolderMock.GCAFolderBuilder;
import com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.GlobalStoreRootBuilder;
import de.espirit.firstspirit.access.store.globalstore.GlobalContentArea;

public final class GlobalContentAreaMock {

    private GlobalContentAreaMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static GlobalContentAreaBuilder globalContentAreaWith(String uid, long id, GlobalStoreRootBuilder parent) {
        return new DefaultGlobalContentAreaBuilder(uid, id, parent);
    }

    public interface GlobalContentAreaBuilder extends GCAFolderBuilder<GlobalContentArea, GlobalContentAreaBuilder> {
    }

    private static final class DefaultGlobalContentAreaBuilder extends DefaultGCAFolderBuilder<GlobalContentArea, GlobalContentAreaBuilder, DefaultGlobalContentAreaBuilder> implements GlobalContentAreaBuilder {

        private DefaultGlobalContentAreaBuilder(String name, long id, GlobalStoreRootBuilder parent) {
            super(name, id, parent);
        }

    }
}
