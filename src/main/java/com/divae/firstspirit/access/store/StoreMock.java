package com.divae.firstspirit.access.store;

import com.divae.firstspirit.access.UserServiceMock.UserServiceBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.UserService;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.Store;
import de.espirit.firstspirit.access.store.Store.Type;

import java.util.function.Function;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class StoreMock {

    private StoreMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends Store> TruncatedStoreBuilder<T> storeWith(long id, UidType uidType, Type type, ProjectBuilder project) {
        return new TruncatedDefaultStoreBuilder<>(id, uidType, type, project);
    }

    public interface StoreBuilder<T extends Store, TBUILDER extends StoreBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
        <E extends IDProvider, EBUILDER extends IDProviderBuilder<E, EBUILDER>> TBUILDER aStoreElement(Function<TBUILDER, EBUILDER> function, String attributeName, String attributeValue);

        <E extends IDProvider, EBUILDER extends IDProviderBuilder<E, EBUILDER>> TBUILDER aStoreElement(Function<TBUILDER, EBUILDER> function, String attributeName, UidType uidType);

        <E extends IDProvider, EBUILDER extends IDProviderBuilder<E, EBUILDER>> TBUILDER aStoreElement(Function<TBUILDER, EBUILDER> function, long id);

        TBUILDER anUserService(UserServiceBuilder userService);
    }

    public static class DefaultStoreBuilder<T extends Store, EBUILDER extends StoreBuilder<T, EBUILDER>, TBUILDER extends DefaultStoreBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements StoreBuilder<T, EBUILDER> {

        private static final String ROOT_STORE_UID = "root";

        protected DefaultStoreBuilder(long id, UidType uidType, Type type, ProjectBuilder project) {
            super(ROOT_STORE_UID, id, uidType, null, project);
            aStoreType(type);
            aStore(getBuildable());
        }

        @Override
        public <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> EBUILDER aStoreElement(Function<EBUILDER, OTBUILDER> function, String attributeName, String attributeValue) {
            EBUILDER builder = getInterfaceBuilder();
            IDProvider idProvider = build(function.apply(builder));
            aStoreElement(idProvider, attributeName, attributeValue);
            return builder;
        }

        @Override
        public <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> EBUILDER aStoreElement(Function<EBUILDER, OTBUILDER> function, String attributeName, UidType uidType) {
            EBUILDER builder = getInterfaceBuilder();
            IDProvider idProvider = build(function.apply(builder));
            aStoreElement(idProvider, attributeName, uidType);
            return builder;
        }

        @Override
        public <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> EBUILDER aStoreElement(Function<EBUILDER, OTBUILDER> function, long id) {
            EBUILDER builder = getInterfaceBuilder();
            IDProvider idProvider = build(function.apply(builder));
            aStoreElement(idProvider, id);
            return builder;
        }

        protected void aStoreElement(IDProvider idProvider, String attributeName, UidType uidType) {
            if (getBuildable().getStoreElement(attributeName, uidType) != null) {
                throw new IllegalArgumentException("Attribute [" + attributeName + "] with uid type [" + uidType + "] is already on store with uid [" + getBuildable().getUid() + "]. Please choose another value.");
            }
            when(getBuildable().getStoreElement(attributeName, uidType)).thenReturn(idProvider);
        }

        protected void aStoreElement(IDProvider idProvider, String attributeName, String attributeValue) {
            if (getBuildable().getStoreElement(attributeName, attributeValue) != null) {
                throw new IllegalArgumentException("Attribute [" + attributeName + "] with value [" + attributeValue + "] is already on store with uid [" + getBuildable().getUid() + "]. Please choose another value.");
            }
            when(getBuildable().getStoreElement(attributeName, attributeValue)).thenReturn(idProvider);
        }

        protected void aStoreElement(IDProvider idProvider, long id) {
            if (getBuildable().getStoreElement(id) != null) {
                throw new IllegalArgumentException("Id [" + id + "] is already on store with uid [" + getBuildable().getUid() + "]. Please choose another value.");
            }
            when(getBuildable().getStoreElement(id)).thenReturn(idProvider);
        }

        @Override
        public EBUILDER anUserService(UserServiceBuilder userService) {
            UserService buildable = getBuildable(userService);
            validateOwnWithOtherProject(buildable.getProject());
            when(getBuildable().getUserService()).thenReturn(buildable);
            return getInterfaceBuilder();
        }

        private void aStoreType(Type type) {
            when(getBuildable().getType()).thenReturn(type);
        }
    }

    public interface TruncatedStoreBuilder<T extends Store> extends StoreBuilder<T, TruncatedStoreBuilder<T>> {
    }

    private static final class TruncatedDefaultStoreBuilder<T extends Store> extends DefaultStoreBuilder<T, TruncatedStoreBuilder<T>, TruncatedDefaultStoreBuilder<T>> implements TruncatedStoreBuilder<T> {
        private TruncatedDefaultStoreBuilder(long id, UidType uidType, Type type, ProjectBuilder project) {
            super(id, uidType, type, project);
        }
    }
}
