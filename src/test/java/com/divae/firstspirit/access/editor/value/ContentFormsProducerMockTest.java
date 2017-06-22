package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.editor.fslist.IdProvidingFormDataMock.IdProvidingFormDataBuilder;
import com.divae.firstspirit.access.store.templatestore.TableTemplateMock.TableTemplateBuilder;
import com.divae.firstspirit.or.schema.EntityMock.EntityBuilder;
import de.espirit.firstspirit.access.editor.fslist.IdProvidingFormData;
import de.espirit.firstspirit.access.editor.value.ContentFormsProducer;
import de.espirit.firstspirit.access.store.templatestore.TableTemplate;
import de.espirit.or.schema.Entity;
import org.junit.Test;

import java.util.UUID;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.editor.fslist.IdProvidingFormDataMock.idProvidingFormDataWith;
import static com.divae.firstspirit.access.editor.value.ContentFormsProducerMock.contentFormsProducerWith;
import static com.divae.firstspirit.access.store.templatestore.TableTemplateMock.tableTemplateWith;
import static com.divae.firstspirit.or.schema.EntityMock.entityWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ContentFormsProducerMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return ContentFormsProducerMock.class;
    }

    @Test
    public void testCreates() {
        EntityBuilder entityBuilder = entityWith(UUID.randomUUID());
        IdProvidingFormDataBuilder idProvidingFormDataBuilder = idProvidingFormDataWith(0L);
        ContentFormsProducer contentFormsProducer = build(contentFormsProducerWith().creates(() -> idProvidingFormDataBuilder, entityBuilder));
        IdProvidingFormData idProvidingFormData = build(idProvidingFormDataBuilder);
        Entity entity = build(entityBuilder);
        assertThat(contentFormsProducer.create(entity), is(idProvidingFormData));
    }

    @Test
    public void testATableTemplate() {
        TableTemplateBuilder tableTemplateBuilder = tableTemplateWith("test", 2, TEMPLATESTORE, null);
        ContentFormsProducer contentFormsProducer = build(contentFormsProducerWith().aTableTemplate(tableTemplateBuilder));
        TableTemplate tableTemplate = build(tableTemplateBuilder);
        assertThat(contentFormsProducer.getTableTemplate(), is(tableTemplate));
    }
}
