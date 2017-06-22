package com.divae.firstspirit.access.store.contentstore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.templatestore.SchemaMock.SchemaBuilder;
import de.espirit.firstspirit.access.store.contentstore.DatasetProvider;
import de.espirit.firstspirit.access.store.templatestore.Schema;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.contentstore.DatasetProviderMock.datasetProviderWith;
import static com.divae.firstspirit.access.store.templatestore.SchemaMock.schemaWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DatasetProviderMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return DatasetProviderMock.class;
    }

    @Test
    public void testASchema() {
        SchemaBuilder schemaBuilder = schemaWith("schema", 2, null);
        DatasetProvider datasetProvider = build(datasetProviderWith().aSchema(schemaBuilder));
        Schema schema = build(schemaBuilder);
        assertThat(datasetProvider.getSchema(), is(schema));
    }
}
