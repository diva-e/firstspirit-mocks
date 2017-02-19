package com.divae.firstspirit.access.admin;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.UserMock.UserBuilder;
import de.espirit.firstspirit.access.admin.UserStorage;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class UserStorageMock {

	private UserStorageMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static UserStorageBuilder userStorageWith() {
		return new DefaultUserStorageBuilder();
	}

	public interface UserStorageBuilder extends Builder<UserStorage, UserStorageBuilder> {
		UserStorageBuilder users(List<UserBuilder> users, String pattern);
	}

	public static final class DefaultUserStorageBuilder extends DefaultBuilder<UserStorage, UserStorageBuilder, DefaultUserStorageBuilder> implements UserStorageBuilder {

		private DefaultUserStorageBuilder() {
		}

		@Override
		public final UserStorageBuilder users(List<UserBuilder> users, String pattern) {
			when(getBuildable().findUsers(pattern)).thenReturn(users.stream().map(DefaultBuilder::getBuildable).collect(toList()));
			return getBuilder();
		}
	}
}
