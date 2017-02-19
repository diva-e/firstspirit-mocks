package com.divae.firstspirit.access;

import com.divae.firstspirit.access.PrincipalMock.DefaultPrincipalBuilder;
import com.divae.firstspirit.access.PrincipalMock.PrincipalBuilder;
import de.espirit.firstspirit.access.User;

import static org.mockito.Mockito.when;

public final class UserMock {

	private UserMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static UserBuilder userWith(long id) {
		return new DefaultUserBuilder(id);
	}

	public interface UserBuilder extends PrincipalBuilder<User, UserBuilder> {
		UserBuilder aName(String name);

		UserBuilder aLoginName(String loginName);
	}

	public static final class DefaultUserBuilder extends DefaultPrincipalBuilder<User, UserBuilder, DefaultUserBuilder> implements UserBuilder {

		private DefaultUserBuilder(long id) {
			super(id);
		}

		@Override
		public final UserBuilder aName(String name) {
			when(getBuildable().getName()).thenReturn(name);
			return getBuilder();
		}

		@Override
		public final UserBuilder aLoginName(String loginName) {
			when(getBuildable().getLoginName()).thenReturn(loginName);
			return getBuilder();
		}
	}
}
