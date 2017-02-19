package com.divae.firstspirit.access;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.ActionProgress;
import de.espirit.firstspirit.access.ServerActionHandle;
import org.junit.Test;

import java.io.Serializable;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.ServerActionHandleMock.serverActionHandleWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ServerActionHandleMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return ServerActionHandleMock.class;
	}

	@Test
	public void testAProgress() {
		ServerActionHandle<ActionProgress, Serializable> serverActionHandle = build(serverActionHandleWith().aProgress(ActionProgressMock::actionProgressWith, true));
		assertThat(serverActionHandle.getProgress(true), is(notNullValue()));
	}

	@Test
	public void testAResult() throws Exception {
		Serializable serializable = mock(Serializable.class);
		ServerActionHandle<ActionProgress, Serializable> serverActionHandle = build(serverActionHandleWith().aResult(serializable, true));
		assertThat(serverActionHandle.getResult(true), is(serializable));
	}
}
