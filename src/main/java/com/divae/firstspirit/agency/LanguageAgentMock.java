package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import de.espirit.firstspirit.agency.LanguageAgent;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class LanguageAgentMock {

	private LanguageAgentMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static LanguageAgentBuilder languageAgentWith() {
		return new DefaultLanguageAgentBuilder();
	}

	public interface LanguageAgentBuilder extends Builder<LanguageAgent, LanguageAgentBuilder> {
		LanguageAgentBuilder languages(List<LanguageBuilder> languages);
	}

	public static final class DefaultLanguageAgentBuilder extends DefaultBuilder<LanguageAgent, LanguageAgentBuilder, DefaultLanguageAgentBuilder> implements LanguageAgentBuilder {

		private DefaultLanguageAgentBuilder() {
		}

		@Override
		public final LanguageAgentBuilder languages(List<LanguageBuilder> languages) {
			when(getBuildable().getLanguages()).thenReturn(languages.stream().map(BuilderMock::build).collect(toList()));
			return getBuilder();
		}
	}
}
