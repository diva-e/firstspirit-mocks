package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.GlobalStoreRootBuilder;
import de.espirit.firstspirit.access.store.globalstore.URLProperties;

import static org.mockito.Mockito.when;

public final class URLPropertiesMock {

    private URLPropertiesMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static URLPropertiesBuilder urlPropertiesWith(String name, long id, GlobalStoreRootBuilder parent) {
        return new DefaultURLPropertiesBuilder(name, id, parent);
    }

    public interface URLPropertiesBuilder extends IDProviderBuilder<URLProperties, URLPropertiesBuilder> {
        URLPropertiesBuilder isLocked(boolean lock);
    }

    public static final class DefaultURLPropertiesBuilder extends DefaultIDProviderBuilder<URLProperties, URLPropertiesBuilder, DefaultURLPropertiesBuilder> implements URLPropertiesBuilder {

        private DefaultURLPropertiesBuilder(String name, long id, GlobalStoreRootBuilder parent) {
            super(name, id, parent);
        }

        @Override
        public final URLPropertiesBuilder isLocked(boolean lock) {
            when(getBuildable().isLocked()).thenReturn(lock);
            return getBuilder();
        }
    }
}
