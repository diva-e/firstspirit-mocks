package com.divae.firstspirit.storage;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.BasicElementInfoMock.BasicElementInfoBuilder;
import de.espirit.firstspirit.access.store.BasicElementInfo;
import de.espirit.firstspirit.storage.CreateOperation;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.BasicElementInfoMock.basicElementInfoWith;
import static com.divae.firstspirit.storage.CreateOperationMock.createOperationWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CreateOperationMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return CreateOperationMock.class;
	}

	@Test
	public void testCreatedElement() {
		BasicElementInfoBuilder basicElementInfoBuilder = basicElementInfoWith("test");
		CreateOperation createOperation = build(createOperationWith().createdElement(() -> basicElementInfoBuilder));
		BasicElementInfo basicElementInfo = build(basicElementInfoBuilder);
		assertThat(createOperation.getCreatedElement(), is(basicElementInfo));
	}
}
