package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.generate.path.IDProviderKeyMock.IDProviderKeyBuilder;
import de.espirit.firstspirit.agency.UrlRegistryAgent;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class UrlRegistryAgentMock {

	private UrlRegistryAgentMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static UrlRegistryAgentBuilder urlRegistryAgentWith() {
		return new DefaultUrlRegistryAgentBuilder();
	}

	public interface UrlRegistryAgentBuilder extends Builder<UrlRegistryAgent, UrlRegistryAgentBuilder> {
		UrlRegistryAgentBuilder entries(List<IDProviderKeyBuilder> idProviderKeys, String path);
	}

	public static final class DefaultUrlRegistryAgentBuilder extends DefaultBuilder<UrlRegistryAgent, UrlRegistryAgentBuilder, DefaultUrlRegistryAgentBuilder> implements UrlRegistryAgentBuilder {

		private DefaultUrlRegistryAgentBuilder() {
		}

		@Override
		public final UrlRegistryAgentBuilder entries(List<IDProviderKeyBuilder> idProviderKeys, String path) {
			when(getBuildable().getEntries(path)).thenReturn(idProviderKeys.stream().map(BuilderMock::build).collect(toList()));
			return getBuilder();
		}
	}

}
