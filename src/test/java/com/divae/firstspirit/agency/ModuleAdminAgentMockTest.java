package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.agency.ModuleAdminAgent;
import de.espirit.firstspirit.server.module.ModuleException;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.agency.ModuleAdminAgentMock.moduleAdminAgentWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ModuleAdminAgentMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return ModuleAdminAgentMock.class;
	}

	@Test
	public void testInstall() throws ModuleException, IOException {
		InputStream fsmStream = mock(InputStream.class);
		ModuleAdminAgent moduleAdminAgent = build(moduleAdminAgentWith().install(ModuleResultMock::moduleResultWith, fsmStream, true));
		assertThat(moduleAdminAgent.install(fsmStream, true), is(notNullValue()));
	}
}
