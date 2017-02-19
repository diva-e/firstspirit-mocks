package com.divae.firstspirit.access.store.templatestore;


import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.access.GuiScriptContextMock.DefaultGuiScriptContextBuilder;
import com.divae.firstspirit.access.GuiScriptContextMock.GuiScriptContextBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.workflow.model.TransitionMock.TransitionBuilder;
import de.espirit.firstspirit.access.store.templatestore.WorkflowScriptContext;
import de.espirit.firstspirit.workflow.model.Transition;

import java.util.function.Supplier;

import static java.util.stream.Stream.of;
import static org.mockito.Mockito.when;

public final class WorkflowScriptContextMock {

	private WorkflowScriptContextMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static WorkflowScriptContextBuilder workflowScriptContextWith(ProjectBuilder project) {
		return new DefaultWorkflowScriptContextBuilder(project);
	}

	public interface WorkflowScriptContextBuilder extends GuiScriptContextBuilder<WorkflowScriptContext, WorkflowScriptContextBuilder> {
		WorkflowScriptContextBuilder transitions(Supplier<TransitionBuilder[]> supplier);
	}

	public static final class DefaultWorkflowScriptContextBuilder extends DefaultGuiScriptContextBuilder<WorkflowScriptContext, WorkflowScriptContextBuilder, DefaultWorkflowScriptContextBuilder> implements WorkflowScriptContextBuilder {

		private DefaultWorkflowScriptContextBuilder(ProjectBuilder project) {
			super(project);
			withDefaults();
		}

		private void withDefaults() {
			withEmptyTransitions();
		}

		@Override
		public final WorkflowScriptContextBuilder transitions(Supplier<TransitionBuilder[]> supplier) {
			Transition[] transitions = of(supplier.get()).map(BuilderMock::build).toArray(Transition[]::new);
			when(getBuildable().getTransitions()).thenReturn(transitions);
			return getBuilder();
		}

		private void withEmptyTransitions() {
			when(getBuildable().getTransitions()).thenReturn(new Transition[]{});
		}
	}

}
