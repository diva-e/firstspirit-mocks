package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.store.contentstore.ContentStoreRootMock.ContentStoreRootBuilder;
import com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.GlobalStoreRootBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaStoreRootMock.MediaStoreRootBuilder;
import com.divae.firstspirit.access.store.pagestore.PageStoreRootMock.PageStoreRootBuilder;
import com.divae.firstspirit.access.store.sitestore.SiteStoreRootMock.SiteStoreRootBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.TemplateStoreRootBuilder;
import de.espirit.firstspirit.access.store.contentstore.ContentStoreRoot;
import de.espirit.firstspirit.access.store.globalstore.GlobalStoreRoot;
import de.espirit.firstspirit.access.store.mediastore.MediaStoreRoot;
import de.espirit.firstspirit.access.store.pagestore.PageStoreRoot;
import de.espirit.firstspirit.access.store.sitestore.SiteStoreRoot;
import de.espirit.firstspirit.access.store.templatestore.TemplateStoreRoot;
import de.espirit.firstspirit.agency.StoreAgent;

import static de.espirit.firstspirit.access.store.Store.Type.CONTENTSTORE;
import static de.espirit.firstspirit.access.store.Store.Type.GLOBALSTORE;
import static de.espirit.firstspirit.access.store.Store.Type.MEDIASTORE;
import static de.espirit.firstspirit.access.store.Store.Type.PAGESTORE;
import static de.espirit.firstspirit.access.store.Store.Type.SITESTORE;
import static de.espirit.firstspirit.access.store.Store.Type.TEMPLATESTORE;
import static org.mockito.Mockito.when;

public final class StoreAgentMock {

    private StoreAgentMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static StoreAgentBuilder storeAgentWith() {
        return new DefaultStoreAgentBuilder();
    }

    public interface StoreAgentBuilder extends Builder<StoreAgent, StoreAgentBuilder> {
        StoreAgentBuilder aContentStoreRoot(ContentStoreRootBuilder contentStoreRoot, boolean onlyReleaseVersion);

        StoreAgentBuilder aContentStoreRoot(ContentStoreRootBuilder contentStoreRoot);

        StoreAgentBuilder aTemplateStoreRoot(TemplateStoreRootBuilder templateStoreRoot);

        StoreAgentBuilder aTemplateStoreRoot(TemplateStoreRootBuilder templateStoreRoot, boolean onlyReleaseVersion);

        StoreAgentBuilder aGlobalStoreRoot(GlobalStoreRootBuilder globalStoreRoot, boolean onlyReleaseVersion);

        StoreAgentBuilder aGlobalStoreRoot(GlobalStoreRootBuilder globalStoreRoot);

        StoreAgentBuilder aMediaStoreRoot(MediaStoreRootBuilder mediaStoreRoot);

        StoreAgentBuilder aMediaStoreRoot(MediaStoreRootBuilder mediaStoreRoot, boolean onlyReleaseVersion);

        StoreAgentBuilder aSiteStoreRoot(SiteStoreRootBuilder siteStoreRoot);

        StoreAgentBuilder aSiteStoreRoot(SiteStoreRootBuilder siteStoreRoot, boolean onlyReleaseVersion);

        StoreAgentBuilder aPageStoreRoot(PageStoreRootBuilder pageStoreRoot);

        StoreAgentBuilder aPageStoreRoot(PageStoreRootBuilder pageStoreRoot, boolean onlyReleaseVersion);
    }

    public static final class DefaultStoreAgentBuilder extends DefaultBuilder<StoreAgent, StoreAgentBuilder, DefaultStoreAgentBuilder> implements StoreAgentBuilder {

        private DefaultStoreAgentBuilder() {
        }

        @Override
        public final StoreAgentBuilder aContentStoreRoot(ContentStoreRootBuilder contentStoreRoot, boolean onlyReleaseVersion) {
            ContentStoreRoot buildable = getBuildable(contentStoreRoot);
            when(getBuildable().getStore(CONTENTSTORE, onlyReleaseVersion)).thenReturn(buildable);
            if (!onlyReleaseVersion) {
                when(getBuildable().getStore(CONTENTSTORE)).thenReturn(buildable);
            }
            return getBuilder();
        }

