package com.divae.firstspirit.access.packagepool;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.packagepool.PackageVersion;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.packagepool.PackageVersionMock.packageVersionWith;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PackageVersionMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return PackageVersionMock.class;
	}

	@Test
	public void testATag() {
		String tag = "test";
		PackageVersion packageVersion = build(packageVersionWith().aTag(tag));
		assertThat(packageVersion.getTag(), is(tag));
	}

	@Test
	public void testAComment() {
		String comment = "test";
		PackageVersion packageVersion = build(packageVersionWith().aComment(comment));
		assertThat(packageVersion.getComment(), is(comment));
	}

	@Test
	public void testIsUpdateVersion() {
		PackageVersion packageVersion = build(packageVersionWith().isUpdateVersion(true));
		assertThat(packageVersion.isUpdate(), is(TRUE));
	}
}
