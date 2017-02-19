package com.divae.firstspirit.agency;


import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.agency.OperationType;

public final class OperationTypeMock {

	private OperationTypeMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T> OperationTypeBuilder<T> operationTypeWith() {
		return new DefaultOperationTypeBuilder<>();
	}

	public interface OperationTypeBuilder<T> extends Builder<OperationType<T>, OperationTypeBuilder<T>> {
	}

	public static final class DefaultOperationTypeBuilder<T> extends DefaultBuilder<OperationType<T>, OperationTypeBuilder<T>, DefaultOperationTypeBuilder<T>> implements OperationTypeBuilder<T> {

		private DefaultOperationTypeBuilder() {
		}
	}
}
