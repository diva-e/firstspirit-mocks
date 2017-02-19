package com.divae.firstspirit.access.packagepool;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.packagepool.PackageVersion;

import static org.mockito.Mockito.when;

public final class PackageVersionMock {

	private PackageVersionMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static PackageVersionBuilder packageVersionWith() {
		return new DefaultPackageVersionBuilder();
	}

	public interface PackageVersionBuilder extends Builder<PackageVersion, PackageVersionBuilder> {
		PackageVersionBuilder aTag(String tag);

		PackageVersionBuilder aComment(String comment);

		PackageVersionBuilder isUpdateVersion(boolean updateVersion);
	}

	public static final class DefaultPackageVersionBuilder extends DefaultBuilder<PackageVersion, PackageVersionBuilder, DefaultPackageVersionBuilder> implements PackageVersionBuilder {

		private DefaultPackageVersionBuilder() {
		}

		@Override
		public final PackageVersionBuilder aTag(String tag) {
			when(getBuildable().getTag()).thenReturn(tag);
			return getBuilder();
		}

		@Override
		public final PackageVersionBuilder aComment(String comment) {
			when(getBuildable().getComment()).thenReturn(comment);
			return getBuilder();
		}

		@Override
		public final PackageVersionBuilder isUpdateVersion(boolean updateVersion) {
			when(getBuildable().isUpdate()).thenReturn(updateVersion);
			return getBuilder();
		}

	}

}
