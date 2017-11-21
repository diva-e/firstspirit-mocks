package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.templatestore.GomSourceProvider;

import static org.mockito.Mockito.when;

public final class GomSourceProviderMock {

    private GomSourceProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends GomSourceProvider, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedGomSourceProviderBuilder<T> gomSourceProviderWith(String name, long id, OTBUILDER parent) {
        return new TruncatedDefaultGomSourceProviderBuilder<>(name, id, parent);
    }

    public static <T extends GomSourceProvider, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedGomSourceProviderBuilder<T> gomSourceProviderWith(String uid, long id, UidType uidType, OTBUILDER parent) {
        return new TruncatedDefaultGomSourceProviderBuilder<>(uid, id, uidType, parent);
    }

    public static <T extends GomSourceProvider, OTBUILDER extends GomSourceProviderBuilder<T, OTBUILDER>> TruncatedGomSourceProviderBuilder<T> gomSourceProviderWith(OTBUILDER idProvider) {
        return new TruncatedDefaultGomSourceProviderBuilder<>(idProvider);
    }

    public interface GomSourceProviderBuilder<T extends GomSourceProvider, TBUILDER extends GomSourceProviderBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
        TBUILDER aGomSource(String gomSource);
    }

    public static class DefaultGomSourceProviderBuilder<T extends GomSourceProvider, EBUILDER extends GomSourceProviderBuilder<T, EBUILDER>, TBUILDER extends DefaultGomSourceProviderBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements GomSourceProviderBuilder<T, EBUILDER> {

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultGomSourceProviderBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
        }

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultGomSourceProviderBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }

        protected <OTBUILDER extends GomSourceProviderBuilder<T, OTBUILDER>> DefaultGomSourceProviderBuilder(OTBUILDER idProvider) {
            super(idProvider);
        }

        @Override
        public final EBUILDER aGomSource(String gomSource) {
            when(getBuildable().getGomSource()).thenReturn(gomSource);
            return getInterfaceBuilder();
        }
    }

    public interface TruncatedGomSourceProviderBuilder<T extends GomSourceProvider> extends GomSourceProviderBuilder<T, TruncatedGomSourceProviderBuilder<T>> {
    }

    private static final class TruncatedDefaultGomSourceProviderBuilder<T extends GomSourceProvider> extends DefaultGomSourceProviderBuilder<T, TruncatedGomSourceProviderBuilder<T>, TruncatedDefaultGomSourceProviderBuilder<T>> implements TruncatedGomSourceProviderBuilder<T> {

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultGomSourceProviderBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
        }

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultGomSourceProviderBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }

        private <OTBUILDER extends GomSourceProviderBuilder<T, OTBUILDER>> TruncatedDefaultGomSourceProviderBuilder(OTBUILDER idProvider) {
            super(idProvider);
        }
    }
}
