package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.agency.ClientUrlAgent;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.agency.ClientUrlAgentMock.clientUrlAgentWith;
import static de.espirit.firstspirit.agency.ClientUrlAgent.ClientType.WEBEDIT;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ClientUrlAgentMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return ClientUrlAgentMock.class;
	}

	@Test
	public void testABuilder() {
		ClientUrlAgent clientUrlAgent = build(clientUrlAgentWith().aBuilder(WebeditUrlBuilderMock::webeditUrlBuilderWith, WEBEDIT));
		assertThat(clientUrlAgent.getBuilder(WEBEDIT), is(notNullValue()));
	}
}
