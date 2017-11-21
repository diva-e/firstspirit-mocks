package com.divae.firstspirit.forms;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.forms.FormData;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.store.templatestore.gom.GomEditorProviderMock.gomEditorProviderWith;
import static com.divae.firstspirit.forms.FormDataMock.formDataWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class FormDataMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return FormDataMock.class;
    }

    @Test
    public void testAValue() {
        LanguageMock.LanguageBuilder languageBuilder = languageWith("DE");
        String name = "name";
        FormData formData = build(formDataWith().aValue(FormFieldMock::formFieldWith, languageBuilder, name));
        Language language = build(languageBuilder);
        assertThat(formData.get(language, name), is(notNullValue()));
    }

    @Test
    public void testAForm() {
        FormData formData = build(formDataWith().aForm(() -> gomEditorProviderWith("test")));
        assertThat(formData.getForm().getUid(), is("test"));
    }
}
