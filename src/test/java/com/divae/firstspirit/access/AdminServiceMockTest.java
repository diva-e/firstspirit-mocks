package com.divae.firstspirit.access;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.admin.UserStorageMock.UserStorageBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.schedule.ScheduleStorageMock.ScheduleStorageBuilder;
import de.espirit.firstspirit.access.AdminService;
import de.espirit.firstspirit.access.Connection;
import de.espirit.firstspirit.access.admin.UserStorage;
import de.espirit.firstspirit.access.schedule.ScheduleStorage;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.AdminServiceMock.adminServiceWith;
import static com.divae.firstspirit.access.ConnectionMock.connectionWith;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.admin.UserStorageMock.userStorageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.schedule.ScheduleStorageMock.scheduleStorageWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class AdminServiceMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return AdminServiceMock.class;
    }


    @Test
    public void testAConnection() {
        Connection connection = build(connectionWith(new ProjectBuilder[]{projectWith("project", 0, languageWith("DE"))}).anAdminService(AdminServiceMock::adminServiceWith));
        AdminService adminService = connection.getService(AdminService.class);
        assertThat(adminService, is(notNullValue()));
        assertThat(adminService.getConnection(), is(connection));
    }

    @Test
    public void testAScheduleStorage() {
        ScheduleStorageBuilder scheduleStorageBuilder = scheduleStorageWith();
        AdminService adminService = build(adminServiceWith().aScheduleStorage(scheduleStorageBuilder));
        ScheduleStorage scheduleStorage = build(scheduleStorageBuilder);
        assertThat(adminService.getScheduleStorage(), is(scheduleStorage));
    }

    @Test
    public void testAnUserStorage() {
        UserStorageBuilder userStorageBuilder = userStorageWith();
        AdminService adminService = build(adminServiceWith().anUserStorage(userStorageBuilder));
        UserStorage userStorage = build(userStorageBuilder);
        assertThat(adminService.getUserStorage(), is(userStorage));
    }
}
