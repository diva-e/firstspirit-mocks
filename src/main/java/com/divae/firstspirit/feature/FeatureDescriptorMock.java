package com.divae.firstspirit.feature;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.feature.FeatureDescriptor;

public final class FeatureDescriptorMock {

    private FeatureDescriptorMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static FeatureDescriptorBuilder featureDescriptorWith() {
        return new DefaultFeatureDescriptorBuilder();
    }

    public interface FeatureDescriptorBuilder extends Builder<FeatureDescriptor, FeatureDescriptorBuilder> {
    }

    private static final class DefaultFeatureDescriptorBuilder extends DefaultBuilder<FeatureDescriptor, FeatureDescriptorBuilder, DefaultFeatureDescriptorBuilder> implements FeatureDescriptorBuilder {

        private DefaultFeatureDescriptorBuilder() {
        }
    }

}
