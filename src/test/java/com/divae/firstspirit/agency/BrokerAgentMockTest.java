package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.agency.BrokerAgent;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.agency.BrokerAgentMock.brokerAgentWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class BrokerAgentMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return BrokerAgentMock.class;
	}

	@Test
	public void testABrokerByProjectName() {
		String projectName = "projectName";
		BrokerAgent brokerAgent = build(brokerAgentWith().aBrokerByProjectName(SpecialistsBrokerMock::specialistsBrokerWith, projectName));
		assertThat(brokerAgent.getBrokerByProjectName(projectName), is(notNullValue()));
	}
}
