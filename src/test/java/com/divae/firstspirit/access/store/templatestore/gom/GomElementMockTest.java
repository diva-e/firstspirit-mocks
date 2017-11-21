package com.divae.firstspirit.access.store.templatestore.gom;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.templatestore.gom.GomIncludeConfigurationMock.TruncatedGomIncludeConfigurationBuilder;
import de.espirit.firstspirit.access.store.templatestore.gom.GomElement;
import de.espirit.firstspirit.access.store.templatestore.gom.GomIncludeConfiguration;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.templatestore.gom.GomElementMock.gomElementWith;
import static com.divae.firstspirit.access.store.templatestore.gom.GomIncludeConfigurationMock.gomIncludeConfigurationWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GomElementMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return GomElementMock.class;
    }

    @Test
    public void testAnIncludeConfiguration() {
        final TruncatedGomIncludeConfigurationBuilder<GomIncludeConfiguration> gomIncludeConfiguration = gomIncludeConfigurationWith();
        final GomElement gomElement = build(gomElementWith().anIncludeConfiguration(() -> gomIncludeConfiguration));
        assertThat(gomElement.getIncludeConfiguration(), is(build(gomIncludeConfiguration)));
    }
}