package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.templatestore.TemplateStoreElement;

public final class TemplateStoreElementMock {

    private TemplateStoreElementMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends TemplateStoreElement, TBUILDER extends TemplateStoreElementBuilder<T, TBUILDER>, E extends IDProvider, EBUILDER extends IDProviderBuilder<E, EBUILDER>> TruncatedTemplateStoreElementBuilder<T> templateStoreElementWith(String uid, long id, UidType uidType, EBUILDER parent) {
        return new TruncatedDefaultTemplateStoreElementBuilder<>(uid, id, uidType, parent);
    }

    public interface TemplateStoreElementBuilder<T extends TemplateStoreElement, TBUILDER extends TemplateStoreElementBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
    }

    public static class DefaultTemplateStoreElementBuilder<T extends TemplateStoreElement, EBUILDER extends TemplateStoreElementBuilder<T, EBUILDER>, TBUILDER extends DefaultTemplateStoreElementBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements TemplateStoreElementBuilder<T, EBUILDER> {

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultTemplateStoreElementBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }
    }

    public interface TruncatedTemplateStoreElementBuilder<T extends TemplateStoreElement> extends TemplateStoreElementBuilder<T, TruncatedTemplateStoreElementBuilder<T>> {
    }

    private static final class TruncatedDefaultTemplateStoreElementBuilder<T extends TemplateStoreElement> extends DefaultIDProviderBuilder<T, TruncatedTemplateStoreElementBuilder<T>, TruncatedDefaultTemplateStoreElementBuilder<T>> implements TruncatedTemplateStoreElementBuilder<T> {

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultTemplateStoreElementBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }
    }
}
