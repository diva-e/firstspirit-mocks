package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.store.StoreMock.DefaultStoreBuilder;
import com.divae.firstspirit.access.store.StoreMock.StoreBuilder;
import com.divae.firstspirit.access.store.globalstore.ProjectPropertiesMock.ProjectPropertiesBuilder;
import de.espirit.firstspirit.access.store.Store.Type;
import de.espirit.firstspirit.access.store.globalstore.GlobalStoreRoot;
import de.espirit.firstspirit.access.store.globalstore.ProjectProperties;

import java.util.function.Function;

import static com.divae.firstspirit.BuilderMock.build;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.GLOBALSTORE;
import static org.mockito.Mockito.when;


public final class GlobalStoreRootMock {

    private GlobalStoreRootMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static GlobalStoreRootBuilder globalStoreRootWith(long id, ProjectBuilder project) {
        return new DefaultGlobalStoreRootBuilder(id, project);
    }

    public interface GlobalStoreRootBuilder extends StoreBuilder<GlobalStoreRoot, GlobalStoreRootBuilder> {
        GlobalStoreRootBuilder projectProperties(Function<GlobalStoreRootBuilder, ProjectPropertiesBuilder> function);
    }

    public static final class DefaultGlobalStoreRootBuilder extends DefaultStoreBuilder<GlobalStoreRoot, GlobalStoreRootBuilder, DefaultGlobalStoreRootBuilder> implements GlobalStoreRootBuilder {

        private DefaultGlobalStoreRootBuilder(long id, ProjectBuilder project) {
            super(id, GLOBALSTORE, Type.GLOBALSTORE, project);
        }

        @Override
        public final GlobalStoreRootBuilder projectProperties(Function<GlobalStoreRootBuilder, ProjectPropertiesBuilder> function) {
            ProjectProperties projectProperties = build(function.apply(getBuilder()));
            when(getBuildable().getProjectProperties()).thenReturn(projectProperties);
            return getBuilder();
        }
    }
}
