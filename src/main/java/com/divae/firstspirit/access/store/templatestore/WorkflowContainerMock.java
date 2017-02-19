package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.templatestore.WorkflowContainer;

public final class WorkflowContainerMock {

	private WorkflowContainerMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> WorkflowContainerBuilder workflowContainerWith(String name, long id, TBUILDER parent) {
		return new DefaultWorkflowContainerBuilder(name, id, parent);
	}

	public interface WorkflowContainerBuilder extends IDProviderBuilder<WorkflowContainer, WorkflowContainerBuilder> {
	}

	public static final class DefaultWorkflowContainerBuilder extends DefaultIDProviderBuilder<WorkflowContainer, WorkflowContainerBuilder, DefaultWorkflowContainerBuilder> implements WorkflowContainerBuilder {

		private <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> DefaultWorkflowContainerBuilder(String name, long id, TBUILDER parent) {
			super(name, id, parent);
		}
	}
}
