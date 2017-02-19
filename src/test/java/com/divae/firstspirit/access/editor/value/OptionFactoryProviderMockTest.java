package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.editor.value.OptionFactoryMock.OptionFactoryBuilder;
import de.espirit.firstspirit.access.editor.value.OptionFactory;
import de.espirit.firstspirit.access.editor.value.OptionFactoryProvider;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.editor.value.OptionFactoryMock.optionFactoryWith;
import static com.divae.firstspirit.access.editor.value.OptionFactoryProviderMock.optionFactoryProviderWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OptionFactoryProviderMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return OptionFactoryProviderMock.class;
	}

	@Test
	public void anOptionFactory() throws Exception {
		OptionFactoryBuilder optionFactoryBuilder = optionFactoryWith();
		OptionFactoryProvider optionFactoryProvider = build(optionFactoryProviderWith().anOptionFactory(optionFactoryBuilder));
		OptionFactory optionFactory = build(optionFactoryBuilder);
		assertThat(optionFactoryProvider.getOptionFactory(), is(optionFactory));
	}

}