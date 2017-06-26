package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.access.editor.FormDataProducerMock.DefaultFormDataProducerBuilder;
import com.divae.firstspirit.access.editor.FormDataProducerMock.FormDataProducerBuilder;
import com.divae.firstspirit.access.editor.fslist.IdProvidingFormDataMock.IdProvidingFormDataBuilder;
import com.divae.firstspirit.access.store.templatestore.TableTemplateMock.TableTemplateBuilder;
import com.divae.firstspirit.or.schema.EntityMock.EntityBuilder;
import de.espirit.firstspirit.access.editor.fslist.IdProvidingFormData;
import de.espirit.firstspirit.access.editor.value.ContentFormsProducer;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class ContentFormsProducerMock {

    private ContentFormsProducerMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static ContentFormsProducerBuilder contentFormsProducerWith() {
        return new DefaultContentFormsProducerBuilder();
    }

    public interface ContentFormsProducerBuilder extends FormDataProducerBuilder<ContentFormsProducer, ContentFormsProducerBuilder> {
        ContentFormsProducerBuilder creates(Supplier<IdProvidingFormDataBuilder> supplier, EntityBuilder withEntity);

        ContentFormsProducerBuilder aTableTemplate(TableTemplateBuilder tableTemplate);
    }

    public static final class DefaultContentFormsProducerBuilder extends DefaultFormDataProducerBuilder<ContentFormsProducer, ContentFormsProducerBuilder, DefaultContentFormsProducerBuilder> implements ContentFormsProducerBuilder {

        private DefaultContentFormsProducerBuilder() {
        }

        @Override
        public final ContentFormsProducerBuilder creates(Supplier<IdProvidingFormDataBuilder> supplier, EntityBuilder entity) {
            IdProvidingFormData idProvidingFormData = build(supplier.get());
            when(getBuildable().create(getBuildable(entity))).thenReturn(idProvidingFormData);
            return getBuilder();
        }

        @Override
        public final ContentFormsProducerBuilder aTableTemplate(TableTemplateBuilder tableTemplate) {
            when(getBuildable().getTableTemplate()).thenReturn(getBuildable(tableTemplate));
            return getBuilder();
        }
    }
}
