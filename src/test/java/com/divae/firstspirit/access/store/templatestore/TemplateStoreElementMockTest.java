package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import org.junit.Test;

import static com.divae.firstspirit.access.store.templatestore.TemplateStoreElementMock.templateStoreElementWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TemplateStoreElementMockTest extends MockTest {

    @Test
    public void testTemplateStoreElementWith() {
        assertThat(templateStoreElementWith("test", 2, TEMPLATESTORE, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return TemplateStoreElementMock.class;
    }
}
