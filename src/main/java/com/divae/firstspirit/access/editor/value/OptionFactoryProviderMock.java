package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.editor.value.OptionFactoryMock.OptionFactoryBuilder;
import de.espirit.firstspirit.access.editor.value.OptionFactoryProvider;

import static org.mockito.Mockito.when;

public final class OptionFactoryProviderMock {

	private OptionFactoryProviderMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static OptionFactoryProviderBuilder optionFactoryProviderWith() {
		return new DefaultOptionFactoryProviderBuilder();
	}

	public interface OptionFactoryProviderBuilder extends Builder<OptionFactoryProvider, OptionFactoryProviderBuilder> {
		OptionFactoryProviderBuilder anOptionFactory(OptionFactoryBuilder optionFactory);
	}

	public static final class DefaultOptionFactoryProviderBuilder extends DefaultBuilder<OptionFactoryProvider, OptionFactoryProviderBuilder, DefaultOptionFactoryProviderBuilder> implements OptionFactoryProviderBuilder {

		private DefaultOptionFactoryProviderBuilder() {
		}

		@Override
		public final OptionFactoryProviderBuilder anOptionFactory(OptionFactoryBuilder optionFactory) {
			when(getBuildable().getOptionFactory()).thenReturn(getBuildable(optionFactory));
			return getBuilder();
		}
	}
}
