package com.divae.firstspirit.access.packagepool;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.packagepool.Subscription;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.packagepool.SubscriptionMock.subscriptionWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SubscriptionMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return SubscriptionMock.class;
    }

    @Test
    public void testASubscriber() {
        String subscriberName = "test";
        Subscription subscription = build(subscriptionWith().aSubscriber(projectWith(subscriberName, 0, languageWith("DE"))));
        assertThat(subscription.getSubscriber().getName(), is(subscriberName));
    }
}
