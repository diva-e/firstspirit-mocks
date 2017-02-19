package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.editor.value.OptionMock.OptionBuilder;
import de.espirit.firstspirit.access.editor.value.OptionFactory;

import static org.mockito.Mockito.when;

public final class OptionFactoryMock {

	private OptionFactoryMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static OptionFactoryBuilder optionFactoryWith() {
		return new DefaultOptionFactoryBuilder();
	}

	public interface OptionFactoryBuilder extends Builder<OptionFactory, OptionFactoryBuilder> {
		OptionFactoryBuilder create(OptionBuilder option, Object object);
	}

	public static final class DefaultOptionFactoryBuilder extends DefaultBuilder<OptionFactory, OptionFactoryBuilder, DefaultOptionFactoryBuilder> implements OptionFactoryBuilder {

		private DefaultOptionFactoryBuilder() {
		}

		@Override
		public final OptionFactoryBuilder create(OptionBuilder option, Object object) {
			when(getBuildable().create(object)).thenReturn(getBuildable(option));
			return getBuilder();
		}
	}
}
