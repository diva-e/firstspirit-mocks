package com.divae.firstspirit.access.template;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.template.Evaluator;

public final class EvaluatorMock {

	private EvaluatorMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static EvaluatorBuilder evaluatorWith() {
		return new DefaultEvaluatorBuilder();
	}

	public interface EvaluatorBuilder extends Builder<Evaluator, EvaluatorBuilder> {
	}

	public static final class DefaultEvaluatorBuilder extends DefaultBuilder<Evaluator, EvaluatorBuilder, DefaultEvaluatorBuilder> implements EvaluatorBuilder {

		private DefaultEvaluatorBuilder() {
		}
	}
}
