package com.divae.firstspirit.workflow.model;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.workflow.model.Transition;

import static org.mockito.Mockito.when;

public final class TransitionMock {

	private TransitionMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static TransitionBuilder transitionWith(long id) {
		return new DefaultTransitionBuilder(id);
	}

	public interface TransitionBuilder extends Builder<Transition, TransitionBuilder> {
	}

	public static final class DefaultTransitionBuilder extends DefaultBuilder<Transition, TransitionBuilder, DefaultTransitionBuilder> implements TransitionBuilder {

		private DefaultTransitionBuilder(long id) {
			super(id);
			anId(id);
		}

		private void anId(long id) {
			when(getBuildable().getID()).thenReturn(id);
		}
	}

}
