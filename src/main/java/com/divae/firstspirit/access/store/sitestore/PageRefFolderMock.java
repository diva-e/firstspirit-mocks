package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.access.store.sitestore.SiteStoreFolderMock.DefaultSiteStoreFolderBuilder;
import com.divae.firstspirit.access.store.sitestore.SiteStoreFolderMock.SiteStoreFolderBuilder;
import de.espirit.firstspirit.access.store.sitestore.PageRefFolder;
import de.espirit.firstspirit.access.store.sitestore.SiteStoreFolder;

import static de.espirit.firstspirit.access.store.ReferenceType.PAGEREFFOLDER;
import static de.espirit.firstspirit.access.store.sitestore.SiteStoreFolder.UID_TYPE;

public final class PageRefFolderMock {

	private PageRefFolderMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends SiteStoreFolder, TBUILDER extends SiteStoreFolderBuilder<T, TBUILDER>> PageRefFolderBuilder pageRefFolderWith(String uid, long id, TBUILDER parent) {
		return new DefaultPageRefFolderBuilder(uid, id, parent);
	}

	public interface PageRefFolderBuilder extends SiteStoreFolderBuilder<PageRefFolder, PageRefFolderBuilder> {
	}

	public static final class DefaultPageRefFolderBuilder extends DefaultSiteStoreFolderBuilder<PageRefFolder, PageRefFolderBuilder, DefaultPageRefFolderBuilder> implements PageRefFolderBuilder {

		private <T extends SiteStoreFolder, TBUILDER extends SiteStoreFolderBuilder<T, TBUILDER>> DefaultPageRefFolderBuilder(String uid, long id, TBUILDER parent) {
			super(uid, id, UID_TYPE, parent);
			aReferenceName(PAGEREFFOLDER.prefix() + uid);
			isFolder(true);
		}
	}
}
