package com.divae.firstspirit.ui.operations;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.forms.FormDataMock.FormDataBuilder;
import com.divae.firstspirit.forms.FormMock.FormBuilder;
import de.espirit.firstspirit.forms.FormData;
import de.espirit.firstspirit.ui.operations.ShowFormDialogOperation;

import java.util.List;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class ShowFormDialogOperationMock {

    private ShowFormDialogOperationMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static ShowFormDialogOperationBuilder showFormDialogOperationWith() {
        return new DefaultShowFormDialogOperationBuilder();
    }

    public interface ShowFormDialogOperationBuilder extends Builder<ShowFormDialogOperation, ShowFormDialogOperationBuilder> {
        <T extends FormData, TBUILDER extends FormDataBuilder<T, TBUILDER>> ShowFormDialogOperationBuilder performs(Supplier<TBUILDER> supplier, FormBuilder form, List<LanguageBuilder> languages) throws ShowFormDialogOperation.InvalidRulesetDefinition;
    }

    public static final class DefaultShowFormDialogOperationBuilder extends DefaultBuilder<ShowFormDialogOperation, ShowFormDialogOperationBuilder, DefaultShowFormDialogOperationBuilder> implements ShowFormDialogOperationBuilder {

        private DefaultShowFormDialogOperationBuilder() {
        }

        @Override
        public final <T extends FormData, TBUILDER extends FormDataBuilder<T, TBUILDER>> ShowFormDialogOperationBuilder performs(Supplier<TBUILDER> supplier, FormBuilder form, List<LanguageBuilder> languages) throws ShowFormDialogOperation.InvalidRulesetDefinition {
            T formData = build(supplier.get());
            when(getBuildable().perform(getBuildable(form), languages.stream().map(BuilderMock::build).collect(toList()))).thenReturn(formData);
            return getBuilder();
        }
    }
}
