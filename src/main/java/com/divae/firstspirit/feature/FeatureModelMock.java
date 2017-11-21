package com.divae.firstspirit.feature;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.feature.FeatureModel;

public final class FeatureModelMock {

    private FeatureModelMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static FeatureModelBuilder featureModelWith() {
        return new DefaultFeatureModelBuilder();
    }

    public interface FeatureModelBuilder extends Builder<FeatureModel, FeatureModelBuilder> {
    }

    private static final class DefaultFeatureModelBuilder extends DefaultBuilder<FeatureModel, FeatureModelBuilder, DefaultFeatureModelBuilder> implements FeatureModelBuilder {

        private DefaultFeatureModelBuilder() {
        }
    }
}
