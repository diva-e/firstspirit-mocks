package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.agency.MultiFormValidationReport;

import static org.mockito.Mockito.when;

public final class MultiFormValidationReportMock {

	private MultiFormValidationReportMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static MultiFormValidationReportBuilder multiFormValidationReportWith() {
		return new DefaultMultiFormValidationReportBuilder();
	}

	public interface MultiFormValidationReportBuilder extends Builder<MultiFormValidationReport, MultiFormValidationReportBuilder> {
		MultiFormValidationReportBuilder isValid(boolean isValid);
	}

	public static final class DefaultMultiFormValidationReportBuilder extends DefaultBuilder<MultiFormValidationReport, MultiFormValidationReportBuilder, DefaultMultiFormValidationReportBuilder> implements MultiFormValidationReportBuilder {

		private DefaultMultiFormValidationReportBuilder() {
		}

		@Override
		public final MultiFormValidationReportBuilder isValid(boolean isValid) {
			when(getBuildable().isValid()).thenReturn(isValid);
			return getBuilder();
		}
	}

}
