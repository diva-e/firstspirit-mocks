package com.divae.firstspirit.generate.path;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.generate.path.IDProviderKey;

import static org.mockito.Mockito.when;

public final class IDProviderKeyMock {

    private IDProviderKeyMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static IDProviderKeyBuilder idProviderKeyWith() {
        return new DefaultIDProviderKeyBuilder();
    }

    public interface IDProviderKeyBuilder extends Builder<IDProviderKey, IDProviderKeyBuilder> {
        IDProviderKeyBuilder aNodeId(long nodeId);
    }

    public static final class DefaultIDProviderKeyBuilder extends DefaultBuilder<IDProviderKey, IDProviderKeyBuilder, DefaultIDProviderKeyBuilder> implements IDProviderKeyBuilder {

        private DefaultIDProviderKeyBuilder() {
        }

        @Override
        public final IDProviderKeyBuilder aNodeId(long nodeId) {
            when(getBuildable().getNodeId()).thenReturn(nodeId);
            return getBuilder();
        }
    }

}
