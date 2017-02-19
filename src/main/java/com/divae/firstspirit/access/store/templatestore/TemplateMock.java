package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.StoreElementMock.StoreElementBuilder;
import com.divae.firstspirit.access.store.templatestore.ChannelSourceProviderMock.ChannelSourceProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.ChannelSourceProviderMock.DefaultChannelSourceProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.GomSourceProviderMock.GomSourceProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.GomSourceProviderMock.TruncatedGomSourceProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.PreviewImageProviderMock.PreviewImageProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreElementMock.TemplateStoreElementBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.templatestore.Template;

import static com.divae.firstspirit.access.store.templatestore.GomSourceProviderMock.gomSourceProviderWith;

public final class TemplateMock {

	private TemplateMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends Template, TBUILDER extends TemplateBuilder<T, TBUILDER>, E extends IDProvider, EBUILDER extends IDProviderBuilder<E, EBUILDER>> TruncatedTemplateBuilder<T> templateWith(String uid, long id, UidType uidType, EBUILDER parent) {
		return new TruncatedDefaultTemplateBuilder<>(uid, id, uidType, parent);
	}

	public interface TemplateBuilder<T extends Template, TBUILDER extends TemplateBuilder<T, TBUILDER>> extends ChannelSourceProviderBuilder<T, TBUILDER>, GomSourceProviderBuilder<T, TBUILDER>, TemplateStoreElementBuilder<T, TBUILDER>, PreviewImageProviderBuilder<T, TBUILDER>, StoreElementBuilder<T, TBUILDER> {
	}

	public static class DefaultTemplateBuilder<T extends Template, EBUILDER extends TemplateBuilder<T, EBUILDER>, TBUILDER extends DefaultTemplateBuilder<T, EBUILDER, TBUILDER>> extends DefaultChannelSourceProviderBuilder<T, EBUILDER, TBUILDER> implements TemplateBuilder<T, EBUILDER> {

		private final TruncatedGomSourceProviderBuilder<T> gomSourceProviderBuilder;

		protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultTemplateBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
			super(uid, id, uidType, parent);
			gomSourceProviderBuilder = gomSourceProviderWith(getInterfaceBuilder());
		}

		@Override
		public final EBUILDER aGomSource(String gomSource) {
			gomSourceProviderBuilder.aGomSource(gomSource);
			return getInterfaceBuilder();
		}
	}

	public interface TruncatedTemplateBuilder<T extends Template> extends TemplateBuilder<T, TruncatedTemplateBuilder<T>> {
	}

	private static final class TruncatedDefaultTemplateBuilder<T extends Template> extends DefaultTemplateBuilder<T, TruncatedTemplateBuilder<T>, TruncatedDefaultTemplateBuilder<T>> implements TruncatedTemplateBuilder<T> {

		<OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultTemplateBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
			super(uid, id, uidType, parent);
		}
	}
}
