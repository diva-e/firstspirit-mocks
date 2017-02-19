package com.divae.firstspirit.access.store.templatestore;


import com.divae.firstspirit.access.store.templatestore.SectionTemplateMock.SectionTemplateBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateContainerMock.DefaultTemplateContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateContainerMock.TemplateContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.TemplateStoreRootBuilder;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplate;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplates;

import java.util.function.Function;

import static com.divae.firstspirit.BuilderMock.build;
import static de.espirit.firstspirit.access.store.templatestore.SectionTemplate.UID_TYPE;
import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;

public final class SectionTemplatesMock {

	private SectionTemplatesMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static SectionTemplatesBuilder sectionTemplatesWith(String uid, long id, TemplateStoreRootBuilder parent) {
		return new DefaultSectionTemplatesBuilder(uid, id, parent);
	}

	public interface SectionTemplatesBuilder extends TemplateContainerBuilder<SectionTemplate, SectionTemplates, SectionTemplatesBuilder> {
		SectionTemplatesBuilder aTemplate(Function<SectionTemplatesBuilder, SectionTemplateBuilder> function);
	}

	public static final class DefaultSectionTemplatesBuilder extends DefaultTemplateContainerBuilder<SectionTemplate, SectionTemplates, SectionTemplatesBuilder, DefaultSectionTemplatesBuilder> implements SectionTemplatesBuilder {

		private DefaultSectionTemplatesBuilder(String uid, long id, TemplateStoreRootBuilder parent) {
			super(uid, id, UID_TYPE, parent);
		}

		@Override
		public final SectionTemplatesBuilder aTemplate(Function<SectionTemplatesBuilder, SectionTemplateBuilder> function) {
			SectionTemplate sectionTemplate = build(function.apply(getBuilder()));
			when(getBuildable().getTemplate(sectionTemplate.getUid())).thenReturn(sectionTemplate);
			children(singletonList(sectionTemplate));
			return getBuilder();
		}
	}
}