        @Override
        public final StoreAgentBuilder aContentStoreRoot(ContentStoreRootBuilder contentStoreRoot) {
            return aContentStoreRoot(contentStoreRoot, false);
        }

        @Override
        public final StoreAgentBuilder aTemplateStoreRoot(TemplateStoreRootBuilder templateStoreRoot) {
            return aTemplateStoreRoot(templateStoreRoot, false);
        }

        @Override
        public final StoreAgentBuilder aTemplateStoreRoot(TemplateStoreRootBuilder templateStoreRoot, boolean onlyReleaseVersion) {
            TemplateStoreRoot buildable = getBuildable(templateStoreRoot);
            when(getBuildable().getStore(TEMPLATESTORE, onlyReleaseVersion)).thenReturn(buildable);
            if (!onlyReleaseVersion) {
                when(getBuildable().getStore(TEMPLATESTORE)).thenReturn(buildable);
            }
            return getBuilder();
        }

        @Override
        public final StoreAgentBuilder aGlobalStoreRoot(GlobalStoreRootBuilder globalStoreRoot, boolean onlyReleaseVersion) {
            GlobalStoreRoot buildable = getBuildable(globalStoreRoot);
            when(getBuildable().getStore(GLOBALSTORE, onlyReleaseVersion)).thenReturn(buildable);
            if (!onlyReleaseVersion) {
                when(getBuildable().getStore(GLOBALSTORE)).thenReturn(buildable);
            }
            return getBuilder();
        }

        @Override
        public final StoreAgentBuilder aGlobalStoreRoot(GlobalStoreRootBuilder globalStoreRoot) {
            return aGlobalStoreRoot(globalStoreRoot, false);
        }

        @Override
        public final StoreAgentBuilder aMediaStoreRoot(MediaStoreRootBuilder mediaStoreRoot) {
            return aMediaStoreRoot(mediaStoreRoot, false);
        }

        @Override
        public final StoreAgentBuilder aMediaStoreRoot(MediaStoreRootBuilder mediaStoreRoot, boolean onlyReleaseVersion) {
            MediaStoreRoot buildable = getBuildable(mediaStoreRoot);
            when(getBuildable().getStore(MEDIASTORE, onlyReleaseVersion)).thenReturn(buildable);
            if (!onlyReleaseVersion) {
                when(getBuildable().getStore(MEDIASTORE)).thenReturn(buildable);
            }
            return getBuilder();
        }

        @Override
        public final StoreAgentBuilder aSiteStoreRoot(SiteStoreRootBuilder siteStoreRoot) {
            return aSiteStoreRoot(siteStoreRoot, false);
        }

        @Override
        public final StoreAgentBuilder aSiteStoreRoot(SiteStoreRootBuilder siteStoreRoot, boolean onlyReleaseVersion) {
            SiteStoreRoot buildable = getBuildable(siteStoreRoot);
            when(getBuildable().getStore(SITESTORE, onlyReleaseVersion)).thenReturn(buildable);
            if (!onlyReleaseVersion) {
                when(getBuildable().getStore(SITESTORE)).thenReturn(buildable);
            }
            return getBuilder();
        }

        @Override
        public final StoreAgentBuilder aPageStoreRoot(PageStoreRootBuilder pageStoreRoot) {
            return aPageStoreRoot(pageStoreRoot, false);
        }

        @Override
        public final StoreAgentBuilder aPageStoreRoot(PageStoreRootBuilder pageStoreRoot, boolean onlyReleaseVersion) {
            PageStoreRoot buildable = getBuildable(pageStoreRoot);
            when(getBuildable().getStore(PAGESTORE, onlyReleaseVersion)).thenReturn(buildable);
            if (!onlyReleaseVersion) {
                when(getBuildable().getStore(PAGESTORE)).thenReturn(buildable);
            }
            return getBuilder();
        }
    }
}
