package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.forms.FormMock.FormBuilder;
import de.espirit.firstspirit.agency.FormsAgent;
import de.espirit.firstspirit.forms.Form;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class FormsAgentMock {

	private FormsAgentMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static FormsAgentBuilder formsAgentWith() {
		return new DefaultFormsAgentBuilder();
	}

	public interface FormsAgentBuilder extends Builder<FormsAgent, FormsAgentBuilder> {
		FormsAgentBuilder aForm(Supplier<FormBuilder> supplier, String formDefinition);
	}

	public static final class DefaultFormsAgentBuilder extends DefaultBuilder<FormsAgent, FormsAgentBuilder, DefaultFormsAgentBuilder> implements FormsAgentBuilder {

		private DefaultFormsAgentBuilder() {
		}

		@Override
		public FormsAgentBuilder aForm(Supplier<FormBuilder> supplier, String formDefinition) {
			Form form = build(supplier.get());
			when(getBuildable().getForm(formDefinition)).thenReturn(form);
			return getBuilder();
		}
	}
}
