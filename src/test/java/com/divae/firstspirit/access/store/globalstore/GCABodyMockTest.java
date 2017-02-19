package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.MockTest;
import org.junit.Test;

import static com.divae.firstspirit.access.store.globalstore.GCABodyMock.gcaBodyWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GCABodyMockTest extends MockTest {

	@Test
	public void testGcaBodyWith() {
		assertThat(gcaBodyWith("ui", 2, null), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return GCABodyMock.class;
	}

}
