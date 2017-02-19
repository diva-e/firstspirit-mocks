package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.agency.MultiFormValidationReportMock.MultiFormValidationReportBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.agency.ValidationAgent;

import static de.espirit.firstspirit.agency.ValidationAgent.ValidationScope.RELEASE;
import static org.mockito.Mockito.when;

public final class ValidationAgentMock {

	private ValidationAgentMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static ValidationAgentBuilder validationAgentWith() {
		return new DefaultValidationAgentBuilder();
	}

	public interface ValidationAgentBuilder extends Builder<ValidationAgent, ValidationAgentBuilder> {
		ValidationAgentBuilder aReleaseValidation(MultiFormValidationReportBuilder multiFormValidationReport, IDProvider idProvider);
	}

	public static final class DefaultValidationAgentBuilder extends DefaultBuilder<ValidationAgent, ValidationAgentBuilder, DefaultValidationAgentBuilder> implements ValidationAgentBuilder {

		private DefaultValidationAgentBuilder() {
		}

		@Override
		public final ValidationAgentBuilder aReleaseValidation(MultiFormValidationReportBuilder multiFormValidationReport, IDProvider idProvider) {
			when(getBuildable().validate(idProvider, RELEASE)).thenReturn(getBuildable(multiFormValidationReport));
			return getBuilder();
		}
	}

}
