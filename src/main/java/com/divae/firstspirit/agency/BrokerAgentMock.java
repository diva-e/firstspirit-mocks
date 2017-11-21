package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.agency.SpecialistsBrokerMock.SpecialistsBrokerBuilder;
import de.espirit.firstspirit.agency.BrokerAgent;
import de.espirit.firstspirit.agency.SpecialistsBroker;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class BrokerAgentMock {

    private BrokerAgentMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static BrokerAgentBuilder brokerAgentWith() {
        return new DefaultBrokerAgentBuilder();
    }

    public interface BrokerAgentBuilder extends Builder<BrokerAgent, BrokerAgentBuilder> {
        <T extends SpecialistsBroker, TBUILDER extends SpecialistsBrokerBuilder<T, TBUILDER>> BrokerAgentBuilder aBrokerByProjectName(Supplier<TBUILDER> supplier, String projectName);
    }

    public static final class DefaultBrokerAgentBuilder extends DefaultBuilder<BrokerAgent, BrokerAgentBuilder, DefaultBrokerAgentBuilder> implements BrokerAgentBuilder {

        private DefaultBrokerAgentBuilder() {
        }

        @Override
        public final <T extends SpecialistsBroker, TBUILDER extends SpecialistsBrokerBuilder<T, TBUILDER>> BrokerAgentBuilder aBrokerByProjectName(Supplier<TBUILDER> supplier, String projectName) {
            T specialistsBroker = build(supplier.get());
            when(getBuildable().getBrokerByProjectName(projectName)).thenReturn(specialistsBroker);
            return getBuilder();
        }
    }
}
