package com.divae.firstspirit.access;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.User;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.UserMock.userWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return UserMock.class;
	}

	@Test
	public void testAName() {
		User user = build(userWith(0L).aName("name"));
		assertThat(user.getName(), is("name"));
	}


	@Test
	public void testALoginName() {
		User user = build(userWith(0L).aLoginName("test"));
		assertThat(user.getLoginName(), is("test"));
	}
}
