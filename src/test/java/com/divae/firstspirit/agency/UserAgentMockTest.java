package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.UserMock.UserBuilder;
import de.espirit.firstspirit.access.User;
import de.espirit.firstspirit.agency.UserAgent;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.UserMock.userWith;
import static com.divae.firstspirit.agency.UserAgentMock.userAgentWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserAgentMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return UserAgentMock.class;
    }

    @Test
    public void testAnUser() {
        UserBuilder userBuilder = userWith(0L);
        UserAgent userAgent = build(userAgentWith().anUser(userBuilder));
        User user = build(userBuilder);
        assertThat(userAgent.getUser(), is(user));
    }

}
