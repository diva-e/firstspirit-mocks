package com.divae.firstspirit.access.editor.fslist;

import com.divae.firstspirit.forms.FormDataMock.DefaultFormDataBuilder;
import com.divae.firstspirit.forms.FormDataMock.FormDataBuilder;
import de.espirit.firstspirit.access.editor.fslist.IdProvidingFormData;

import static org.mockito.Mockito.when;

public final class IdProvidingFormDataMock {

	private IdProvidingFormDataMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static IdProvidingFormDataBuilder idProvidingFormDataWith(Long id) {
		return new DefaultIdProvidingFormDataBuilder(id);
	}

	public interface IdProvidingFormDataBuilder extends FormDataBuilder<IdProvidingFormData, IdProvidingFormDataBuilder> {
	}

	public static final class DefaultIdProvidingFormDataBuilder extends DefaultFormDataBuilder<IdProvidingFormData, IdProvidingFormDataBuilder, DefaultIdProvidingFormDataBuilder> implements IdProvidingFormDataBuilder {

		private DefaultIdProvidingFormDataBuilder(Long id) {
			super(id);
			withId(id);
		}

		private void withId(Long id) {
			when(getBuildable().getId()).thenReturn(id);
		}
	}
}
