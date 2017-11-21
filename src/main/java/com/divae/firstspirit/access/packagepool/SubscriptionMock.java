package com.divae.firstspirit.access.packagepool;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import de.espirit.firstspirit.access.packagepool.Subscription;

import static org.mockito.Mockito.when;

public final class SubscriptionMock {

    private SubscriptionMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static SubscriptionBuilder subscriptionWith() {
        return new DefaultSubscriptionBuilder();
    }

    public interface SubscriptionBuilder extends Builder<Subscription, SubscriptionBuilder> {
        SubscriptionBuilder aSubscriber(ProjectBuilder project);
    }

    public static final class DefaultSubscriptionBuilder extends DefaultBuilder<Subscription, SubscriptionBuilder, DefaultSubscriptionBuilder> implements SubscriptionBuilder {

        private DefaultSubscriptionBuilder() {
        }

        @Override
        public final SubscriptionBuilder aSubscriber(ProjectBuilder project) {
            when(getBuildable().getSubscriber()).thenReturn(getBuildable(project));
            return getBuilder();
        }
    }
}
