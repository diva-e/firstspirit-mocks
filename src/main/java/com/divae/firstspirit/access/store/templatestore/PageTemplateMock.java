package com.divae.firstspirit.access.store.templatestore;


import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.access.store.templatestore.PageTemplatesMock.PageTemplatesBuilder;
import com.divae.firstspirit.access.store.templatestore.PreviewImageProviderMock.PreviewImageProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateMock.DefaultTemplateBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateMock.TemplateBuilder;
import de.espirit.firstspirit.access.store.templatestore.PageTemplate;

import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.mockito.Mockito.when;

public final class PageTemplateMock {

	private PageTemplateMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static PageTemplateBuilder pageTemplateWith(String uid, long id, PageTemplatesBuilder parent) {
		return new DefaultPageTemplateBuilder(uid, id, parent);
	}

	public interface PageTemplateBuilder extends TemplateBuilder<PageTemplate, PageTemplateBuilder>, PreviewImageProviderBuilder<PageTemplate, PageTemplateBuilder> {
		PageTemplateBuilder aChannelSource(String channelSource, TemplateSetBuilder templateSet);
	}

	public static final class DefaultPageTemplateBuilder extends DefaultTemplateBuilder<PageTemplate, PageTemplateBuilder, DefaultPageTemplateBuilder> implements PageTemplateBuilder {

		private DefaultPageTemplateBuilder(String uid, long id, PageTemplatesBuilder parent) {
			super(uid, id, TEMPLATESTORE, parent);
		}

		@Override
		public final PageTemplateBuilder aChannelSource(String channelSource, TemplateSetBuilder templateSet) {
			when(getBuildable().getChannelSource(getBuildable(templateSet))).thenReturn(channelSource);
			return getBuilder();
		}
	}
}
