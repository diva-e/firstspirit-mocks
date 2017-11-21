package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import org.junit.Test;

import static com.divae.firstspirit.access.store.templatestore.WorkflowContainerMock.workflowContainerWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class WorkflowContainerMockTest extends MockTest {

    @Test
    public void testWorkflowContainerWith() {
        assertThat(workflowContainerWith("test", 2, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return WorkflowContainerMock.class;
    }

}
