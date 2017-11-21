package com.divae.firstspirit.access;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.ScriptContext;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.ScriptContextMock.scriptContextWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ScriptContextMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return ScriptContextMock.class;
    }

    @Test
    public void testAProperty() {
        String key = "key";
        String value = "value";
        ScriptContext scriptContext = build(scriptContextWith().aProperty(value, key));
        assertThat(scriptContext.getProperty(key), is(value));
    }
}
