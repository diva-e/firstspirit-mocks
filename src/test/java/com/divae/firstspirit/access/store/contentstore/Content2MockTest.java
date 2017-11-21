package com.divae.firstspirit.access.store.contentstore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.templatestore.SchemaMock;
import de.espirit.firstspirit.access.store.contentstore.Content2;
import de.espirit.firstspirit.access.store.contentstore.Dataset;
import de.espirit.firstspirit.access.store.templatestore.Schema;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.contentstore.Content2Mock.content2With;
import static com.divae.firstspirit.access.store.contentstore.ContentStoreRootMock.contentStoreRootWith;
import static com.divae.firstspirit.access.store.contentstore.DatasetMock.datasetWith;
import static com.divae.firstspirit.access.store.templatestore.SchemaMock.schemaWith;
import static com.divae.firstspirit.or.schema.EntityMock.entityWith;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class Content2MockTest extends MockTest {

    @Test
    public void testContent2With() {
        assertThat(content2With("test", 2, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return Content2Mock.class;
    }

    @Test
    public void testASchema() {
        SchemaMock.SchemaBuilder schemaBuilder = schemaWith("schema", 2, null);
        Content2 content2 = build(content2With("content2", 2, null).aSchema(schemaBuilder));
        Schema schema = build(schemaBuilder);
        assertThat(content2.getSchema(), is(schema));
    }

    @Test
    public void testWithEntityTypeName() {
        String entityTypeName = "test";
        Content2 content2 = build(content2With("content2", 2, null).anEntityTypeName(entityTypeName));
        assertThat(content2.getEntityType().getName(), is(entityTypeName));
    }

    @Test
    public void testWithName() {
        String name = "test";
        Content2 content2 = build(content2With("test", 2, null).aName(name));
        assertThat(content2.getName(), is(name));
    }

    @Test
    public void testWithDataset() {
        Content2 content2 = (Content2) build(contentStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> singletonList(content2With("content2", 2, parent).datasets(datasetParent -> singletonList(datasetWith("dataset", 3, datasetParent)))))).getChildren().iterator().next();
        List<Dataset> datasets = content2.getDatasets();
        assertThat(datasets.size(), is(1));
        assertThat(datasets.get(0).getName(), is("dataset"));
    }

    @Test
    public void testWithADataset() {
        Content2 content2 = (Content2) build(contentStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent -> singletonList(content2With("content2", 2, parent).aDataset(datasetParent -> datasetWith("dataset", 3, datasetParent), () -> entityWith(new UUID(0, 0)))))).getChildren().iterator().next();
        Dataset dataset = content2.getDatasets().get(0);
        assertThat(content2.getDataset(dataset.getEntity()), is(dataset));
    }
}
