package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.access.store.pagestore.DataProviderMock.DataProviderBuilder;
import com.divae.firstspirit.access.store.pagestore.DataProviderMock.DefaultDataProviderBuilder;
import com.divae.firstspirit.access.store.sitestore.StartNodeMock.StartNodeBuilder;
import com.divae.firstspirit.access.store.sitestore.StartNodeMock.TruncatedStartNodeBuilder;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.sitestore.SiteStoreFolder;
import de.espirit.firstspirit.access.store.sitestore.StartNode;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.sitestore.StartNodeMock.startNodeWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.SITESTORE_FOLDER;
import static org.mockito.Mockito.when;

public final class SiteStoreFolderMock {

	private SiteStoreFolderMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends SiteStoreFolder, OT extends SiteStoreFolder, OTBUILDER extends SiteStoreFolderBuilder<OT, OTBUILDER>> TruncatedSiteStoreFolderBuilder<T> siteStoreFolderWith(String uid, long id, OTBUILDER parent) {
		return new TruncatedDefaultSiteStoreFolderBuilder<>(uid, id, SITESTORE_FOLDER, parent);
	}

	public static <T extends SiteStoreFolder, OTBUILDER extends SiteStoreFolderBuilder<T, OTBUILDER>> TruncatedSiteStoreFolderBuilder<T> siteStoreFolderWith(OTBUILDER siteStoreFolder) {
		return new TruncatedDefaultSiteStoreFolderBuilder<>(siteStoreFolder);
	}

	public interface SiteStoreFolderBuilder<T extends SiteStoreFolder, TBUILDER extends SiteStoreFolderBuilder<T, TBUILDER>> extends DataProviderBuilder<T, TBUILDER>, StartNodeBuilder<T, TBUILDER> {
		<OT extends StartNode, OTBUILDER extends StartNodeBuilder<OT, OTBUILDER>> TBUILDER aStartNode(Function<TBUILDER, OTBUILDER> function);

		<OT extends StartNode, OTBUILDER extends StartNodeBuilder<OT, OTBUILDER>> TBUILDER aStartNodeWith(Supplier<OTBUILDER> supplier);

		TBUILDER aStoredUrl(String storedUrl, LanguageBuilder language, TemplateSetBuilder templateSet);
	}

	public static class DefaultSiteStoreFolderBuilder<T extends SiteStoreFolder, EBUILDER extends SiteStoreFolderBuilder<T, EBUILDER>, TBUILDER extends DefaultSiteStoreFolderBuilder<T, EBUILDER, TBUILDER>> extends DefaultDataProviderBuilder<T, EBUILDER, TBUILDER> implements SiteStoreFolderBuilder<T, EBUILDER> {

		private final TruncatedStartNodeBuilder<T> startNodeBuilder;

		protected <OTBUILDER extends SiteStoreFolderBuilder<T, OTBUILDER>> DefaultSiteStoreFolderBuilder(OTBUILDER siteStoreFolder) {
			super(siteStoreFolder);
			startNodeBuilder = startNodeWith(getInterfaceBuilder());
		}

		protected <OT extends SiteStoreFolder, OTBUILDER extends SiteStoreFolderBuilder<OT, OTBUILDER>> DefaultSiteStoreFolderBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
			super(uid, id, uidType, parent);
			startNodeBuilder = startNodeWith(getInterfaceBuilder());
		}

		@Override
		public final <OT extends StartNode, OTBUILDER extends StartNodeBuilder<OT, OTBUILDER>> EBUILDER aStartNode(Function<EBUILDER, OTBUILDER> function) {
			return aStartNodeWith(() -> function.apply(getInterfaceBuilder()));
		}

		@Override
		public <OT extends StartNode, OTBUILDER extends StartNodeBuilder<OT, OTBUILDER>> EBUILDER aStartNodeWith(Supplier<OTBUILDER> supplier) {
			StartNode startNode = build(supplier.get());
			when(getBuildable().getStartNode()).thenReturn(startNode);
			return getInterfaceBuilder();
		}

		@Override
		public final EBUILDER aStoredUrl(String storedUrl, LanguageBuilder language, TemplateSetBuilder templateSet) {
			when(getBuildable().getStoredUrl(getBuildable(language), getBuildable(templateSet))).thenReturn(storedUrl);
			return getInterfaceBuilder();
		}

		@Override
		public EBUILDER isStartNode(boolean startNode) {
			startNodeBuilder.isStartNode(startNode);
			return getInterfaceBuilder();
		}
	}

	public interface TruncatedSiteStoreFolderBuilder<T extends SiteStoreFolder> extends SiteStoreFolderBuilder<T, TruncatedSiteStoreFolderBuilder<T>> {
	}

	public static final class TruncatedDefaultSiteStoreFolderBuilder<T extends SiteStoreFolder> extends DefaultSiteStoreFolderBuilder<T, TruncatedSiteStoreFolderBuilder<T>, TruncatedDefaultSiteStoreFolderBuilder<T>> implements TruncatedSiteStoreFolderBuilder<T> {

		<OTBUILDER extends SiteStoreFolderBuilder<T, OTBUILDER>> TruncatedDefaultSiteStoreFolderBuilder(OTBUILDER siteStoreFolder) {
			super(siteStoreFolder);
		}

		<OT extends SiteStoreFolder, OTBUILDER extends SiteStoreFolderBuilder<OT, OTBUILDER>> TruncatedDefaultSiteStoreFolderBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
			super(uid, id, uidType, parent);
		}
	}
}
