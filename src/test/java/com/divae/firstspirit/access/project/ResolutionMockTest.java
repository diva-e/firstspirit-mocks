package com.divae.firstspirit.access.project;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.project.Resolution;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.project.ResolutionMock.resolutionWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ResolutionMockTest extends MockTest {

	@Test
	public void testResolutionWith() {
		String uid = "test";
		assertThat(resolutionWith(uid), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return ResolutionMock.class;
	}

	@Test
	public void testDefaults() {
		String uid = "test";
		Resolution resolution = build(resolutionWith(uid));
		assertThat(resolution.getUid(), is(uid));
	}

	@Test
	public void testAHeight() {
		String uid = "test";
		Resolution actual = build(resolutionWith(uid).aHeight(1000));
		assertThat(actual.getHeight(), is(1000));
	}

	@Test
	public void testAWidth() {
		String uid = "test";
		Resolution actual = build(resolutionWith(uid).aWidth(1000));
		assertThat(actual.getWidth(), is(1000));
	}
}
