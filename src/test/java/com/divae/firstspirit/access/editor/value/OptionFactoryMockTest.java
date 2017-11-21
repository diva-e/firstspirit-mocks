package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.editor.value.OptionMock.OptionBuilder;
import com.divae.firstspirit.access.editor.value.OptionModelMock.TruncatedOptionModelBuilder;
import com.divae.firstspirit.agency.SpecialistsBrokerMock.TruncatedSpecialistsBrokerBuilder;
import de.espirit.firstspirit.access.editor.value.Option;
import de.espirit.firstspirit.access.editor.value.OptionFactory;
import de.espirit.firstspirit.access.editor.value.OptionModel;
import de.espirit.firstspirit.agency.SpecialistsBroker;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.editor.value.OptionFactoryMock.optionFactoryWith;
import static com.divae.firstspirit.access.editor.value.OptionMock.optionWith;
import static com.divae.firstspirit.access.editor.value.OptionModelMock.optionModelWith;
import static com.divae.firstspirit.agency.SpecialistsBrokerMock.specialistsBrokerWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OptionFactoryMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return OptionFactoryMock.class;
    }

    @Test
    public void create() throws Exception {
        OptionBuilder optionBuilder = optionWith();
        OptionFactory optionFactory = build(optionFactoryWith().create(optionBuilder, "test"));
        Option option = build(optionBuilder);
        assertThat(optionFactory.create("test"), is(option));
    }

    @Test
    public void anOptionModel() throws Exception {
        final TruncatedSpecialistsBrokerBuilder<SpecialistsBroker> specialistsBroker = specialistsBrokerWith();
        final LanguageBuilder language = languageWith("DE");
        final TruncatedOptionModelBuilder<OptionModel> optionModel = optionModelWith();
        OptionFactory optionFactory = build(optionFactoryWith().anOptionModel(() -> optionModel, specialistsBroker, language, false));
        assertThat(optionFactory.getOptionModel(build(specialistsBroker), build(language), false), is(build(optionModel)));
    }

    @Test
    public void anOptionModelRelease() throws Exception {
        final TruncatedSpecialistsBrokerBuilder<SpecialistsBroker> specialistsBroker = specialistsBrokerWith();
        final LanguageBuilder language = languageWith("DE");
        final TruncatedOptionModelBuilder<OptionModel> optionModel = optionModelWith();
        OptionFactory optionFactory = build(optionFactoryWith().anOptionModel(() -> optionModel, specialistsBroker, language, true));
        assertThat(optionFactory.getOptionModel(build(specialistsBroker), build(language), true), is(build(optionModel)));
    }
}