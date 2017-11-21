package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.editor.value.DatasetContainerMock.DatasetContainerBuilder;
import com.divae.firstspirit.access.store.contentstore.Content2Mock;
import com.divae.firstspirit.access.store.contentstore.DatasetMock.DatasetBuilder;
import de.espirit.firstspirit.access.editor.value.DatasetContainer;
import org.junit.Test;

import java.util.UUID;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.editor.value.DatasetContainerMock.datasetContainerWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.contentstore.ContentStoreRootMock.contentStoreRootWith;
import static com.divae.firstspirit.access.store.contentstore.DatasetMock.datasetWith;
import static com.divae.firstspirit.or.schema.EntityMock.entityWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class DatasetContainerMockTest extends MockTest {

    @Test
    public void testDatasetContainerWith() {
        assertThat(datasetContainerWith(new UUID(0, 0)), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return DatasetContainerMock.class;
    }

    @Test
    public void testDatasetContainer() {
        assertThat(datasetContainerWith(new UUID(0, 0)), is(notNullValue()));
    }

    @Test
    public void testADataset() {
        DatasetContainerBuilder datasetContainerBuilder = datasetContainerWith(new UUID(0, 0));
        Content2Mock.content2With("content2", 2, contentStoreRootWith(1, projectWith("project", 0, languageWith("DE")))).aDataset(parent -> {
            DatasetBuilder datasetBuilder = datasetWith("dataset", 3, parent);
            datasetContainerBuilder.aDataset(datasetBuilder);
            return datasetBuilder;
        }, () -> entityWith(null));
        DatasetContainer datasetContainer = build(datasetContainerBuilder);
        assertThat(datasetContainer.getDataset().getId(), is(3L));
    }
}
