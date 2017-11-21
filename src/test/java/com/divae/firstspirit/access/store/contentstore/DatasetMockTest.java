package com.divae.firstspirit.access.store.contentstore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.or.schema.EntityMock;
import de.espirit.firstspirit.access.store.contentstore.Dataset;
import de.espirit.or.schema.Entity;
import org.junit.Test;

import java.util.UUID;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.contentstore.DatasetMock.datasetWith;
import static com.divae.firstspirit.or.schema.EntityMock.entityWith;
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
    public void testWithAnEntity() {
        String uid = "test";
        EntityMock.EntityBuilder entityBuilder = entityWith(new UUID(0, 0));
        Dataset dataset = build(datasetWith(uid, 2, null).anEntity(entityBuilder));
        Entity entity = build(entityBuilder);
        assertThat(dataset.getEntity(), is(entity));
    }
}
