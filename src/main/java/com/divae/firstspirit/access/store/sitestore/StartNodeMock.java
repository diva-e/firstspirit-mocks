package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.sitestore.SiteStoreFolderMock.SiteStoreFolderBuilder;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.sitestore.SiteStoreFolder;
import de.espirit.firstspirit.access.store.sitestore.StartNode;

import static org.mockito.Mockito.when;

public final class StartNodeMock {

    private StartNodeMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends StartNode, OT extends SiteStoreFolder, OTBUILDER extends SiteStoreFolderBuilder<OT, OTBUILDER>> TruncatedStartNodeBuilder<T> startNodeWith(String uid, long id, UidType uidType, OTBUILDER parent) {
        return new TruncatedDefaultStartNodeBuilder<>(uid, id, uidType, parent);
    }

    public static <T extends StartNode, OTBUILDER extends StartNodeBuilder<T, OTBUILDER>> TruncatedStartNodeBuilder<T> startNodeWith(OTBUILDER startNode) {
        return new TruncatedDefaultStartNodeBuilder<>(startNode);
    }

    public interface StartNodeBuilder<T extends StartNode, TBUILDER extends StartNodeBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
        TBUILDER isStartNode(boolean startNode);
    }

    public static class DefaultStartNodeBuilder<T extends StartNode, EBUILDER extends StartNodeBuilder<T, EBUILDER>, TBUILDER extends DefaultStartNodeBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements StartNodeBuilder<T, EBUILDER> {

        protected <OT extends SiteStoreFolder, OTBUILDER extends SiteStoreFolderBuilder<OT, OTBUILDER>> DefaultStartNodeBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }

        protected <OTBUILDER extends StartNodeBuilder<T, OTBUILDER>> DefaultStartNodeBuilder(OTBUILDER startNode) {
            super(startNode);
        }

        public final EBUILDER isStartNode(boolean startNode) {
            when(getBuildable().isStartNode()).thenReturn(startNode);
            return getInterfaceBuilder();
        }
    }

    public interface TruncatedStartNodeBuilder<T extends StartNode> extends StartNodeBuilder<T, TruncatedStartNodeBuilder<T>> {
    }

    private static final class TruncatedDefaultStartNodeBuilder<T extends StartNode> extends DefaultStartNodeBuilder<T, TruncatedStartNodeBuilder<T>, TruncatedDefaultStartNodeBuilder<T>> implements TruncatedStartNodeBuilder<T> {

        private <OT extends SiteStoreFolder, OTBUILDER extends SiteStoreFolderBuilder<OT, OTBUILDER>> TruncatedDefaultStartNodeBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }

        private <OTBUILDER extends StartNodeBuilder<T, OTBUILDER>> TruncatedDefaultStartNodeBuilder(OTBUILDER startNode) {
            super(startNode);
        }
    }
}
