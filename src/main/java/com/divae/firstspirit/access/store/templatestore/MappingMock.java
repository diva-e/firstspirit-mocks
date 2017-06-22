package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.store.templatestore.TableTemplate.Mapping;

public final class MappingMock {

    private MappingMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static MappingBuilder mappingWith() {
        return new DefaultMappingBuilder();
    }

    public interface MappingBuilder extends Builder<Mapping, MappingBuilder> {
    }

    public static final class DefaultMappingBuilder extends DefaultBuilder<Mapping, MappingBuilder, DefaultMappingBuilder> implements MappingBuilder {

        private DefaultMappingBuilder() {
        }
    }
}
