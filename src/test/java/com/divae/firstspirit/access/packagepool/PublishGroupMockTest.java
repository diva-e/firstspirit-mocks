package com.divae.firstspirit.access.packagepool;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.packagepool.PublishGroup;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.packagepool.PublishGroupMock.publishGroupWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PublishGroupMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return PublishGroupMock.class;
	}

	@Test
	public void testAName() {
		String name = "test";
		PublishGroup publishGroup = build(publishGroupWith(0L).aName(name));
		assertThat(publishGroup.getName(), is(name));
	}
}
