package com.divae.firstspirit.forms;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.forms.FormDataMock.FormDataBuilder;
import de.espirit.firstspirit.forms.Form;
import de.espirit.firstspirit.forms.FormData;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class FormMock {

    private FormMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static FormBuilder formWith() {
        return new DefaultFormBuilder();
    }

    public interface FormBuilder extends Builder<Form, FormBuilder> {
        <T extends FormData, TBUILDER extends FormDataBuilder<T, TBUILDER>> FormBuilder createsFormData(Supplier<TBUILDER> supplier);
    }

    public static final class DefaultFormBuilder extends DefaultBuilder<Form, FormBuilder, DefaultFormBuilder> implements FormBuilder {

        private DefaultFormBuilder() {
        }

        @Override
        public final <T extends FormData, TBUILDER extends FormDataBuilder<T, TBUILDER>> FormBuilder createsFormData(Supplier<TBUILDER> supplier) {
            when(getBuildable().createFormData()).thenReturn(build(supplier.get()));
            return getBuilder();
        }
    }

}
