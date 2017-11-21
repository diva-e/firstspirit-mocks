package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.pagestore.PageMock.DefaultPageBuilder;
import com.divae.firstspirit.access.store.pagestore.PageMock.PageBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.globalstore.GCAPage;

import static de.espirit.firstspirit.access.store.IDProvider.UidType.GLOBALSTORE;

public final class GCAPageMock {

    private GCAPageMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> GCAPageBuilder gcaPageWith(String uid, long id, TBUILDER parent) {
        return new DefaultGCAPageBuilder(uid, id, parent);
    }

    public static <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> GCAPageBuilder gcaPageWith(String uid, long id, String extension, TemplateSetBuilder templateSet, TBUILDER parent) {
        return new DefaultGCAPageBuilder(uid, id, extension, templateSet, parent);
    }

    public interface GCAPageBuilder extends PageBuilder<GCAPage, GCAPageBuilder> {
    }

    private static final class DefaultGCAPageBuilder extends DefaultPageBuilder<GCAPage, GCAPageBuilder, DefaultGCAPageBuilder> implements GCAPageBuilder {

        private <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> DefaultGCAPageBuilder(String uid, long id, TBUILDER parent) {
            super(uid, id, GLOBALSTORE, parent);
        }

        private <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> DefaultGCAPageBuilder(String uid, long id, String extension, TemplateSetBuilder templateSet, TBUILDER parent) {
            super(uid, id, GLOBALSTORE, extension, templateSet, parent);
        }
    }

}
