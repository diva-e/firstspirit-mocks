package com.divae.firstspirit.ui.operations;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.ui.operations.AnswerMock.AnswerBuilder;
import de.espirit.firstspirit.ui.operations.RequestOperation;
import de.espirit.firstspirit.ui.operations.RequestOperation.Answer;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class RequestOperationMock {

	private RequestOperationMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static RequestOperationBuilder requestOperationWith() {
		return new DefaultRequestOperationBuilder();
	}

	public interface RequestOperationBuilder extends Builder<RequestOperation, RequestOperationBuilder> {
		RequestOperationBuilder ok(Supplier<AnswerBuilder> supplier);

		RequestOperationBuilder performs(Supplier<AnswerBuilder> supplier, String question);
	}

	public static final class DefaultRequestOperationBuilder extends DefaultBuilder<RequestOperation, RequestOperationBuilder, DefaultRequestOperationBuilder> implements RequestOperationBuilder {

		private DefaultRequestOperationBuilder() {
		}

		@Override
		public final RequestOperationBuilder ok(Supplier<AnswerBuilder> supplier) {
			Answer answer = build(supplier.get());
			when(getBuildable().addOk()).thenReturn(answer);
			return getBuilder();
		}

		@Override
		public final RequestOperationBuilder performs(Supplier<AnswerBuilder> supplier, String question) {
			Answer answer = build(supplier.get());
			when(getBuildable().perform(question)).thenReturn(answer);
			return getBuilder();
		}

	}
}
