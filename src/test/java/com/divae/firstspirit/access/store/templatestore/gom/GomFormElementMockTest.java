package com.divae.firstspirit.access.store.templatestore.gom;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.templatestore.gom.GomFormElement;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.templatestore.gom.GomFormElementMock.gomFormElementWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GomFormElementMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return GomFormElementMock.class;
    }

    @Test
    public void testDefaults() {
        GomFormElement gomFormElement = build(gomFormElementWith("test"));
        assertThat(gomFormElement.name(), is("test"));
    }
}
