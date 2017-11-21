package com.divae.firstspirit.access.store.templatestore;


import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.link.LinkMock.LinkBuilder;
import com.divae.firstspirit.access.store.templatestore.LinkTemplatesMock.LinkTemplatesBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateMock.DefaultTemplateBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateMock.TemplateBuilder;
import de.espirit.firstspirit.access.link.Link;
import de.espirit.firstspirit.access.store.templatestore.LinkTemplate;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE_LINKTEMPLATE;
import static org.mockito.Mockito.when;

public final class LinkTemplateMock {

    private LinkTemplateMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static LinkTemplateBuilder linkTemplateWith(String uid, long id, LinkTemplatesBuilder parent) {
        return new DefaultLinkTemplateBuilder(uid, id, parent);
    }

    public interface LinkTemplateBuilder extends TemplateBuilder<LinkTemplate, LinkTemplateBuilder> {
        LinkTemplateBuilder createsLink(Supplier<LinkBuilder> supplier, LanguageBuilder language);
    }

    public static final class DefaultLinkTemplateBuilder extends DefaultTemplateBuilder<LinkTemplate, LinkTemplateBuilder, DefaultLinkTemplateBuilder> implements LinkTemplateBuilder {

        private DefaultLinkTemplateBuilder(String uid, long id, LinkTemplatesBuilder parent) {
            super(uid, id, TEMPLATESTORE_LINKTEMPLATE, parent);
        }

        @Override
        public final LinkTemplateBuilder createsLink(Supplier<LinkBuilder> supplier, LanguageBuilder language) {
            Link link = build(supplier.get());
            when(getBuildable().createLink(getBuildable(language))).thenReturn(link);
            return getBuilder();
        }

    }
}
