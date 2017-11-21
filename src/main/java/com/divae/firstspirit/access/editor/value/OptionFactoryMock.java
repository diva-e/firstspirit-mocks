package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.editor.value.OptionMock.OptionBuilder;
import com.divae.firstspirit.access.editor.value.OptionModelMock.OptionModelBuilder;
import com.divae.firstspirit.agency.SpecialistsBrokerMock.SpecialistsBrokerBuilder;
import de.espirit.firstspirit.access.editor.value.OptionFactory;
import de.espirit.firstspirit.access.editor.value.OptionModel;
import de.espirit.firstspirit.agency.SpecialistsBroker;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class OptionFactoryMock {

    private OptionFactoryMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static OptionFactoryBuilder optionFactoryWith() {
        return new DefaultOptionFactoryBuilder();
    }

    public interface OptionFactoryBuilder extends Builder<OptionFactory, OptionFactoryBuilder> {
        OptionFactoryBuilder create(OptionBuilder option, Object object);

        <O extends OptionModel, OBUILDER extends OptionModelBuilder<O, OBUILDER>, S extends SpecialistsBroker, SBUILDER extends SpecialistsBrokerBuilder<S, SBUILDER>> OptionFactoryBuilder anOptionModel(Supplier<OBUILDER> supplier, SBUILDER specialistsBroker, LanguageBuilder language, boolean release);
    }

    public static final class DefaultOptionFactoryBuilder extends DefaultBuilder<OptionFactory, OptionFactoryBuilder, DefaultOptionFactoryBuilder> implements OptionFactoryBuilder {

        private DefaultOptionFactoryBuilder() {
        }

        @Override
        public final OptionFactoryBuilder create(OptionBuilder option, Object object) {
            when(getBuildable().create(object)).thenReturn(getBuildable(option));
            return getBuilder();
        }

        @Override
        public final <O extends OptionModel, OBUILDER extends OptionModelBuilder<O, OBUILDER>, S extends SpecialistsBroker, SBUILDER extends SpecialistsBrokerBuilder<S, SBUILDER>> OptionFactoryBuilder anOptionModel(Supplier<OBUILDER> supplier, SBUILDER specialistsBroker, LanguageBuilder language, boolean release) {
            OptionModel optionModel = build(supplier.get());
            when(getBuildable().getOptionModel(getBuildable(specialistsBroker), getBuildable(language), release)).thenReturn(optionModel);
            return getBuilder();
        }
    }
}