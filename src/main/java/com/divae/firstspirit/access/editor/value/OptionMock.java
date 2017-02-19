package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.editor.value.Option;

import static org.mockito.Mockito.when;

public final class OptionMock {

	private OptionMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static OptionBuilder optionWith() {
		return new DefaultOptionBuilder();
	}

	public interface OptionBuilder extends Builder<Option, OptionBuilder> {
		OptionBuilder aValue(Object object);

		OptionBuilder aKey(String key);
	}

	public static final class DefaultOptionBuilder extends DefaultBuilder<Option, OptionBuilder, DefaultOptionBuilder> implements OptionBuilder {

		private DefaultOptionBuilder() {
		}

		@Override
		public final OptionBuilder aValue(Object object) {
			when(getBuildable().getValue()).thenReturn(object);
			return getBuilder();
		}

		@Override
		public final OptionBuilder aKey(String key) {
			when(getBuildable().getKey()).thenReturn(key);
			return getBuilder();
		}

	}
}
