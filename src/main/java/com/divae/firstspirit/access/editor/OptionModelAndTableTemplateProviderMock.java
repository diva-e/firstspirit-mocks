package com.divae.firstspirit.access.editor;

import com.divae.firstspirit.access.editor.TableTemplateProviderMock.TableTemplateProviderBuilder;
import com.divae.firstspirit.access.editor.TableTemplateProviderMock.TruncatedTableTemplateProviderBuilder;
import com.divae.firstspirit.access.editor.value.OptionModelMock.DefaultOptionModelBuilder;
import com.divae.firstspirit.access.editor.value.OptionModelMock.OptionModelBuilder;
import com.divae.firstspirit.access.store.templatestore.TableTemplateMock.TableTemplateBuilder;
import de.espirit.firstspirit.access.editor.TableTemplateProvider;
import de.espirit.firstspirit.access.editor.value.OptionModel;

import static com.divae.firstspirit.access.editor.TableTemplateProviderMock.tableTemplateProviderWith;

public final class OptionModelAndTableTemplateProviderMock {

    private OptionModelAndTableTemplateProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static OptionModelAndTableTemplateProviderBuilder optionModelAndTableTemplateProviderWith() {
        return new DefaultOptionModelAndTableTemplateProviderBuilder();
    }

    public interface OptionModelAndTableTemplateProviderBuilder extends OptionModelBuilder<OptionModelAndTableTemplateProvider, OptionModelAndTableTemplateProviderBuilder>, TableTemplateProviderBuilder<OptionModelAndTableTemplateProvider, OptionModelAndTableTemplateProviderBuilder> {
    }

    public interface OptionModelAndTableTemplateProvider extends OptionModel, TableTemplateProvider {
    }

    public static final class DefaultOptionModelAndTableTemplateProviderBuilder extends DefaultOptionModelBuilder<OptionModelAndTableTemplateProvider, OptionModelAndTableTemplateProviderBuilder, DefaultOptionModelAndTableTemplateProviderBuilder> implements OptionModelAndTableTemplateProviderBuilder {

        private final TruncatedTableTemplateProviderBuilder<OptionModelAndTableTemplateProvider> tableTemplateProvider;

        private DefaultOptionModelAndTableTemplateProviderBuilder() {
            tableTemplateProvider = tableTemplateProviderWith(getInterfaceBuilder());
        }

        @Override
        public OptionModelAndTableTemplateProviderBuilder aTableTemplate(final TableTemplateBuilder tableTemplate) {
            tableTemplateProvider.aTableTemplate(tableTemplate);
            return getInterfaceBuilder();
        }
    }
}
