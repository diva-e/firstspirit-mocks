package com.divae.firstspirit.storage;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.BasicElementInfoMock.BasicElementInfoBuilder;
import de.espirit.firstspirit.access.store.BasicElementInfo;
import de.espirit.firstspirit.storage.ChildrenChangeDetail;
import org.junit.Test;

import java.util.Collections;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.BasicElementInfoMock.basicElementInfoWith;
import static com.divae.firstspirit.storage.ChildrenChangeDetailMock.childrenChangeDetailWith;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ChildrenChangeDetailMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return ChildrenChangeDetailMock.class;
	}

	@Test
	public void testAddedElements() {
		BasicElementInfoBuilder basicElementInfoBuilder = basicElementInfoWith("test");
		ChildrenChangeDetail childrenChangeDetail = build(childrenChangeDetailWith().addedElements(() -> singletonList(basicElementInfoBuilder)));
		BasicElementInfo basicElementInfo = build(basicElementInfoBuilder);
		assertThat(childrenChangeDetail.getAddedElements(), is(singletonList(basicElementInfo)));
	}

	@Test
	public void testRemovedElements() {
		BasicElementInfoBuilder basicElementInfoBuilder = basicElementInfoWith("test");
		ChildrenChangeDetail childrenChangeDetail = build(childrenChangeDetailWith().removedElements(() -> singletonList(basicElementInfoBuilder)));
		BasicElementInfo removedElementInfo = build(basicElementInfoBuilder);
		assertThat(childrenChangeDetail.getRemovedElements(), is(singletonList(removedElementInfo)));
	}

	@Test
	public void testReorderedElements() {
		ChildrenChangeDetail childrenChangeDetail = build(childrenChangeDetailWith().reorderedElements(Collections::emptyMap));
		assertThat(childrenChangeDetail.getReorderedElements(), is(notNullValue()));
	}
}
