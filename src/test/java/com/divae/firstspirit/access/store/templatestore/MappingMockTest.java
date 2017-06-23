package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.or.schema.AttributeMock;
import de.espirit.firstspirit.access.store.templatestore.TableTemplate.Mapping;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.store.templatestore.MappingMock.mappingWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class MappingMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return MappingMock.class;
    }

    @Test
    public void testAName() {
        Mapping mapping = build(mappingWith().aName("name"));
        assertThat(mapping.getName(), is("name"));
    }

    @Test
    public void testADBAttribute() {
        Mapping mapping = build(mappingWith().aDBAttribute(AttributeMock::attributeWith, languageWith("DE")));
        assertThat(mapping.getDBAttribute("DE"), is(notNullValue()));
    }
}
