package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.templatestore.FormatTemplateContainer;

public final class FormatTemplateContainerMock {

	private FormatTemplateContainerMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> FormatTemplateContainerBuilder formatTemplateContainerWith(String name, long id, TBUILDER parent) {
		return new DefaultFormatTemplateContainerBuilder(name, id, parent);
	}

	public interface FormatTemplateContainerBuilder extends IDProviderBuilder<FormatTemplateContainer, FormatTemplateContainerBuilder> {
	}

	public static final class DefaultFormatTemplateContainerBuilder extends DefaultIDProviderBuilder<FormatTemplateContainer, FormatTemplateContainerBuilder, DefaultFormatTemplateContainerBuilder> implements FormatTemplateContainerBuilder {

		private <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> DefaultFormatTemplateContainerBuilder(String name, long id, TBUILDER parent) {
			super(name, id, parent);
		}

	}
}
