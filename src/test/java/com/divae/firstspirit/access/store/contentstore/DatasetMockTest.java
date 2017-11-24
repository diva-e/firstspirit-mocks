package com.divae.firstspirit.access.store.contentstore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.store.templatestore.TableTemplateMock.TableTemplateBuilder;
import com.divae.firstspirit.or.schema.EntityMock.EntityBuilder;
import de.espirit.firstspirit.access.store.contentstore.Dataset;
import de.espirit.or.schema.Entity;
import org.junit.Test;

import java.util.UUID;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.contentstore.DatasetMock.datasetWith;
import static com.divae.firstspirit.access.store.templatestore.TableTemplateMock.tableTemplateWith;
import static com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.templateStoreRootWith;
import static com.divae.firstspirit.or.schema.EntityMock.entityWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE_SCHEMA;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class DatasetMockTest extends MockTest {

    @Test
    public void testDatasetWith() {
        assertThat(datasetWith("test", 2, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return DatasetMock.class;
    }

    @Test
    public void testAnEntity() {
        String uid = "test";
        EntityBuilder entityBuilder = entityWith(new UUID(0, 0));
        Dataset dataset = build(datasetWith(uid, 2, null).anEntity(entityBuilder));
        Entity entity = build(entityBuilder);
        assertThat(dataset.getEntity(), is(entity));
    }

    @Test
    public void testATableTemplate() {
        final TableTemplateBuilder templateTemplate = tableTemplateWith("test", 4L, TEMPLATESTORE_SCHEMA, templateStoreRootWith(1L, projectWith("project", 0L, languageWith("DE"))));
        Dataset dataset = build(datasetWith("dataset", 2, null).aTableTemplate(templateTemplate));
        assertThat(dataset.getTableTemplate().getUid(), is("test"));
    }
}
