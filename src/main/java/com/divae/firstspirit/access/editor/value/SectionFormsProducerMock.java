package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.editor.FormDataProducerMock.DefaultFormDataProducerBuilder;
import com.divae.firstspirit.access.editor.FormDataProducerMock.FormDataProducerBuilder;
import com.divae.firstspirit.access.editor.fslist.IdProvidingFormDataMock.IdProvidingFormDataBuilder;
import com.divae.firstspirit.access.store.templatestore.SectionTemplateMock.SectionTemplateBuilder;
import de.espirit.firstspirit.access.editor.fslist.IdProvidingFormData;
import de.espirit.firstspirit.access.editor.value.SectionFormsProducer;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplate;

import java.util.List;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class SectionFormsProducerMock {

    private SectionFormsProducerMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static SectionFormsProducerBuilder sectionFormsProducerWith() {
        return new DefaultSectionFormsProducerBuilder();
    }

    public interface SectionFormsProducerBuilder extends FormDataProducerBuilder<SectionFormsProducer, SectionFormsProducerBuilder> {
        <OT extends SectionTemplate, OTBUILDER extends SectionTemplateBuilder<OT, OTBUILDER>> SectionFormsProducerBuilder creates(Supplier<IdProvidingFormDataBuilder> supplier, OTBUILDER withSectionTemplate);

        <OT extends SectionTemplate, OTBUILDER extends SectionTemplateBuilder<OT, OTBUILDER>> SectionFormsProducerBuilder allowedTemplates(List<OTBUILDER> sectionTemplates);
    }

    public static final class DefaultSectionFormsProducerBuilder extends DefaultFormDataProducerBuilder<SectionFormsProducer, SectionFormsProducerBuilder, DefaultSectionFormsProducerBuilder> implements SectionFormsProducerBuilder {

        private DefaultSectionFormsProducerBuilder() {
        }

        @Override
        public final <OT extends SectionTemplate, OTBUILDER extends SectionTemplateBuilder<OT, OTBUILDER>> SectionFormsProducerBuilder creates(Supplier<IdProvidingFormDataBuilder> supplier, OTBUILDER sectionTemplate) {
            IdProvidingFormData idProvidingFormData = build(supplier.get());
            when(getBuildable().create(getBuildable(sectionTemplate))).thenReturn(idProvidingFormData);
            return getBuilder();
        }

        @Override
        public final <OT extends SectionTemplate, OTBUILDER extends SectionTemplateBuilder<OT, OTBUILDER>> SectionFormsProducerBuilder allowedTemplates(List<OTBUILDER> sectionTemplates) {
            when(getBuildable().getAllowedTemplates()).thenReturn(sectionTemplates.stream().map(DefaultBuilder::getBuildable).collect(toList()));
            return getBuilder();
        }
    }
}
