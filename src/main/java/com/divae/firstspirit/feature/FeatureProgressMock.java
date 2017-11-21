package com.divae.firstspirit.feature;

import com.divae.firstspirit.access.ActionProgressMock.ActionProgressBuilder;
import com.divae.firstspirit.access.ActionProgressMock.DefaultActionProgressBuilder;
import com.divae.firstspirit.feature.FeatureFileMock.FeatureFileBuilder;
import de.espirit.firstspirit.feature.FeatureFile;
import de.espirit.firstspirit.feature.FeatureProgress;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class FeatureProgressMock {

    private FeatureProgressMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static FeatureProgressBuilder featureProgressWith() {
        return new DefaultFeatureProgressBuilder();
    }

    public interface FeatureProgressBuilder extends ActionProgressBuilder<FeatureProgress, FeatureProgressBuilder> {
        FeatureProgressBuilder aFeatureFile(Supplier<FeatureFileBuilder> supplier);
    }

    public static final class DefaultFeatureProgressBuilder extends DefaultActionProgressBuilder<FeatureProgress, FeatureProgressBuilder, DefaultFeatureProgressBuilder> implements FeatureProgressBuilder {

        private DefaultFeatureProgressBuilder() {
        }

        @Override
        public final FeatureProgressBuilder aFeatureFile(Supplier<FeatureFileBuilder> supplier) {
            FeatureFile featureFile = build(supplier.get());
            when(getBuildable().getFeatureFile()).thenReturn(featureFile);
            return getBuilder();
        }

    }
}
