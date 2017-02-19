package com.divae.firstspirit.access;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.ConnectionMock.ConnectionBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.store.StoreMock.StoreBuilder;
import de.espirit.firstspirit.access.Connection;
import de.espirit.firstspirit.access.UserService;
import de.espirit.firstspirit.access.store.Store;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class UserServiceMock {

	private UserServiceMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static UserServiceBuilder userServiceWith(ProjectBuilder projectBuilder) {
		return new DefaultUserServiceBuilder(projectBuilder);
	}

	public interface UserServiceBuilder extends Builder<UserService, UserServiceBuilder> {
		<T extends Store, TBUILDER extends StoreBuilder<T, TBUILDER>> UserServiceBuilder aStore(Supplier<TBUILDER> supplier, boolean releaseOnly);

		UserServiceBuilder aConnection(ConnectionBuilder connection);
	}

	public static final class DefaultUserServiceBuilder extends DefaultBuilder<UserService, UserServiceBuilder, DefaultUserServiceBuilder> implements UserServiceBuilder {

		private DefaultUserServiceBuilder(ProjectBuilder projectBuilder) {
			when(getBuildable().getProject()).thenReturn(getBuildable(projectBuilder));
		}

		@Override
		public final <T extends Store, TBUILDER extends StoreBuilder<T, TBUILDER>> UserServiceBuilder aStore(Supplier<TBUILDER> supplier, boolean releaseOnly) {
			Store store = build(supplier.get().anUserService(getBuilder()));
			when(getBuildable().getStore(store.getType(), releaseOnly)).thenReturn(store);
			return getBuilder();
		}

		@Override
		public final UserServiceBuilder aConnection(ConnectionBuilder connection) {
			Connection buildable = getBuildable(connection);
			if (!getBuildable().equals(buildable.getService(UserService.class))) {
				throw new IllegalArgumentException("Connection has not this user service. Please correct this.");
			}

			when(getBuildable().getConnection()).thenReturn(buildable);
			return getBuilder();
		}
	}
}
