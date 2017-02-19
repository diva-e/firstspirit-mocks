package com.divae.firstspirit.forms;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.forms.FormField;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class FormFieldMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return FormFieldMock.class;
	}

	@Test
	public void testAValue() {
		String value = "test";
		FormField<String> formField = build(FormFieldMock.<String>formFieldWith().aValue(value));
		assertThat(formField.get(), is(value));
		assertThat(formField.getType(), is(String.class));
	}

	@Test
	public void testAValueWithNull() {
		FormField<String> formField = build(FormFieldMock.<String>formFieldWith().aValue(null));
		assertThat(formField.get(), is(nullValue()));
		assertThat(formField.getType(), is(nullValue()));
	}

	@Test
	public void testDefault() {
		String value = "test";
		FormField<String> formField = build(FormFieldMock.<String>formFieldWith());
		formField.set(value);
		assertThat(formField.get(), is(value));
		assertThat(formField.getType(), is(String.class));
	}
}
