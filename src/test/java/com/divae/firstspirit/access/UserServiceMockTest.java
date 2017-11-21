package com.divae.firstspirit.access;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.ConnectionMock.ConnectionBuilder;
import com.divae.firstspirit.access.UserServiceMock.UserServiceBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import de.espirit.firstspirit.access.Connection;
import de.espirit.firstspirit.access.UserService;
import de.espirit.firstspirit.access.store.Store;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.ConnectionMock.connectionWith;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.UserServiceMock.userServiceWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.StoreMock.storeWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.MEDIASTORE_FOLDER;
import static de.espirit.firstspirit.access.store.Store.Type.MEDIASTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class UserServiceMockTest extends MockTest {

    @Test
    public void testUserServiceProjectWith() {
        assertThat(userServiceWith(projectWith("project", 0, languageWith("DE"))), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return UserServiceMock.class;
    }

    @Test
    public void testAStoreBooleanStore() {
        ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
        UserServiceBuilder userServiceBuilder = userServiceWith(projectBuilder);
        UserService userService = build(userServiceBuilder.aStore(() -> storeWith(1, MEDIASTORE_FOLDER, MEDIASTORE, projectBuilder), false));
        Store store = userService.getStore(MEDIASTORE, false);
        assertThat(store.getId(), is(1L));
        assertThat(store.getUserService(), is(userService));
    }

    @Test
    public void testAConnectionConnection() {
        ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
        Connection connection = build(connectionWith(new ProjectBuilder[]{projectBuilder}).anUserService(() -> userServiceWith(projectBuilder)));
        UserService userService = connection.getService(UserService.class);
        assertThat(userService, is(notNullValue()));
        assertThat(userService.getConnection(), is(connection));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAConnectionConnectionWithDifferentUserService() {
        ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
        ConnectionBuilder connectionBuilder = connectionWith(new ProjectBuilder[]{projectBuilder}).anUserService(() -> userServiceWith(projectBuilder));
        UserServiceBuilder userServiceBuilder = userServiceWith(projectBuilder);
        build(userServiceBuilder.aConnection(connectionWith(new ProjectBuilder[]{projectBuilder})).aConnection(connectionBuilder));
    }

    @Test
    public void testDefaults() {
        ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
        UserService userService = build(userServiceWith(projectBuilder));
        assertThat(userService.getProject(), is(build(projectBuilder)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithConnectionWithDifferentProjectId() {
        ConnectionBuilder connectionBuilder = connectionWith(new ProjectBuilder[]{projectWith("project", 0, languageWith("DE"))});
        Connection connection = build(connectionBuilder);
        UserService userService = build(userServiceWith(projectWith("test", 1, languageWith("DE"))).aConnection(connectionBuilder));
        assertThat(userService.getConnection(), is(connection));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithConnectionWithDifferentProjectName() {
        ConnectionBuilder connectionBuilder = connectionWith(new ProjectBuilder[]{projectWith("test1", 0, languageWith("DE"))});
        Connection connection = build(connectionBuilder);
        UserService userService = build(userServiceWith(projectWith("test2", 1, languageWith("DE"))).aConnection(connectionBuilder));
        assertThat(userService.getConnection(), is(connection));
    }

    @Test
    public void testWithConnection() {
        ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
        UserServiceBuilder userServiceBuilder = userServiceWith(projectBuilder);
        ConnectionBuilder connectionBuilder = connectionWith(new ProjectBuilder[]{projectBuilder}).anUserService(() -> userServiceBuilder);
        Connection connection = build(connectionBuilder);
        UserService userService = build(userServiceBuilder.aConnection(connectionBuilder));
        assertThat(userService.getConnection(), is(connection));
        assertThat(connection.getService(UserService.class), is(userService));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithConnectionConnectionWithDifferentUserService() {
        ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
        ConnectionBuilder connectionBuilder = connectionWith(new ProjectBuilder[]{projectBuilder});
        build(userServiceWith(projectBuilder).aConnection(connectionBuilder.anUserService(() -> userServiceWith(projectBuilder))));
    }
}
