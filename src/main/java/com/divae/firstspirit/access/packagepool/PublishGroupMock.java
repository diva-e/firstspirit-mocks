package com.divae.firstspirit.access.packagepool;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.packagepool.PublishGroup;

import static org.mockito.Mockito.when;

public final class PublishGroupMock {

    private PublishGroupMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static PublishGroupBuilder publishGroupWith(long id) {
        return new DefaultPublishGroupBuilder(id);
    }

    public interface PublishGroupBuilder extends Builder<PublishGroup, PublishGroupBuilder> {
        PublishGroupBuilder aName(String name);
    }

    public static final class DefaultPublishGroupBuilder extends DefaultBuilder<PublishGroup, PublishGroupBuilder, DefaultPublishGroupBuilder> implements PublishGroupBuilder {

        private DefaultPublishGroupBuilder(long id) {
            super(id);
            anId(id);
        }

        @Override
        public final PublishGroupBuilder aName(String name) {
            when(getBuildable().getName()).thenReturn(name);
            return getBuilder();
        }

        private void anId(long id) {
            when(getBuildable().getId()).thenReturn(id);
        }
    }
}
