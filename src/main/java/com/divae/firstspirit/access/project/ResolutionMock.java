package com.divae.firstspirit.access.project;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.project.Resolution;

import static org.mockito.Mockito.when;

public final class ResolutionMock {

    private ResolutionMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static ResolutionBuilder resolutionWith(String uid) {
        return new DefaultResolutionBuilder(uid);
    }

    public interface ResolutionBuilder extends Builder<Resolution, ResolutionBuilder> {
        ResolutionBuilder aWidth(int width);

        ResolutionBuilder aHeight(int height);
    }

    public static final class DefaultResolutionBuilder extends DefaultBuilder<Resolution, ResolutionBuilder, DefaultResolutionBuilder> implements ResolutionBuilder {

        private DefaultResolutionBuilder(String uid) {
            super(uid);
            withUid(uid);
        }

        @Override
        public final ResolutionBuilder aWidth(int width) {
            when(getBuildable().getWidth()).thenReturn(width);
            return getBuilder();
        }

        @Override
        public final ResolutionBuilder aHeight(int height) {
            when(getBuildable().getHeight()).thenReturn(height);
            return getBuilder();
        }

        private void withUid(String uid) {
            when(getBuildable().getUid()).thenReturn(uid);
        }
    }
}
