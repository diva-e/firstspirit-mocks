package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.agency.OperationTypeMock.OperationTypeBuilder;
import de.espirit.firstspirit.agency.OperationAgent;

import static org.mockito.Mockito.when;

public final class OperationAgentMock {

    private OperationAgentMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static OperationAgentBuilder operationAgentWith() {
        return new DefaultOperationAgentBuilder();
    }

    public interface OperationAgentBuilder extends Builder<OperationAgent, OperationAgentBuilder> {
        <T, TBUILDER extends OperationTypeBuilder<T>> OperationAgentBuilder anOperation(T requestOperation, TBUILDER operationType);
    }

    public static final class DefaultOperationAgentBuilder extends DefaultBuilder<OperationAgent, OperationAgentBuilder, DefaultOperationAgentBuilder> implements OperationAgentBuilder {

        private DefaultOperationAgentBuilder() {
        }

        @Override
        public final <T, TBUILDER extends OperationTypeBuilder<T>> OperationAgentBuilder anOperation(T requestOperation, TBUILDER operationType) {
            when(getBuildable().getOperation(getBuildable(operationType))).thenReturn(requestOperation);
            return getBuilder();
        }

    }
}
