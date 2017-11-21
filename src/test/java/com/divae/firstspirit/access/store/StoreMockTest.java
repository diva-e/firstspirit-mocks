package com.divae.firstspirit.access.store;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.UserServiceMock.UserServiceBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import de.espirit.firstspirit.access.UserService;
import de.espirit.firstspirit.access.store.Store;
import de.espirit.firstspirit.access.store.Store.Type;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.UserServiceMock.userServiceWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.IDProviderMock.idProviderWith;
import static com.divae.firstspirit.access.store.StoreMock.storeWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.CONTENTSTORE;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.GLOBALSTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class StoreMockTest extends MockTest {

    @Test
    public void testStoreWith() {
        Store store = build(storeWith(1, GLOBALSTORE, Type.GLOBALSTORE, projectWith("test", 0, languageWith("DE"))));
        assertThat(store.getStore(), is(store));
        assertThat(store.getStore().getStore(), is(store));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return StoreMock.class;
    }

    @Test
    public void testAStoreElementStringString() {
        Store store = build(storeWith(1, GLOBALSTORE, Type.GLOBALSTORE, projectWith("test", 0, languageWith("DE"))).aStoreElement(storeStore -> idProviderWith("", 2, GLOBALSTORE, null), "name", "test"));
        assertThat(store.getStoreElement("name", "test").getId(), is(2L));
    }

    @Test
    public void testAnUserService() {
        ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
        UserServiceBuilder userServiceBuilder = userServiceWith(projectBuilder);
        Store store = build(storeWith(1, GLOBALSTORE, Type.GLOBALSTORE, projectBuilder).anUserService(userServiceBuilder));
        UserService userService = build(userServiceBuilder);
        assertThat(store.getUserService(), is(userService));
    }

    @Test
    public void testStoreWithLongUidTypeTypeProject() {
        assertThat(storeWith(1, GLOBALSTORE, Type.GLOBALSTORE, projectWith("test", 0, languageWith("DE"))), is(notNullValue()));
    }

    @Test
    public void testWithUserService() {
        ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
        UserServiceBuilder userServiceBuilder = userServiceWith(projectBuilder);
        UserService userService = build(userServiceBuilder);
        Store store = build(storeWith(1, GLOBALSTORE, Type.GLOBALSTORE, projectBuilder).anUserService(userServiceBuilder));
        assertThat(store.getUserService(), is(userService));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithUserServiceWithDifferentProject() {
        build(storeWith(1, GLOBALSTORE, Type.GLOBALSTORE, projectWith("project2", 1, languageWith("DE"))).anUserService(userServiceWith(projectWith("project1", 0, languageWith("DE")))));
    }

    @Test
    public void testDecorate() {
        assertThat(storeWith(1, CONTENTSTORE, Type.CONTENTSTORE, projectWith("test", 0, languageWith("DE"))), is(notNullValue()));
    }
}
