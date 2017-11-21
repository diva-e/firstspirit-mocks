package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.globalstore.URLProperties;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.globalstore.URLPropertiesMock.urlPropertiesWith;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class URLPropertiesMockTest extends MockTest {

    @Test
    public void testUrlPropertiesWith() {
        assertThat(urlPropertiesWith("urlProperties", 1, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return URLPropertiesMock.class;
    }

    @Test
    public void testWithLock() {
        URLProperties urlProperties = build(urlPropertiesWith("urlProperties", 1, null).isLocked(true));
        assertThat(urlProperties.isLocked(), is(TRUE));
    }
}
