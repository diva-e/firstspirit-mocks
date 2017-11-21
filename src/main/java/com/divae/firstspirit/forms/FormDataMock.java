package com.divae.firstspirit.forms;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.store.templatestore.gom.GomEditorProviderMock.GomEditorProviderBuilder;
import com.divae.firstspirit.forms.FormFieldMock.FormFieldBuilder;
import de.espirit.firstspirit.access.store.templatestore.gom.GomEditorProvider;
import de.espirit.firstspirit.forms.FormData;
import de.espirit.firstspirit.forms.FormField;
import org.mockito.Mockito;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class FormDataMock {

    private FormDataMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends FormData> TruncatedFormDataBuilder<T> formDataWith() {
        return new TruncatedDefaultFormDataBuilder<>();
    }

    public interface FormDataBuilder<T extends FormData, TBUILDER extends FormDataBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {

        <OT> TBUILDER aValue(Supplier<FormFieldBuilder<OT>> supplier, LanguageBuilder language, String name);

        TBUILDER aForm(Supplier<GomEditorProviderBuilder> supplier);
    }

    public static class DefaultFormDataBuilder<T extends FormData, EBUILDER extends FormDataBuilder<T, EBUILDER>, TBUILDER extends DefaultFormDataBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements FormDataBuilder<T, EBUILDER> {

        protected DefaultFormDataBuilder() {
        }

        protected DefaultFormDataBuilder(Number id) {
            super(id);
        }

        @Override
        public final <OT> EBUILDER aValue(Supplier<FormFieldBuilder<OT>> supplier, LanguageBuilder language, String name) {
            FormField<OT> formField = build(supplier.get());
            Mockito.<FormField<?>>when(getBuildable().get(getBuildable(language), name)).thenReturn(formField);
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER aForm(Supplier<GomEditorProviderBuilder> supplier) {
            GomEditorProvider buildable = build(supplier.get());
            when(getBuildable().getForm()).thenReturn(buildable);
            return getInterfaceBuilder();
        }
    }

    public interface TruncatedFormDataBuilder<T extends FormData> extends FormDataBuilder<T, TruncatedFormDataBuilder<T>> {
    }

    private static final class TruncatedDefaultFormDataBuilder<T extends FormData> extends DefaultFormDataBuilder<T, TruncatedFormDataBuilder<T>, TruncatedDefaultFormDataBuilder<T>> implements TruncatedFormDataBuilder<T> {
        private TruncatedDefaultFormDataBuilder() {
        }
    }
}
