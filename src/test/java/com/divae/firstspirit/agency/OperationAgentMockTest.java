package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.agency.OperationTypeMock.OperationTypeBuilder;
import de.espirit.firstspirit.agency.OperationAgent;
import de.espirit.firstspirit.agency.OperationType;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.agency.OperationAgentMock.operationAgentWith;
import static com.divae.firstspirit.agency.OperationTypeMock.operationTypeWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OperationAgentMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return OperationAgentMock.class;
	}

	@Test
	public void testOperation() {
		Object object = new Object();
		OperationTypeBuilder<Object> operationTypeBuilder = operationTypeWith();
		OperationAgent operationAgent = build(operationAgentWith().anOperation(object, operationTypeBuilder));
		OperationType<Object> operationType = build(operationTypeBuilder);
		assertThat(operationAgent.getOperation(operationType), is(object));
	}
}
