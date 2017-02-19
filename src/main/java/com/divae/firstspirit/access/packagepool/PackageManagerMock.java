package com.divae.firstspirit.access.packagepool;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.packagepool.PackageMock.PackageBuilder;
import com.divae.firstspirit.access.packagepool.PublishGroupMock.PublishGroupBuilder;
import com.divae.firstspirit.access.packagepool.SubscriptionMock.SubscriptionBuilder;
import de.espirit.firstspirit.access.packagepool.Package;
import de.espirit.firstspirit.access.packagepool.PackageManager;
import de.espirit.firstspirit.access.packagepool.PublishGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class PackageManagerMock {

	private PackageManagerMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static PackageManagerBuilder packageManagerWith() {
		return new DefaultPackageManagerBuilder();
	}

	public interface PackageManagerBuilder extends Builder<PackageManager, PackageManagerBuilder> {
		PackageManagerBuilder packages(Supplier<List<PackageBuilder>> supplier);

		PackageManagerBuilder publishGroups(Supplier<List<PublishGroupBuilder>> supplier);

		PackageManagerBuilder subscriptions(List<SubscriptionBuilder> subscriptions);
	}

	public static final class DefaultPackageManagerBuilder extends DefaultBuilder<PackageManager, PackageManagerBuilder, DefaultPackageManagerBuilder> implements PackageManagerBuilder {

		private DefaultPackageManagerBuilder() {
			publishGroups(ArrayList::new);
			packages(ArrayList::new);
			subscriptions(new ArrayList<>());
		}

		@Override
		public final PackageManagerBuilder packages(Supplier<List<PackageBuilder>> supplier) {
			List<Package> packages = new ArrayList<>(getBuildable().getPackages());
			packages.addAll(supplier.get().stream().map(BuilderMock::build).collect(toList()));
			when(getBuildable().getPackages()).thenReturn(packages);
			return getBuilder();
		}

		@Override
		public final PackageManagerBuilder publishGroups(Supplier<List<PublishGroupBuilder>> supplier) {
			List<PublishGroup> publishGroups = new ArrayList<>(getBuildable().getPublishGroups());
			publishGroups.addAll(supplier.get().stream().map(BuilderMock::build).collect(toList()));
			when(getBuildable().getPublishGroups()).thenReturn(publishGroups);
			return getBuilder();
		}

		@Override
		public final PackageManagerBuilder subscriptions(List<SubscriptionBuilder> subscriptions) {
			when(getBuildable().getSubscriptions()).thenReturn(subscriptions.stream().map(DefaultBuilder::getBuildable).collect(toList()));
			return getBuilder();
		}
	}

}
