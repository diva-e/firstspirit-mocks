package com.divae.firstspirit.access.admin;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.User;
import de.espirit.firstspirit.access.admin.UserStorage;
import org.junit.Test;

import java.util.List;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.UserMock.userWith;
import static com.divae.firstspirit.access.admin.UserStorageMock.userStorageWith;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserStorageMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return UserStorageMock.class;
	}

	@Test
	public void testUsers() {
		UserStorage userStorage = build(userStorageWith().users(singletonList(userWith(0L)), "test"));
		List<User> users = userStorage.findUsers("test");
		assertThat(users.size(), is(1));
		assertThat(users.get(0).getId(), is(0L));
	}
}
