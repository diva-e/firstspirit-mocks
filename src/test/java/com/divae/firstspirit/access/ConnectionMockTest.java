package com.divae.firstspirit.access;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.ConnectionMock.ConnectionBuilder;
import com.divae.firstspirit.access.UserServiceMock.UserServiceBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import de.espirit.firstspirit.access.AdminService;
import de.espirit.firstspirit.access.Connection;
import de.espirit.firstspirit.access.MessageService;
import de.espirit.firstspirit.access.UserService;
import de.espirit.firstspirit.access.project.Project;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.ConnectionMock.connectionWith;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.UserMock.userWith;
import static com.divae.firstspirit.access.UserServiceMock.userServiceWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.agency.SpecialistsBrokerMock.specialistsBrokerWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ConnectionMockTest extends MockTest {

	@Test
	public void testConnectionWith() {
		assertThat(connectionWith(new ProjectBuilder[]{projectWith("project", 0, languageWith("DE"))}), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return ConnectionMock.class;
	}

	@Test
	public void testAMessageServiceMessageService() {
		Connection connection = build(connectionWith(new ProjectBuilder[]{projectWith("project", 0, languageWith("DE"))}).aMessageService(MessageServiceMock::messageServiceWith));
		assertThat(connection.getService(MessageService.class), is(notNullValue()));
	}

	@Test
	public void testAnAdminServiceAdminService() {
		Connection connection = build(connectionWith(new ProjectBuilder[]{projectWith("project", 0, languageWith("DE"))}).anAdminService(AdminServiceMock::adminServiceWith));
		assertThat(connection.getService(AdminService.class).getConnection(), is(connection));
	}

	@Test
	public void testAnUserServiceUserService() {
		ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
		UserServiceBuilder userServiceBuilder = userServiceWith(projectBuilder);
		ConnectionBuilder connectionBuilder = connectionWith(new ProjectBuilder[]{projectBuilder});
		Connection connection = build(connectionBuilder.anUserService(() -> userServiceBuilder));
		UserService userService = build(userServiceBuilder.aConnection(connectionBuilder));
		assertThat(connection.getService(UserService.class), is(userService));
	}

	@Test
	public void testAnUser() {
		Connection connection = build(connectionWith(new ProjectBuilder[]{projectWith("project", 0, languageWith("DE"))}).anUser(userWith(0L)));
		assertThat(connection.getUser(), is(notNullValue()));
	}

	@Test
	public void testWithProject() {
		ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
		Project project = build(projectBuilder);
		Connection connection = build(connectionWith(new ProjectBuilder[]{projectBuilder}));
		assertThat(connection.getProjectByName(project.getName()), is(project));
		assertThat(connection.getProjectById(project.getId()), is(project));
		assertThat(connection.getProjects().length, is(1));
		assertThat(connection.getProjects()[0], is(project));
	}

	@Test
	public void testWithMultipleProjects() {
		ProjectBuilder projectBuilder1 = projectWith("project1", 1, languageWith("DE"));
		Project project1 = build(projectBuilder1);
		ProjectBuilder projectBuilder2 = projectWith("project2", 2, languageWith("DE"));
		Project project2 = build(projectBuilder2);
		Connection connection = build(connectionWith(new ProjectBuilder[]{projectBuilder1, projectBuilder2}));
		assertThat(connection.getProjects().length, is(2));
		assertThat(connection.getProjects()[0], is(project1));
		assertThat(connection.getProjects()[1], is(project2));
	}

	@Test
	public void testABroker() {
		Connection connection = build(connectionWith(new ProjectBuilder[]{projectWith("project", 0, languageWith("DE"))}).aBroker(specialistsBrokerWith()));
		assertThat(connection.getBroker(), is(notNullValue()));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWithMultipleProjectsWithSameName() {
		connectionWith(new ProjectBuilder[]{projectWith("project", 1, languageWith("DE")), projectWith("project", 2, languageWith("DE"))});
	}

	@Test
	public void testWithAdminServiceTBUILDER() {
		Connection connection = build(connectionWith(new ProjectBuilder[]{projectWith("project", 0, languageWith("DE"))}).anAdminService(AdminServiceMock::adminServiceWith));
		AdminService adminService = connection.getService(AdminService.class);
		assertThat(adminService, is(notNullValue()));
		assertThat(adminService.getConnection(), is(connection));
	}

	@Test
	public void testWithUserServiceTBUILDER() {
		ProjectBuilder projectBuilder = projectWith("project", 0, languageWith("DE"));
		ConnectionBuilder connectionBuilder = connectionWith(new ProjectBuilder[]{projectBuilder});
		UserServiceBuilder userServiceBuilder = userServiceWith(projectBuilder);
		Connection connection = build(connectionBuilder.anUserService(() -> userServiceBuilder));
		UserService userService = build(userServiceBuilder.aConnection(connectionBuilder));
		assertThat(connection.getService(UserService.class), is(userService));
		assertThat(userService.getConnection(), is(connection));
	}
}
