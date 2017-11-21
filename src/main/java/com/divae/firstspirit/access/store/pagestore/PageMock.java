package com.divae.firstspirit.access.store.pagestore;

import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.access.store.ContentProducerMock.ContentProducerBuilder;
import com.divae.firstspirit.access.store.ContentProducerMock.DefaultContentProducerBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.pagestore.DataProviderMock.DataProviderBuilder;
import com.divae.firstspirit.access.store.pagestore.DataProviderMock.TruncatedDataProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.PageTemplateMock.PageTemplateBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateProviderMock.TemplateProviderBuilder;
import com.divae.firstspirit.forms.FormDataMock.FormDataBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.pagestore.Page;
import de.espirit.firstspirit.access.store.templatestore.PageTemplate;
import de.espirit.firstspirit.forms.FormData;

import java.util.function.Supplier;

import static com.divae.firstspirit.access.store.pagestore.DataProviderMock.dataProviderWith;
import static de.espirit.firstspirit.access.store.pagestore.Page.UID_TYPE;
import static org.mockito.Mockito.when;

public final class PageMock {

    private PageMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends Page, E extends IDProvider, EBUILDER extends IDProviderBuilder<E, EBUILDER>> TruncatedPageBuilder<T> pageWith(String uid, long id, EBUILDER parent) {
        return new TruncatedDefaultPageBuilder<>(uid, id, UID_TYPE, parent);
    }

    public static <T extends Page, E extends IDProvider, EBUILDER extends IDProviderBuilder<E, EBUILDER>> TruncatedPageBuilder<T> pageWith(String uid, long id, String extension, TemplateSetBuilder templateSet, EBUILDER parent) {
        return new TruncatedDefaultPageBuilder<>(uid, id, UID_TYPE, extension, templateSet, parent);
    }

    public interface PageBuilder<T extends Page, TBUILDER extends PageBuilder<T, TBUILDER>> extends ContentProducerBuilder<T, TBUILDER>, DataProviderBuilder<T, TBUILDER>, IDProviderBuilder<T, TBUILDER>, TemplateProviderBuilder<PageTemplate, T, TBUILDER> {
        <EBUILDER extends PageTemplateBuilder> TBUILDER aTemplate(EBUILDER template);
    }

    public static class DefaultPageBuilder<T extends Page, EBUILDER extends PageBuilder<T, EBUILDER>, TBUILDER extends DefaultPageBuilder<T, EBUILDER, TBUILDER>> extends DefaultContentProducerBuilder<T, EBUILDER, TBUILDER> implements PageBuilder<T, EBUILDER> {

        private final TruncatedDataProviderBuilder<T> dataProviderBuilder;

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultPageBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
            dataProviderBuilder = dataProviderWith(getInterfaceBuilder());
        }

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultPageBuilder(String uid, long id, UidType uidType, String extension, TemplateSetBuilder templateSet, OTBUILDER parent) {
            super(uid, id, uidType, extension, templateSet, parent);
            dataProviderBuilder = dataProviderWith(getInterfaceBuilder());
        }

        @Override
        public final <OT extends FormData, OTBUILDER extends FormDataBuilder<OT, OTBUILDER>> EBUILDER aFormData(Supplier<OTBUILDER> supplier) {
            dataProviderBuilder.aFormData(supplier);
            return getInterfaceBuilder();
        }

        @Override
        public final <OTBUILDER extends PageTemplateBuilder> EBUILDER aTemplate(OTBUILDER template) {
            when(getBuildable().getTemplate()).thenReturn(getBuildable(template));
            return getInterfaceBuilder();
        }
    }

    public interface TruncatedPageBuilder<T extends Page> extends PageBuilder<T, TruncatedPageBuilder<T>> {
    }

    private static final class TruncatedDefaultPageBuilder<T extends Page> extends DefaultPageBuilder<T, TruncatedPageBuilder<T>, TruncatedDefaultPageBuilder<T>> implements TruncatedPageBuilder<T> {

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultPageBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultPageBuilder(String uid, long id, UidType uidType, String extension, TemplateSetBuilder templateSet, OTBUILDER parent) {
            super(uid, id, uidType, extension, templateSet, parent);
        }
    }
}
