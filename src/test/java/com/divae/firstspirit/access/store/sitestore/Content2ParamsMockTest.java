package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.sitestore.Content2Params;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.sitestore.Content2ParamsMock.content2ParamsWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class Content2ParamsMockTest extends MockTest {

    @Test
    public void testContent2ParamsWith() {
        assertThat(content2ParamsWith("content2Params", null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return Content2ParamsMock.class;
    }

    @Test
    public void testContent2Params() {
        assertThat(content2ParamsWith("content2Params", null), is(notNullValue()));
    }

    @Test
    public void testASitemapVariableName() {
        String sitemapVariableName = "test";
        Content2Params content2Params = build(content2ParamsWith("content2Params", null).aSitemapVariableName(sitemapVariableName));
        assertThat(content2Params.getSitemapVariableName(), is(sitemapVariableName));
    }
}
