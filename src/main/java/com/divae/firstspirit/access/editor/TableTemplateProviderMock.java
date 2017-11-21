package com.divae.firstspirit.access.editor;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.store.templatestore.TableTemplateMock.TableTemplateBuilder;
import de.espirit.firstspirit.access.editor.TableTemplateProvider;

import static org.mockito.Mockito.when;

public final class TableTemplateProviderMock {

    private TableTemplateProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends TableTemplateProvider, TBUILDER extends TableTemplateProviderBuilder<T, TBUILDER>> TruncatedTableTemplateProviderBuilder<T> tableTemplateProviderWith(TBUILDER tableTemplateProvider) {
        return new TruncatedDefaultTableTemplateProviderBuilder<>(tableTemplateProvider);
    }

    public static <T extends TableTemplateProvider> TruncatedTableTemplateProviderBuilder<T> tableTemplateProviderWith() {
        return new TruncatedDefaultTableTemplateProviderBuilder<>();
    }

    public interface TableTemplateProviderBuilder<T extends TableTemplateProvider, TBUILDER extends TableTemplateProviderBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
        TBUILDER aTableTemplate(TableTemplateBuilder tableTemplate);
    }

    public interface TruncatedTableTemplateProviderBuilder<T extends TableTemplateProvider> extends TableTemplateProviderBuilder<T, TruncatedTableTemplateProviderBuilder<T>> {
    }

    public static class DefaultTableTemplateProviderBuilder<T extends TableTemplateProvider, EBUILDER extends TableTemplateProviderBuilder<T, EBUILDER>, TBUILDER extends DefaultTableTemplateProviderBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements TableTemplateProviderBuilder<T, EBUILDER> {

        protected DefaultTableTemplateProviderBuilder() {
        }

        protected <OTBUILDER extends Builder<T, OTBUILDER>> DefaultTableTemplateProviderBuilder(OTBUILDER tableTemplateProvider) {
            super(tableTemplateProvider);
        }

        @Override
        public EBUILDER aTableTemplate(final TableTemplateBuilder tableTemplate) {
            when(getBuildable().getTableTemplate()).thenReturn(getBuildable(tableTemplate));
            return getInterfaceBuilder();
        }
    }

    private static final class TruncatedDefaultTableTemplateProviderBuilder<T extends TableTemplateProvider> extends DefaultTableTemplateProviderBuilder<T, TruncatedTableTemplateProviderBuilder<T>, TruncatedDefaultTableTemplateProviderBuilder<T>> implements TruncatedTableTemplateProviderBuilder<T> {

        private TruncatedDefaultTableTemplateProviderBuilder() {
        }

        private <TBUILDER extends TableTemplateProviderBuilder<T, TBUILDER>> TruncatedDefaultTableTemplateProviderBuilder(TBUILDER tableTemplateProvider) {
            super(tableTemplateProvider);
        }
    }
}
