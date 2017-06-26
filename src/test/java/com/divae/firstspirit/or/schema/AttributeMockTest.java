package com.divae.firstspirit.or.schema;

import com.divae.firstspirit.MockTest;
import de.espirit.or.schema.Attribute;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AttributeMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return AttributeMock.class;
    }

    @Test
    public void testAName() {
        Attribute<String> attribute = build(AttributeMock.<String>attributeWith().aName("name"));
        assertThat(attribute.getName(), is("name"));
    }
}
