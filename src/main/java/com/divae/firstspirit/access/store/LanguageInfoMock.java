package com.divae.firstspirit.access.store;

import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.StoreElementMock.DefaultStoreElementBuilder;
import com.divae.firstspirit.access.store.StoreElementMock.StoreElementBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.LanguageInfo;

import static org.mockito.Mockito.when;

public final class LanguageInfoMock {

	private LanguageInfoMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> LanguageInfoBuilder languageInfoWith(LanguageBuilder language, TBUILDER parent) {
		return new DefaultLanguageInfoBuilder(language, parent);
	}

	public interface LanguageInfoBuilder extends StoreElementBuilder<LanguageInfo, LanguageInfoBuilder> {
		LanguageInfoBuilder aDisplayName(String displayName);
	}

	public static final class DefaultLanguageInfoBuilder extends DefaultStoreElementBuilder<LanguageInfo, LanguageInfoBuilder, DefaultLanguageInfoBuilder> implements LanguageInfoBuilder {

		private <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> DefaultLanguageInfoBuilder(LanguageBuilder language, TBUILDER parent) {
			super(LanguageInfoBuilder.class.getName(), parent);
			when(getBuildable().getLanguage()).thenReturn(getBuildable(language));
		}

		@Override
		public final LanguageInfoBuilder aDisplayName(String displayName) {
			when(getBuildable().getDisplayName()).thenReturn(displayName);
			return getBuilder();
		}
	}
}
