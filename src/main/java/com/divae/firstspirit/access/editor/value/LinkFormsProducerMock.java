package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.editor.FormDataProducerMock.DefaultFormDataProducerBuilder;
import com.divae.firstspirit.access.editor.FormDataProducerMock.FormDataProducerBuilder;
import com.divae.firstspirit.access.editor.fslist.IdProvidingFormDataMock.IdProvidingFormDataBuilder;
import com.divae.firstspirit.access.store.templatestore.LinkTemplateMock.LinkTemplateBuilder;
import de.espirit.firstspirit.access.editor.fslist.IdProvidingFormData;
import de.espirit.firstspirit.access.editor.value.LinkFormsProducer;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class LinkFormsProducerMock {

	private LinkFormsProducerMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static LinkFormsProducerBuilder linkFormsProducerWith() {
		return new DefaultLinkFormsProducerBuilder();
	}

	public interface LinkFormsProducerBuilder extends FormDataProducerBuilder<LinkFormsProducer, LinkFormsProducerBuilder> {
		LinkFormsProducerBuilder creates(Supplier<IdProvidingFormDataBuilder> supplier, LinkTemplateBuilder linkTemplate, LanguageBuilder language);
	}

	public static final class DefaultLinkFormsProducerBuilder extends DefaultFormDataProducerBuilder<LinkFormsProducer, LinkFormsProducerBuilder, DefaultLinkFormsProducerBuilder> implements LinkFormsProducerBuilder {

		private DefaultLinkFormsProducerBuilder() {
		}

		@Override
		public final LinkFormsProducerBuilder creates(Supplier<IdProvidingFormDataBuilder> supplier, LinkTemplateBuilder linkTemplate, LanguageBuilder language) {
			IdProvidingFormData idProvidingFormData = build(supplier.get());
			when(getBuildable().create(getBuildable(linkTemplate), getBuildable(language))).thenReturn(idProvidingFormData);
			return getBuilder();
		}
	}
}
