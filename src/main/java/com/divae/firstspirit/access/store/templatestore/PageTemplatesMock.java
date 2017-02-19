package com.divae.firstspirit.access.store.templatestore;


import com.divae.firstspirit.access.store.templatestore.TemplateContainerMock.DefaultTemplateContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateContainerMock.TemplateContainerBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateStoreRootMock.TemplateStoreRootBuilder;
import de.espirit.firstspirit.access.store.templatestore.PageTemplate;
import de.espirit.firstspirit.access.store.templatestore.PageTemplates;

import static de.espirit.firstspirit.access.store.templatestore.PageTemplate.UID_TYPE;

public final class PageTemplatesMock {

	private PageTemplatesMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static PageTemplatesBuilder pageTemplatesWith(String uid, long id, TemplateStoreRootBuilder parent) {
		return new DefaultPageTemplatesBuilder(uid, id, parent);
	}

	public interface PageTemplatesBuilder extends TemplateContainerBuilder<PageTemplate, PageTemplates, PageTemplatesBuilder> {
	}

	public static final class DefaultPageTemplatesBuilder extends DefaultTemplateContainerBuilder<PageTemplate, PageTemplates, PageTemplatesBuilder, DefaultPageTemplatesBuilder> implements PageTemplatesBuilder {

		private DefaultPageTemplatesBuilder(String uid, long id, TemplateStoreRootBuilder parent) {
			super(uid, id, UID_TYPE, parent);
		}

	}
}
