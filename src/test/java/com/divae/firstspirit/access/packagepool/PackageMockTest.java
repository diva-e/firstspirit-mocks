package com.divae.firstspirit.access.packagepool;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.packagepool.Package;
import de.espirit.firstspirit.access.packagepool.PackageVersion;
import org.junit.Test;

import java.util.List;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.packagepool.PackageMock.fsPackageWith;
import static com.divae.firstspirit.access.packagepool.PackageVersionMock.packageVersionWith;
import static java.lang.Boolean.TRUE;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PackageMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return PackageMock.class;
	}

	@Test
	public void testCreateVersion() {
		String tag = "tag";
		String comment = "comment";
		Package fsPackage = build(fsPackageWith(0L).createsVersion(() -> packageVersionWith().aTag(tag).aComment(comment).isUpdateVersion(true)));
		PackageVersion newPackageVersion = fsPackage.createVersion(tag, comment, true);
		assertThat(newPackageVersion.getTag(), is(tag));
		assertThat(newPackageVersion.getComment(), is(comment));
		assertThat(newPackageVersion.isUpdate(), is(TRUE));
	}

	@Test
	public void testVersions() {
		List<PackageVersion> versions = build(fsPackageWith(0L).versions(() -> singletonList(packageVersionWith()))).getVersions();
		assertThat(versions, is(notNullValue()));
		assertThat(versions.size(), is(1));
	}

	@Test
	public void testAName() {
		String name = "test";
		Package fsPackage = build(fsPackageWith(0L).aName(name));
		assertThat(fsPackage.getName(), is(name));
	}
}
