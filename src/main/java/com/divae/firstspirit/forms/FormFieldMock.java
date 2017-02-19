package com.divae.firstspirit.forms;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.forms.FormField;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

public final class FormFieldMock {

	private FormFieldMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T> FormFieldBuilder<T> formFieldWith() {
		return new DefaultFormFieldBuilder<>();
	}

	public interface FormFieldBuilder<T> extends Builder<FormField<T>, FormFieldBuilder<T>> {
		FormFieldBuilder<T> aValue(T value);

		FormFieldBuilder<T> aType(Class<T> type);
	}

	public static final class DefaultFormFieldBuilder<T> extends DefaultBuilder<FormField<T>, FormFieldBuilder<T>, DefaultFormFieldBuilder<T>> implements FormFieldBuilder<T> {

		@SuppressWarnings("unchecked")
		private DefaultFormFieldBuilder() {
			doAnswer(invocation -> {
				Object[] args = invocation.getArguments();
				aValue((T) args[0]);
				return null;
			}).when(getBuildable()).set(any());
		}

		@Override
		@SuppressWarnings("unchecked")
		public final FormFieldBuilder<T> aValue(T value) {
			when(getBuildable().get()).thenReturn(value);
			if (value != null) {
				aType((Class<T>) value.getClass());
			}
			return getBuilder();
		}

		@Override
		@SuppressWarnings("unchecked")
		public final FormFieldBuilder<T> aType(Class<T> type) {
			when(getBuildable().getType()).thenReturn(type);
			return getBuilder();
		}
	}
}
