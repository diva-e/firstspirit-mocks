package com.divae.firstspirit.feature;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.feature.FeatureProgress;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.feature.FeatureProgressMock.featureProgressWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class FeatureProgressMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return FeatureProgressMock.class;
    }

    @Test
    public void testAFeatureFile() {
        FeatureProgress featureProgress = build(featureProgressWith().aFeatureFile(FeatureFileMock::featureFileWith));
        assertThat(featureProgress.getFeatureFile(), is(notNullValue()));
    }
}
