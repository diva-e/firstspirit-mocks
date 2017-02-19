package com.divae.firstspirit.access.store.pagestore;

import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.store.StoreMock.DefaultStoreBuilder;
import com.divae.firstspirit.access.store.StoreMock.StoreBuilder;
import com.divae.firstspirit.access.store.pagestore.PageFolderMock.PageFolderBuilder;
import com.divae.firstspirit.access.store.pagestore.PageFolderMock.TruncatedPageFolderBuilder;
import de.espirit.firstspirit.access.DuplicateReferenceNameException;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.store.ElementDeletedException;
import de.espirit.firstspirit.access.store.LockException;
import de.espirit.firstspirit.access.store.Store.Type;
import de.espirit.firstspirit.access.store.pagestore.PageFolder;
import de.espirit.firstspirit.access.store.pagestore.PageStoreRoot;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.divae.firstspirit.access.store.pagestore.PageFolderMock.pageFolderWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.PAGESTORE;

public final class PageStoreRootMock {

	private PageStoreRootMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static PageStoreRootBuilder pageStoreRootWith(long id, ProjectBuilder project) {
		return new DefaultPageStoreRootBuilder(id, project);
	}

	public interface PageStoreRootBuilder extends StoreBuilder<PageStoreRoot, PageStoreRootBuilder>, PageFolderBuilder<PageStoreRoot, PageStoreRootBuilder> {
	}

	public final static class DefaultPageStoreRootBuilder extends DefaultStoreBuilder<PageStoreRoot, PageStoreRootBuilder, DefaultPageStoreRootBuilder> implements PageStoreRootBuilder {
		private final TruncatedPageFolderBuilder<PageStoreRoot> pageFolderBuilder;

		private DefaultPageStoreRootBuilder(long id, ProjectBuilder project) {
			super(id, PAGESTORE, Type.PAGESTORE, project);
			pageFolderBuilder = pageFolderWith(getBuilder());
		}

		@Override
		public <OT extends PageFolder, OTBUILDER extends PageFolderBuilder<OT, OTBUILDER>> PageStoreRootBuilder createsPageFolder(Function<PageStoreRootBuilder, OTBUILDER> function, String uid, Map<Language, String> lang2DisplayName, boolean unifyNameOnServer) throws DuplicateReferenceNameException, ElementDeletedException, LockException {
			return createsPageFolderWith(() -> function.apply(getBuilder()), uid, lang2DisplayName, unifyNameOnServer);
		}

		@Override
		public <OT extends PageFolder, OTBUILDER extends PageFolderBuilder<OT, OTBUILDER>> PageStoreRootBuilder createsPageFolderWith(Supplier<OTBUILDER> supplier, String uid, Map<Language, String> lang2DisplayName, boolean unifyNameOnServer) throws DuplicateReferenceNameException, ElementDeletedException, LockException {
			pageFolderBuilder.createsPageFolderWith(supplier, uid, lang2DisplayName, unifyNameOnServer);
			return getBuilder();
		}
	}
}
