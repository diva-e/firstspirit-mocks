package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.templatestore.Template;
import de.espirit.firstspirit.access.store.templatestore.TemplateProvider;

public final class TemplateProviderMock {

    private TemplateProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends Template, TP extends TemplateProvider<T>, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedTemplateProviderBuilder<T, TP> templateProviderWith(String name, long id, OTBUILDER parent) {
        return new TruncatedDefaultTemplateProviderBuilder<>(name, id, parent);
    }

    public static <T extends Template, TP extends TemplateProvider<T>, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedTemplateProviderBuilder<T, TP> templateProviderWith(String uid, long id, UidType uidType, OTBUILDER parent) {
        return new TruncatedDefaultTemplateProviderBuilder<>(uid, id, uidType, parent);
    }

    public interface TemplateProviderBuilder<T extends Template, TP extends TemplateProvider<T>, TBUILDER extends TemplateProviderBuilder<T, TP, TBUILDER>> extends IDProviderBuilder<TP, TBUILDER> {
    }

    public static class DefaultTemplateProviderBuilder<T extends Template, TP extends TemplateProvider<T>, EBUILDER extends TemplateProviderBuilder<T, TP, EBUILDER>, TBUILDER extends DefaultTemplateProviderBuilder<T, TP, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<TP, EBUILDER, TBUILDER> implements TemplateProviderBuilder<T, TP, EBUILDER> {

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultTemplateProviderBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
        }

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultTemplateProviderBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }
    }

    public interface TruncatedTemplateProviderBuilder<T extends Template, TP extends TemplateProvider<T>> extends TemplateProviderBuilder<T, TP, TruncatedTemplateProviderBuilder<T, TP>> {
    }

    private static final class TruncatedDefaultTemplateProviderBuilder<T extends Template, TP extends TemplateProvider<T>> extends DefaultTemplateProviderBuilder<T, TP, TruncatedTemplateProviderBuilder<T, TP>, TruncatedDefaultTemplateProviderBuilder<T, TP>> implements TruncatedTemplateProviderBuilder<T, TP> {

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultTemplateProviderBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
        }

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultTemplateProviderBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }
    }
}
