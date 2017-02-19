package com.divae.firstspirit.forms;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.forms.Form;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.forms.FormMock.formWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class FormMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return FormMock.class;
	}

	@Test
	public void testCreatesFormData() {
		Form form = build(formWith().createsFormData(FormDataMock::formDataWith));
		assertThat(form.createFormData(), is(notNullValue()));
	}
}
