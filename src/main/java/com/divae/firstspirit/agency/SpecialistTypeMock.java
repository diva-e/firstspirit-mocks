package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.agency.SpecialistType;

public final class SpecialistTypeMock {

	private SpecialistTypeMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T> SpecialistTypeBuilder<T> specialistTypeWith() {
		return new DefaultSpecialistTypeBuilder<>();
	}

	public interface SpecialistTypeBuilder<T> extends Builder<SpecialistType<T>, SpecialistTypeBuilder<T>> {
	}

	public static final class DefaultSpecialistTypeBuilder<T> extends DefaultBuilder<SpecialistType<T>, SpecialistTypeBuilder<T>, DefaultSpecialistTypeBuilder<T>> implements SpecialistTypeBuilder<T> {

		private DefaultSpecialistTypeBuilder() {
		}
	}
}
