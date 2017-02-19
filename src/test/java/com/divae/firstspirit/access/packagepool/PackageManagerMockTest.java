package com.divae.firstspirit.access.packagepool;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.packagepool.Package;
import de.espirit.firstspirit.access.packagepool.PackageManager;
import de.espirit.firstspirit.access.packagepool.PublishGroup;
import de.espirit.firstspirit.access.packagepool.Subscription;
import org.junit.Test;

import java.util.Collection;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.packagepool.PackageManagerMock.packageManagerWith;
import static com.divae.firstspirit.access.packagepool.PackageMock.fsPackageWith;
import static com.divae.firstspirit.access.packagepool.PublishGroupMock.publishGroupWith;
import static com.divae.firstspirit.access.packagepool.SubscriptionMock.subscriptionWith;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PackageManagerMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return PackageManagerMock.class;
	}

	@Test
	public void testPackages() {
		String packageName = "test";
		PackageManager packageManager = build(packageManagerWith().packages(() -> singletonList(fsPackageWith(0L).aName(packageName))));
		Collection<de.espirit.firstspirit.access.packagepool.Package> fsPackages = packageManager.getPackages();
		assertThat(fsPackages.size(), is(1));
		Package fsPackage = fsPackages.iterator().next();
		assertThat(fsPackage.getId(), is(0L));
		assertThat(fsPackage.getName(), is("test"));
	}

	@Test
	public void testPublishGroups() {
		PackageManager packageManager = build(packageManagerWith().publishGroups(() -> singletonList(publishGroupWith(0L).aName("test"))));
		Collection<PublishGroup> publishGroups = packageManager.getPublishGroups();
		assertThat(publishGroups.size(), is(1));
		assertThat(publishGroups.iterator().next().getId(), is(0L));
	}

	@Test
	public void testSubscriptions() {
		PackageManager packageManager = build(packageManagerWith().subscriptions(singletonList(subscriptionWith())));
		Collection<Subscription> subscriptions = packageManager.getSubscriptions();
		assertThat(subscriptions.size(), is(1));
		assertThat(subscriptions.iterator().next(), is(notNullValue()));
	}
}
