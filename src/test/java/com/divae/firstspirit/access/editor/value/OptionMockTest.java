package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.editor.value.Option;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.editor.value.OptionMock.optionWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OptionMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return OptionMock.class;
    }

    @Test
    public void testAValue() {
        String value = "test";
        Option option = build(optionWith().aValue(value));
        assertThat(option.getValue(), is(value));
    }

    @Test
    public void testAKey() {
        String key = "test";
        Option option = build(optionWith().aKey(key));
        assertThat(option.getKey(), is(key));
    }
}
