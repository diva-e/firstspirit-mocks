package com.divae.firstspirit.generate;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.StoreMock;
import de.espirit.firstspirit.access.store.ContentProducer;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.Store;
import de.espirit.firstspirit.access.store.sitestore.SiteStoreFolder;
import de.espirit.firstspirit.generate.PathLookup;

import static org.mockito.Mockito.when;

public final class PathLookupMock {

	private PathLookupMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static PathLookupBuilder pathLookupWith() {
		return new DefaultPathLookupBuilder();
	}

	public interface PathLookupBuilder extends Builder<PathLookup, PathLookupBuilder> {
		<T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> PathLookupBuilder anIdProvider(LanguageBuilder language, TemplateSetBuilder templateSet, String storedUrl, TBUILDER idProvider);

		<T extends Store, TBUILDER extends StoreMock.StoreBuilder<T, TBUILDER>> PathLookupBuilder aStore(LanguageBuilder language, TemplateSetBuilder templateSet, TBUILDER store);
	}

	public static final class DefaultPathLookupBuilder extends DefaultBuilder<PathLookup, PathLookupBuilder, DefaultPathLookupBuilder> implements PathLookupBuilder {

		private static final String HTTPS_URL_PREFIX = "https://";
		private static final String HTTP_URL_PREFIX = "http://";

		private DefaultPathLookupBuilder() {
		}

		@Override
		public final <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> PathLookupBuilder anIdProvider(LanguageBuilder language, TemplateSetBuilder templateSet, String storedUrl, TBUILDER idProvider) {
			String extractedPath = extractPath(getBuildable(idProvider), storedUrl);
			when(getBuildable().lookupPath(getBuildable(idProvider), getBuildable(language), getBuildable(templateSet))).thenReturn(extractedPath);
			return getBuilder();
		}

		@Override
		public final <T extends Store, TBUILDER extends StoreMock.StoreBuilder<T, TBUILDER>> PathLookupBuilder aStore(LanguageBuilder language, TemplateSetBuilder templateSet, TBUILDER store) {
			String extractedPath = extractPath(getBuildable(store));
			when(getBuildable().lookupPath(getBuildable(store), getBuildable(language), getBuildable(templateSet))).thenReturn(extractedPath);
			return getBuilder();
		}

		static String extractPath(IDProvider idProvider, String storedUrl) {
			if (idProvider instanceof Store) {
				return extractPath((Store) idProvider);
			}
			if (idProvider instanceof SiteStoreFolder) {
				return extractPathFromSiteStoreFolder(storedUrl);
			}
			if (idProvider instanceof ContentProducer) {
				return extractPathFromContentProducer(storedUrl);
			}
			return null;
		}

		static String extractPath(Store store) {
			return "";
		}

		private static String extractPathFromSiteStoreFolder(String storedUrl) {
			String extractPath = storedUrl;
			while (extractPath.endsWith("/")) {
				extractPath = extractPath.substring(0, extractPath.length() - 1);
			}

			if (!extractPath.startsWith("/") && !extractPath.startsWith(HTTP_URL_PREFIX) && !extractPath.startsWith(HTTPS_URL_PREFIX)) {
				return '/' + extractPath;
			}

			return extractPath;
		}

		private static String extractPathFromContentProducer(String storedUrl) {
			String extractPath = storedUrl;
			while (extractPath.startsWith("/")) {
				extractPath = extractPath.substring(1);
			}

			int delimiter = extractPath.lastIndexOf('/');
			if (delimiter == -1) {
				return "";
			}

			return extractPath.substring(0, delimiter);
		}
	}
}
