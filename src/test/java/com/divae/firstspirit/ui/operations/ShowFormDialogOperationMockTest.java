package com.divae.firstspirit.ui.operations;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock;
import com.divae.firstspirit.forms.FormDataMock;
import com.divae.firstspirit.forms.FormMock;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.forms.Form;
import de.espirit.firstspirit.ui.operations.ShowFormDialogOperation;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.forms.FormMock.formWith;
import static com.divae.firstspirit.ui.operations.ShowFormDialogOperationMock.showFormDialogOperationWith;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ShowFormDialogOperationMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return ShowFormDialogOperationMock.class;
	}

	@Test
	public void testPerforms() throws ShowFormDialogOperation.InvalidRulesetDefinition {
		FormMock.FormBuilder formBuilder = formWith();
		LanguageMock.LanguageBuilder languageBuilder = languageWith("DE");
		ShowFormDialogOperation showFormDialogOperation = build(showFormDialogOperationWith().performs(FormDataMock::formDataWith, formBuilder, singletonList(languageBuilder)));
		Form form = build(formBuilder);
		Language language = build(languageBuilder);
		assertThat(showFormDialogOperation.perform(form, singletonList(language)), is(notNullValue()));
	}
}
