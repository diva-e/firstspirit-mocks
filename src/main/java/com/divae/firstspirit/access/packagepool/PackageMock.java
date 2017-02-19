package com.divae.firstspirit.access.packagepool;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.packagepool.PackageVersionMock.PackageVersionBuilder;
import de.espirit.firstspirit.access.packagepool.Package;
import de.espirit.firstspirit.access.packagepool.PackageVersion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class PackageMock {

	private PackageMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static PackageBuilder fsPackageWith(long id) {
		return new DefaultPackageBuilder(id);
	}

	public interface PackageBuilder extends Builder<Package, PackageBuilder> {
		PackageBuilder versions(Supplier<List<PackageVersionBuilder>> supplier);

		PackageBuilder createsVersion(Supplier<PackageVersionBuilder> supplier);

		PackageBuilder aName(String name);
	}

	public static final class DefaultPackageBuilder extends DefaultBuilder<Package, PackageBuilder, DefaultPackageBuilder> implements PackageBuilder {

		private DefaultPackageBuilder(long id) {
			super(id);
			anId(id);
			versions(ArrayList::new);
		}

		@Override
		public final PackageBuilder versions(Supplier<List<PackageVersionBuilder>> supplier) {
			List<PackageVersion> packageVersion = new ArrayList<>(getBuildable().getVersions());
			packageVersion.addAll(supplier.get().stream().map(BuilderMock::build).collect(toList()));
			when(getBuildable().getVersions()).thenReturn(packageVersion);
			return getBuilder();
		}

		@Override
		public final PackageBuilder createsVersion(Supplier<PackageVersionBuilder> supplier) {
			PackageVersionBuilder packageVersionBuilder = supplier.get();
			versions(() -> singletonList(packageVersionBuilder));
			PackageVersion packageVersion = getBuildable(packageVersionBuilder);
			when(getBuildable().createVersion(packageVersion.getTag(), packageVersion.getComment(), packageVersion.isUpdate())).thenReturn(packageVersion);
			return getBuilder();
		}

		@Override
		public final PackageBuilder aName(String name) {
			when(getBuildable().getName()).thenReturn(name);
			return getBuilder();
		}

		private void anId(long id) {
			when(getBuildable().getId()).thenReturn(id);
		}

	}

}
