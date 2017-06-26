package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.templatestore.MappingMock.MappingBuilder;
import de.espirit.firstspirit.access.store.templatestore.TableTemplate;
import de.espirit.firstspirit.access.store.templatestore.TableTemplate.Mapping;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.templatestore.MappingMock.mappingWith;
import static com.divae.firstspirit.access.store.templatestore.TableTemplateMock.tableTemplateWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TableTemplateMockTest extends MockTest {

    @Test
    public void testTableTemplateWith() {
        assertThat(tableTemplateWith("test", 2, TEMPLATESTORE, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return TableTemplateMock.class;
    }

    @Test
    public void testMappings() {
        TableTemplate tableTemplate = build(tableTemplateWith("test", 2, TEMPLATESTORE, null).mappings(() -> new MappingBuilder[]{mappingWith()}));
        Mapping[] mappings = tableTemplate.getMappings();
        assertThat(mappings.length, is(1));
        assertThat(mappings[0], is(notNullValue()));
    }

    @Test
    public void testMappingsBooleanTrue() {
        TableTemplate tableTemplate = build(tableTemplateWith("test", 2, TEMPLATESTORE, null).mappings(() -> new MappingBuilder[]{mappingWith()}, false));
        Mapping[] mappings = tableTemplate.getMappings(false);
        assertThat(mappings.length, is(1));
        assertThat(mappings[0], is(notNullValue()));
    }

    @Test
    public void testMappingsBooleanFalse() {
        TableTemplate tableTemplate = build(tableTemplateWith("test", 2, TEMPLATESTORE, null).mappings(() -> new MappingBuilder[]{mappingWith()}, true));
        Mapping[] mappings = tableTemplate.getMappings(true);
        assertThat(mappings.length, is(1));
        assertThat(mappings[0], is(notNullValue()));
    }
}
