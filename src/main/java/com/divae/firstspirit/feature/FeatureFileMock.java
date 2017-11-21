package com.divae.firstspirit.feature;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.feature.FeatureFile;

public final class FeatureFileMock {

    private FeatureFileMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static FeatureFileBuilder featureFileWith() {
        return new DefaultFeatureFileBuilder();
    }

    public interface FeatureFileBuilder extends Builder<FeatureFile, FeatureFileBuilder> {
    }

    private static final class DefaultFeatureFileBuilder extends DefaultBuilder<FeatureFile, FeatureFileBuilder, DefaultFeatureFileBuilder> implements FeatureFileBuilder {

        private DefaultFeatureFileBuilder() {
        }
    }

}
