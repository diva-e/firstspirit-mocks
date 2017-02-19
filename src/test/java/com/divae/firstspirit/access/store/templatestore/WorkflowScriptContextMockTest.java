package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.workflow.model.TransitionMock.TransitionBuilder;
import de.espirit.firstspirit.access.store.templatestore.WorkflowScriptContext;
import de.espirit.firstspirit.workflow.model.Transition;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.templatestore.WorkflowScriptContextMock.workflowScriptContextWith;
import static com.divae.firstspirit.workflow.model.TransitionMock.transitionWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class WorkflowScriptContextMockTest extends MockTest {

	@Test
	public void testWorkflowScriptContextWith() {
		assertThat(workflowScriptContextWith(projectWith("test", 0, languageWith("DE"))), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return WorkflowScriptContextMock.class;
	}

	@Test
	public void testTransitions() {
		WorkflowScriptContext workflowScriptContext = build(workflowScriptContextWith(projectWith("test", 0, languageWith("DE"))).transitions(() -> new TransitionBuilder[]{transitionWith(0L)}));
		Transition[] transitions = workflowScriptContext.getTransitions();
		assertThat(transitions.length, is(1));
		assertThat(transitions[0].getID(), is(0L));
	}

	@Test
	public void testDefaults() {
		WorkflowScriptContext workflowScriptContext = build(workflowScriptContextWith(projectWith("test", 0, languageWith("DE"))));
		assertThat(workflowScriptContext.getTransitions().length, is(0));
	}
}
