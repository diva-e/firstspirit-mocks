package com.divae.firstspirit.access.store;

import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.project.TemplateSet;
import de.espirit.firstspirit.access.store.ContentProducer;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.IDProvider.UidType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public final class ContentProducerMock {

	private ContentProducerMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends ContentProducer, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedContentProducerBuilder<T> contentProducerWith(String uid, long id, UidType uidType, OTBUILDER parent) {
		return new TruncatedDefaultContentProducerBuilder<>(uid, id, uidType, parent);
	}

	public static <T extends ContentProducer, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedContentProducerBuilder<T> contentProducerWith(String uid, long id, UidType uidType, String extension, TemplateSetBuilder templateSet, OTBUILDER parent) {
		return new TruncatedDefaultContentProducerBuilder<>(uid, id, uidType, extension, templateSet, parent);
	}

	public interface ContentProducerBuilder<T extends ContentProducer, TBUILDER extends ContentProducerBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
		TBUILDER aStoredUrl(String storedUrl, LanguageBuilder language, TemplateSetBuilder templateSet, Object multiPageObject);
	}

	public static class DefaultContentProducerBuilder<T extends ContentProducer, EBUILDER extends ContentProducerBuilder<T, EBUILDER>, TBUILDER extends DefaultContentProducerBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements ContentProducerBuilder<T, EBUILDER> {

		protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultContentProducerBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
			super(uid, id, uidType, parent);
			withExtension("", any(TemplateSet.class));
		}

		protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultContentProducerBuilder(String uid, long id, UidType uidType, String extension, TemplateSetBuilder templateSet, OTBUILDER parent) {
			super(uid, id, uidType, parent);
			withExtension(extension, getBuildable(templateSet));
		}

		private void withExtension(String extension, TemplateSet templateSet) {
			when(getBuildable().getExtension(templateSet)).thenReturn(extension);
		}

		@Override
		public final EBUILDER aStoredUrl(String storedUrl, LanguageBuilder language, TemplateSetBuilder templateSet, Object multiPageObject) {
			when(getBuildable().getStoredUrl(getBuildable(language), getBuildable(templateSet), multiPageObject)).thenReturn(storedUrl);
			return getInterfaceBuilder();
		}
	}

	public interface TruncatedContentProducerBuilder<T extends ContentProducer> extends ContentProducerBuilder<T, TruncatedContentProducerBuilder<T>> {
	}

	private static final class TruncatedDefaultContentProducerBuilder<T extends ContentProducer> extends DefaultContentProducerBuilder<T, TruncatedContentProducerBuilder<T>, TruncatedDefaultContentProducerBuilder<T>> implements TruncatedContentProducerBuilder<T> {

		<OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultContentProducerBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
			super(uid, id, uidType, parent);
		}

		<OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultContentProducerBuilder(String uid, long id, UidType uidType, String extension, TemplateSetBuilder templateSet, OTBUILDER parent) {
			super(uid, id, uidType, extension, templateSet, parent);
		}
	}
}