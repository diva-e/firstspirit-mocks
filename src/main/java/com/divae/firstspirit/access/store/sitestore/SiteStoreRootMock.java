package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.access.store.StoreMock.DefaultStoreBuilder;
import com.divae.firstspirit.access.store.StoreMock.StoreBuilder;
import com.divae.firstspirit.access.store.sitestore.SiteStoreFolderMock.SiteStoreFolderBuilder;
import com.divae.firstspirit.access.store.sitestore.SiteStoreFolderMock.TruncatedSiteStoreFolderBuilder;
import com.divae.firstspirit.access.store.sitestore.StartNodeMock.StartNodeBuilder;
import com.divae.firstspirit.forms.FormDataMock.FormDataBuilder;
import de.espirit.firstspirit.access.store.Store.Type;
import de.espirit.firstspirit.access.store.sitestore.SiteStoreRoot;
import de.espirit.firstspirit.access.store.sitestore.StartNode;
import de.espirit.firstspirit.forms.FormData;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.divae.firstspirit.access.store.sitestore.SiteStoreFolderMock.siteStoreFolderWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.SITESTORE_FOLDER;

public final class SiteStoreRootMock {

	private SiteStoreRootMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static SiteStoreRootBuilder siteStoreRootWith(long id, ProjectBuilder project) {
		return new DefaultSiteStoreRootBuilder(id, project);
	}

	public interface SiteStoreRootBuilder extends StoreBuilder<SiteStoreRoot, SiteStoreRootBuilder>, SiteStoreFolderBuilder<SiteStoreRoot, SiteStoreRootBuilder> {
	}

	public static final class DefaultSiteStoreRootBuilder extends DefaultStoreBuilder<SiteStoreRoot, SiteStoreRootBuilder, DefaultSiteStoreRootBuilder> implements SiteStoreRootBuilder {

		private final TruncatedSiteStoreFolderBuilder<SiteStoreRoot> siteStoreFolderBuilder;

		private DefaultSiteStoreRootBuilder(long id, ProjectBuilder project) {
			super(id, SITESTORE_FOLDER, Type.SITESTORE, project);
			siteStoreFolderBuilder = siteStoreFolderWith(getBuilder());
		}

		@Override
		public SiteStoreRootBuilder isStartNode(boolean startNode) {
			siteStoreFolderBuilder.isStartNode(startNode);
			return getBuilder();
		}

		@Override
		public <E extends FormData, EBUILDER extends FormDataBuilder<E, EBUILDER>> SiteStoreRootBuilder aFormData(Supplier<EBUILDER> supplier) {
			siteStoreFolderBuilder.aFormData(supplier);
			return getBuilder();
		}

		@Override
		public <T extends StartNode, TBUILDER extends StartNodeBuilder<T, TBUILDER>> SiteStoreRootBuilder aStartNode(Function<SiteStoreRootBuilder, TBUILDER> function) {
			return aStartNodeWith(() -> function.apply(getBuilder()));
		}

		@Override
		public <OT extends StartNode, OTBUILDER extends StartNodeBuilder<OT, OTBUILDER>> SiteStoreRootBuilder aStartNodeWith(Supplier<OTBUILDER> supplier) {
			siteStoreFolderBuilder.aStartNodeWith(supplier);
			return getBuilder();
		}

		@Override
		public SiteStoreRootBuilder aStoredUrl(String storedUrl, LanguageBuilder language, TemplateSetBuilder templateSet) {
			siteStoreFolderBuilder.aStoredUrl(storedUrl, language, templateSet);
			return getBuilder();
		}
	}
}
