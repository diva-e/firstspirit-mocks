package com.divae.firstspirit.access;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.AdminServiceMock.AdminServiceBuilder;
import com.divae.firstspirit.access.AdminServiceMock.DefaultAdminServiceBuilder;
import com.divae.firstspirit.access.MessageServiceMock.MessageServiceBuilder;
import com.divae.firstspirit.access.UserMock.UserBuilder;
import com.divae.firstspirit.access.UserServiceMock.UserServiceBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.agency.SpecialistsBrokerMock.SpecialistsBrokerBuilder;
import de.espirit.firstspirit.access.AdminService;
import de.espirit.firstspirit.access.Connection;
import de.espirit.firstspirit.access.MessageService;
import de.espirit.firstspirit.access.UserService;
import de.espirit.firstspirit.access.project.Project;
import de.espirit.firstspirit.agency.SpecialistsBroker;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static java.util.stream.Stream.of;
import static org.mockito.Mockito.when;

public final class ConnectionMock {

	private ConnectionMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static ConnectionBuilder connectionWith(ProjectBuilder[] projects) {
		return new DefaultConnectionBuilder(projects);
	}

	public interface ConnectionBuilder extends Builder<Connection, ConnectionBuilder> {
		ConnectionBuilder aMessageService(Supplier<MessageServiceBuilder> supplier);

		ConnectionBuilder anAdminService(Supplier<AdminServiceBuilder> supplier);

		ConnectionBuilder anUserService(Supplier<UserServiceBuilder> supplier);

		ConnectionBuilder anUser(UserBuilder user);

		<T extends SpecialistsBroker, TBUILDER extends SpecialistsBrokerBuilder<T, TBUILDER>> ConnectionBuilder aBroker(TBUILDER specialistsBroker);
	}

	public static final class DefaultConnectionBuilder extends DefaultBuilder<Connection, ConnectionBuilder, DefaultConnectionBuilder> implements ConnectionBuilder {

		private DefaultConnectionBuilder(ProjectBuilder[] projects) {
			withProjects(projects);
		}

		@Override
		public final ConnectionBuilder aMessageService(Supplier<MessageServiceBuilder> supplier) {
			return aService(supplier.get(), MessageService.class);
		}

		@Override
		public final ConnectionBuilder anAdminService(Supplier<AdminServiceBuilder> supplier) {
			return aService(((DefaultAdminServiceBuilder) getBuilder(supplier.get())).aConnection(getBuilder()), AdminService.class);
		}

		@Override
		public final ConnectionBuilder anUserService(Supplier<UserServiceBuilder> supplier) {
			UserServiceBuilder userServiceBuilder = supplier.get();
			ConnectionBuilder connectionBuilder = aService(userServiceBuilder, UserService.class);
			userServiceBuilder.aConnection(getBuilder());
			return connectionBuilder;
		}

		private <T, TBUILDER extends Builder<T, TBUILDER>> ConnectionBuilder aService(TBUILDER service, Class<T> clazz) {
			when(getBuildable().getService(clazz)).thenReturn(build(service));
			return getBuilder();
		}

		@Override
		public final ConnectionBuilder anUser(UserBuilder user) {
			when(getBuildable().getUser()).thenReturn(getBuildable(user));
			return getBuilder();
		}

		@Override
		public final <T extends SpecialistsBroker, TBUILDER extends SpecialistsBrokerBuilder<T, TBUILDER>> ConnectionBuilder aBroker(TBUILDER specialistsBroker) {
			when(getBuildable().getBroker()).thenReturn(getBuildable(specialistsBroker));
			return getBuilder();
		}

		private void withProjects(ProjectBuilder[] projectBuilders) {
			Project[] projects = of(projectBuilders).map(BuilderMock::build).toArray(Project[]::new);
			for (Project project : projects) {
				if (getBuildable().getProjectByName(project.getName()) != null) {
					throw new IllegalArgumentException("Project with name [" + project.getName() + "] is already set. Please choose another value.");
				}

				if (getBuildable().getProjectById(project.getId()) != null) {
					throw new IllegalArgumentException("Project with id [" + project.getId() + "] is already set. Please choose another value.");
				}

				when(getBuildable().getProjectByName(project.getName())).thenReturn(project);
				when(getBuildable().getProjectById(project.getId())).thenReturn(project);
			}
			when(getBuildable().getProjects()).thenReturn(projects);
		}
	}
}
