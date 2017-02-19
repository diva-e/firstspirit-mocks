package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.editor.value.OptionMock.OptionBuilder;
import de.espirit.firstspirit.access.editor.value.Option;
import de.espirit.firstspirit.access.editor.value.OptionFactory;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.editor.value.OptionFactoryMock.optionFactoryWith;
import static com.divae.firstspirit.access.editor.value.OptionMock.optionWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OptionFactoryMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return OptionFactoryMock.class;
	}

	@Test
	public void create() throws Exception {
		OptionBuilder optionBuilder = optionWith();
		OptionFactory optionFactory = build(optionFactoryWith().create(optionBuilder, "test"));
		Option option = build(optionBuilder);
		assertThat(optionFactory.create("test"), is(option));
	}

}