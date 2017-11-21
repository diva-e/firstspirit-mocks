package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.access.store.ContentProducerMock.ContentProducerBuilder;
import com.divae.firstspirit.access.store.ContentProducerMock.DefaultContentProducerBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.sitestore.Content2ParamsMock.Content2ParamsBuilder;
import com.divae.firstspirit.access.store.sitestore.SiteStoreFolderMock.SiteStoreFolderBuilder;
import com.divae.firstspirit.access.store.sitestore.StartNodeMock.StartNodeBuilder;
import com.divae.firstspirit.access.store.sitestore.StartNodeMock.TruncatedStartNodeBuilder;
import de.espirit.firstspirit.access.store.pagestore.Page;
import de.espirit.firstspirit.access.store.sitestore.Content2Params;
import de.espirit.firstspirit.access.store.sitestore.PageRef;
import de.espirit.firstspirit.access.store.sitestore.SiteStoreFolder;

import java.util.function.Function;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.sitestore.StartNodeMock.startNodeWith;
import static de.espirit.firstspirit.access.store.ReferenceType.PAGEREF;
import static de.espirit.firstspirit.access.store.sitestore.PageRef.UID_TYPE;
import static org.mockito.Mockito.when;

public final class PageRefMock {

    private PageRefMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends SiteStoreFolder, TBUILDER extends SiteStoreFolderBuilder<T, TBUILDER>> PageRefBuilder pageRefWith(String uid, long id, TBUILDER parent) {
        return new DefaultPageRefBuilder(uid, id, parent);
    }

    public static <T extends SiteStoreFolder, TBUILDER extends SiteStoreFolderBuilder<T, TBUILDER>> PageRefBuilder pageRefWith(String uid, long id, String extension, TemplateSetBuilder templateSet, TBUILDER parent) {
        return new DefaultPageRefBuilder(uid, id, extension, templateSet, parent);
    }

    public interface PageRefBuilder extends ContentProducerBuilder<PageRef, PageRefBuilder>, StartNodeBuilder<PageRef, PageRefBuilder>, IDProviderBuilder<PageRef, PageRefBuilder> {
        PageRefBuilder aPage(Page page);

        PageRefBuilder aContent2Params(Function<PageRefBuilder, Content2ParamsBuilder> function);
    }

    public static class DefaultPageRefBuilder extends DefaultContentProducerBuilder<PageRef, PageRefBuilder, DefaultPageRefBuilder> implements PageRefBuilder {

        private final TruncatedStartNodeBuilder<PageRef> startNodeBuilder;

        protected <T extends SiteStoreFolder, TBUILDER extends SiteStoreFolderBuilder<T, TBUILDER>> DefaultPageRefBuilder(String uid, long id, TBUILDER siteStoreFolder) {
            super(uid, id, UID_TYPE, siteStoreFolder);
            aReferenceName(PAGEREF.prefix() + uid);
            startNodeBuilder = startNodeWith(getBuilder());
        }

        protected <T extends SiteStoreFolder, TBUILDER extends SiteStoreFolderBuilder<T, TBUILDER>> DefaultPageRefBuilder(String uid, long id, String extension, TemplateSetBuilder templateSet, TBUILDER siteStoreFolder) {
            super(uid, id, UID_TYPE, extension, templateSet, siteStoreFolder);
            aReferenceName(PAGEREF.prefix() + uid);
            startNodeBuilder = startNodeWith(getBuilder());
        }

        @Override
        public final PageRefBuilder aPage(Page page) {
            when(getBuildable().getPage()).thenReturn(page);
            return getBuilder();
        }

        @Override
        public final PageRefBuilder aContent2Params(Function<PageRefBuilder, Content2ParamsBuilder> function) {
            Content2Params content2Params = build(function.apply(getBuilder()));
            when(getBuildable().getContent2Params()).thenReturn(content2Params);
            return getBuilder();
        }

        @Override
        public final PageRefBuilder isStartNode(boolean startNode) {
            startNodeBuilder.isStartNode(startNode);
            return getBuilder();
        }
    }
}
