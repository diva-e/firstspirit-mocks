package com.divae.firstspirit.access.store.templatestore;


import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateContainerMock.DefaultTemplateContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateContainerMock.TemplateContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.TemplateStoreRootBuilder;
import de.espirit.firstspirit.access.store.templatestore.LinkTemplate;
import de.espirit.firstspirit.access.store.templatestore.LinkTemplates;

import static de.espirit.firstspirit.access.store.templatestore.LinkTemplate.UID_TYPE;

public final class LinkTemplatesMock {

    private LinkTemplatesMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static LinkTemplatesBuilder linkTemplatesWith(String uid, long id, TemplateStoreRootBuilder parent) {
        return new DefaultLinkTemplatesBuilder(uid, id, parent);
    }

    public interface LinkTemplatesBuilder extends TemplateContainerBuilder<LinkTemplate, LinkTemplates, LinkTemplatesBuilder>, IDProviderBuilder<LinkTemplates, LinkTemplatesBuilder> {
    }

    private static final class DefaultLinkTemplatesBuilder extends DefaultTemplateContainerBuilder<LinkTemplate, LinkTemplates, LinkTemplatesBuilder, DefaultLinkTemplatesBuilder> implements LinkTemplatesBuilder {

        private DefaultLinkTemplatesBuilder(String uid, long id, TemplateStoreRootBuilder parent) {
            super(uid, id, UID_TYPE, parent);
        }

    }
}
