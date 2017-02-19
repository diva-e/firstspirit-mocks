package com.divae.firstspirit.ui.operations;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.ui.operations.RequestOperation;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.ui.operations.RequestOperationMock.requestOperationWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class RequestOperationMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return RequestOperationMock.class;
	}

	@Test
	public void testOk() {
		RequestOperation requestOperation = build(requestOperationWith().ok(AnswerMock::answerWith));
		assertThat(requestOperation.addOk(), is(notNullValue()));
	}

	@Test
	public void testPerforms() {
		RequestOperation requestOperation = build(requestOperationWith().performs(AnswerMock::answerWith, "test"));
		assertThat(requestOperation.perform("test"), is(notNullValue()));
	}
}
