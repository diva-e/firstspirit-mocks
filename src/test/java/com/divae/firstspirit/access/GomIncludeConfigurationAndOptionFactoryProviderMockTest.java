package com.divae.firstspirit.access;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.editor.value.OptionFactoryMock;
import de.espirit.firstspirit.access.editor.value.OptionFactory;
import de.espirit.firstspirit.access.editor.value.OptionFactoryProvider;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.GomIncludeConfigurationAndOptionFactoryProviderMock.gomIncludeConfigurationAndOptionsFactoryProviderWith;
import static com.divae.firstspirit.access.editor.value.OptionFactoryMock.optionFactoryWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GomIncludeConfigurationAndOptionFactoryProviderMockTest extends MockTest {
    @Override
    protected Class<?> getFactoryClass() {
        return GomIncludeConfigurationAndOptionFactoryProviderMock.class;
    }

    @Test
    public void anOptionFactory() throws Exception {
        OptionFactoryMock.OptionFactoryBuilder optionFactoryBuilder = optionFactoryWith();
        OptionFactoryProvider optionFactoryProvider = build(gomIncludeConfigurationAndOptionsFactoryProviderWith().anOptionFactory(optionFactoryBuilder));
        OptionFactory optionFactory = build(optionFactoryBuilder);
        assertThat(optionFactoryProvider.getOptionFactory(), is(optionFactory));
    }
}