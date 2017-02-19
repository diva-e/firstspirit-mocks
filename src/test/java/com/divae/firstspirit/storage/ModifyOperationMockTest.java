package com.divae.firstspirit.storage;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.BasicElementInfoMock.BasicElementInfoBuilder;
import de.espirit.firstspirit.access.store.BasicElementInfo;
import de.espirit.firstspirit.storage.ModifyOperation;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.BasicElementInfoMock.basicElementInfoWith;
import static com.divae.firstspirit.storage.ModifyOperationMock.modifyOperationWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ModifyOperationMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return ModifyOperationMock.class;
	}

	@Test
	public void testAModificationRootElement() {
		BasicElementInfoBuilder elementInfoBuilder = basicElementInfoWith("test");
		ModifyOperation modifyOperation = build(modifyOperationWith().aModificationRootElement(() -> elementInfoBuilder));
		BasicElementInfo basicElementInfo = build(elementInfoBuilder);
		assertThat(modifyOperation.getModificationRootElement(), is(basicElementInfo));
	}
}
