package com.divae.firstspirit.access;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.ConnectionMock.ConnectionBuilder;
import com.divae.firstspirit.access.admin.UserStorageMock.UserStorageBuilder;
import com.divae.firstspirit.access.schedule.ScheduleStorageMock.ScheduleStorageBuilder;
import de.espirit.firstspirit.access.AdminService;

import static org.mockito.Mockito.when;

public final class AdminServiceMock {

	private AdminServiceMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static AdminServiceBuilder adminServiceWith() {
		return new DefaultAdminServiceBuilder();
	}

	public interface AdminServiceBuilder extends Builder<AdminService, AdminServiceBuilder> {
		AdminServiceBuilder aScheduleStorage(ScheduleStorageBuilder scheduleStorage);

		AdminServiceBuilder anUserStorage(UserStorageBuilder userStorage);
	}

	public static final class DefaultAdminServiceBuilder extends DefaultBuilder<AdminService, AdminServiceBuilder, DefaultAdminServiceBuilder> implements AdminServiceBuilder {

		private DefaultAdminServiceBuilder() {
		}

		@Override
		public final AdminServiceBuilder aScheduleStorage(ScheduleStorageBuilder scheduleStorage) {
			when(getBuildable().getScheduleStorage()).thenReturn(getBuildable(scheduleStorage));
			return getBuilder();
		}

		protected final AdminServiceBuilder aConnection(ConnectionBuilder connection) {
			when(getBuildable().getConnection()).thenReturn(getBuildable(connection));
			return getBuilder();
		}

		@Override
		public final AdminServiceBuilder anUserStorage(UserStorageBuilder userStorage) {
			when(getBuildable().getUserStorage()).thenReturn(getBuildable(userStorage));
			return getBuilder();
		}
	}

}
