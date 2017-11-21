package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.templatestore.Template;
import de.espirit.firstspirit.access.store.templatestore.TemplateContainer;

public final class TemplateContainerMock {

    private TemplateContainerMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends Template, TC extends TemplateContainer<T>, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedTemplateContainerBuilder<T, TC> templateContainerWith(String name, long id, OTBUILDER parent) {
        return new TruncatedDefaultTemplateContainerBuilder<>(name, id, parent);
    }

    public static <T extends Template, TC extends TemplateContainer<T>, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedTemplateContainerBuilder<T, TC> templateContainerWith(String name, long id, UidType uidType, OTBUILDER parent) {
        return new TruncatedDefaultTemplateContainerBuilder<>(name, id, uidType, parent);
    }

    public interface TemplateContainerBuilder<T extends Template, TC extends TemplateContainer<T>, TBUILDER extends TemplateContainerBuilder<T, TC, TBUILDER>> extends IDProviderBuilder<TC, TBUILDER> {
    }

    public static class DefaultTemplateContainerBuilder<T extends Template, TC extends TemplateContainer<T>, EBUILDER extends TemplateContainerBuilder<T, TC, EBUILDER>, TBUILDER extends DefaultTemplateContainerBuilder<T, TC, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<TC, EBUILDER, TBUILDER> implements TemplateContainerBuilder<T, TC, EBUILDER> {

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultTemplateContainerBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
        }

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultTemplateContainerBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }
    }

    public interface TruncatedTemplateContainerBuilder<T extends Template, TC extends TemplateContainer<T>> extends TemplateContainerBuilder<T, TC, TruncatedTemplateContainerBuilder<T, TC>> {
    }

    private static final class TruncatedDefaultTemplateContainerBuilder<T extends Template, TC extends TemplateContainer<T>> extends DefaultTemplateContainerBuilder<T, TC, TruncatedTemplateContainerBuilder<T, TC>, TruncatedDefaultTemplateContainerBuilder<T, TC>> implements TruncatedTemplateContainerBuilder<T, TC> {

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultTemplateContainerBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
        }

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultTemplateContainerBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }
    }
}
