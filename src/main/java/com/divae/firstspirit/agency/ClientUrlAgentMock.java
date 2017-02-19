package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.agency.ClientUrlBuilderMock.ClientUrlBuilderBuilder;
import de.espirit.firstspirit.agency.ClientUrlAgent;
import de.espirit.firstspirit.agency.ClientUrlAgent.ClientType;
import de.espirit.firstspirit.agency.ClientUrlAgent.ClientUrlBuilder;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class ClientUrlAgentMock {

	private ClientUrlAgentMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static ClientUrlAgentBuilder clientUrlAgentWith() {
		return new DefaultClientUrlAgentBuilder();
	}

	public interface ClientUrlAgentBuilder extends Builder<ClientUrlAgent, ClientUrlAgentBuilder> {
		<T extends ClientUrlBuilder<T>, TBUILDER extends ClientUrlBuilderBuilder<T, TBUILDER>> ClientUrlAgentBuilder aBuilder(Supplier<TBUILDER> supplier, ClientType<T> clientType);
	}

	public static final class DefaultClientUrlAgentBuilder extends DefaultBuilder<ClientUrlAgent, ClientUrlAgentBuilder, DefaultClientUrlAgentBuilder> implements ClientUrlAgentBuilder {

		private DefaultClientUrlAgentBuilder() {
		}

		@Override
		public final <T extends ClientUrlBuilder<T>, TBUILDER extends ClientUrlBuilderBuilder<T, TBUILDER>> ClientUrlAgentBuilder aBuilder(Supplier<TBUILDER> supplier, ClientType<T> clientType) {
			T clientUrlBuilder = build(supplier.get());
			when(getBuildable().getBuilder(clientType)).thenReturn(clientUrlBuilder);
			return getBuilder();
		}
	}
}
