package com.divae.firstspirit.feature;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.ServerActionHandleMock;
import com.divae.firstspirit.feature.FeatureDescriptorMock.FeatureDescriptorBuilder;
import de.espirit.firstspirit.feature.FeatureAgent;
import de.espirit.firstspirit.feature.FeatureDescriptor;
import de.espirit.firstspirit.feature.FeatureFile;
import de.espirit.firstspirit.feature.FeatureProgress;
import de.espirit.firstspirit.storage.Revision;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.feature.FeatureAgentMock.featureAgentWith;
import static com.divae.firstspirit.feature.FeatureDescriptorMock.featureDescriptorWith;
import static com.divae.firstspirit.feature.FeatureFileMock.featureFileWith;
import static com.divae.firstspirit.storage.RevisionMock.revisionWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class FeatureAgentMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return FeatureAgentMock.class;
    }

    @Test
    public void testCreatesFeature() {
        Revision revision = build(revisionWith(1L));
        FeatureAgent featureAgent = build(featureAgentWith().createsFeature(FeatureDescriptorMock::featureDescriptorWith, "name", revision, true));
        assertThat(featureAgent.createFeature("name", revision, true), is(notNullValue()));
    }

    @Test
    public void testCreatesFeatureModel() {
        FeatureDescriptorBuilder featureDescriptorBuilder = featureDescriptorWith();
        FeatureAgent featureAgent = build(featureAgentWith().createsFeatureModel(FeatureModelMock::featureModelWith, featureDescriptorBuilder));
        FeatureDescriptor featureDescriptor = build(featureDescriptorBuilder);
        assertThat(featureAgent.createFeatureModel(featureDescriptor), is(notNullValue()));
    }

    @Test
    public void testCreatesFeatureTransportFile() {
        FeatureDescriptorBuilder featureDescriptorBuilder = featureDescriptorWith();
        FeatureAgent featureAgent = build(featureAgentWith().createsFeatureTransportFile(ServerActionHandleMock::<FeatureProgress, Boolean>serverActionHandleWith, featureDescriptorBuilder));
        FeatureDescriptor featureDescriptor = build(featureDescriptorBuilder);
        assertThat(featureAgent.createFeatureTransportFile(featureDescriptor), is(notNullValue()));
    }

    @Test
    public void testADownloadFeatureFile() throws IOException {
        FeatureFileMock.FeatureFileBuilder featureFileBuilder = featureFileWith();
        InputStream inputStream = mock(InputStream.class);
        FeatureAgent featureAgent = build(featureAgentWith().aDownloadFeatureFile(inputStream, featureFileBuilder));
        FeatureFile featureFile = build(featureFileBuilder);
        assertThat(featureAgent.downloadFeatureFile(featureFile), is(inputStream));
    }
}
