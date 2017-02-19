package com.divae.firstspirit.access.store;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.store.Permission;

import static org.mockito.Mockito.when;

public final class PermissionMock {

	private PermissionMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static PermissionBuilder permissionWith() {
		return new DefaultPermissionBuilder();
	}

	public interface PermissionBuilder extends Builder<Permission, PermissionBuilder> {
		PermissionBuilder aSeePermission(boolean canSee);

		PermissionBuilder aReadPermission(boolean canRead);

		PermissionBuilder aReleasePermission(boolean canRelease);
	}

	public static final class DefaultPermissionBuilder extends DefaultBuilder<Permission, PermissionBuilder, DefaultPermissionBuilder> implements PermissionBuilder {

		private DefaultPermissionBuilder() {
		}

		@Override
		public final PermissionBuilder aSeePermission(boolean canSee) {
			when(getBuildable().canSee()).thenReturn(canSee);
			return getBuilder();
		}

		@Override
		public final PermissionBuilder aReadPermission(boolean canRead) {
			when(getBuildable().canRead()).thenReturn(canRead);
			return getBuilder();
		}

		@Override
		public final PermissionBuilder aReleasePermission(boolean canRelease) {
			when(getBuildable().canRelease()).thenReturn(canRelease);
			return getBuilder();
		}
	}
}
