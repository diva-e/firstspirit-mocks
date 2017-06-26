package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.or.schema.AttributeMock.AttributeBuilder;
import de.espirit.firstspirit.access.store.templatestore.TableTemplate.Mapping;
import de.espirit.or.schema.Attribute;
import org.mockito.Mockito;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class MappingMock {

    private MappingMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static MappingBuilder mappingWith() {
        return new DefaultMappingBuilder();
    }

    public interface MappingBuilder extends Builder<Mapping, MappingBuilder> {
        MappingBuilder aName(String name);

        <T> MappingBuilder aDBAttribute(Supplier<AttributeBuilder<T>> attribute, LanguageBuilder language);
    }

    public static final class DefaultMappingBuilder extends DefaultBuilder<Mapping, MappingBuilder, DefaultMappingBuilder> implements MappingBuilder {

        private DefaultMappingBuilder() {
        }

        @Override
        public MappingBuilder aName(String name) {
            when(getBuildable().getName()).thenReturn(name);
            return getInterfaceBuilder();
        }

        @Override
        public <T> MappingBuilder aDBAttribute(Supplier<AttributeBuilder<T>> supplier, LanguageBuilder language) {
            Attribute<T> attribute = build(supplier.get());
            Mockito.<Attribute<?>>when(getBuildable().getDBAttribute(getBuildable(language).getAbbreviation())).thenReturn(attribute);
            return getInterfaceBuilder();
        }
    }
}
