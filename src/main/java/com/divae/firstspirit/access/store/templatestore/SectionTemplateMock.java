package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.access.store.templatestore.PreviewImageProviderMock.PreviewImageProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.SectionTemplatesMock.SectionTemplatesBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateMock.DefaultTemplateBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateMock.TemplateBuilder;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplate;

import static org.mockito.Mockito.when;

public final class SectionTemplateMock {

	private SectionTemplateMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static SectionTemplateBuilder sectionTemplateWith(String uid, long id, UidType uidType, SectionTemplatesBuilder parent) {
		return new DefaultSectionTemplateBuilder(uid, id, uidType, parent);
	}

	public interface SectionTemplateBuilder extends TemplateBuilder<SectionTemplate, SectionTemplateBuilder>, PreviewImageProviderBuilder<SectionTemplate, SectionTemplateBuilder> {
		SectionTemplateBuilder aChannelSource(String channelSource, TemplateSetBuilder templateSet);
	}

	public static final class DefaultSectionTemplateBuilder extends DefaultTemplateBuilder<SectionTemplate, SectionTemplateBuilder, DefaultSectionTemplateBuilder> implements SectionTemplateBuilder {

		private DefaultSectionTemplateBuilder(String uid, long id, UidType uidType, SectionTemplatesBuilder parent) {
			super(uid, id, uidType, parent);
		}

		@Override
		public final SectionTemplateBuilder aChannelSource(String channelSource, TemplateSetBuilder templateSet) {
			when(getBuildable().getChannelSource(getBuildable(templateSet))).thenReturn(channelSource);
			return getBuilder();
		}
	}

}
