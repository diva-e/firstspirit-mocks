package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.UserMock.UserBuilder;
import de.espirit.firstspirit.agency.UserAgent;

import static org.mockito.Mockito.when;

public final class UserAgentMock {

    private UserAgentMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static UserAgentBuilder userAgentWith() {
        return new DefaultUserAgentBuilder();
    }

    public interface UserAgentBuilder extends Builder<UserAgent, UserAgentBuilder> {
        UserAgentBuilder anUser(UserBuilder user);
    }

    public static final class DefaultUserAgentBuilder extends DefaultBuilder<UserAgent, UserAgentBuilder, DefaultUserAgentBuilder> implements UserAgentBuilder {

        private DefaultUserAgentBuilder() {
        }

        @Override
        public final UserAgentBuilder anUser(UserBuilder user) {
            when(getBuildable().getUser()).thenReturn(getBuildable(user));
            return getBuilder();
        }
    }

}
