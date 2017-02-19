package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.store.StoreMock.DefaultStoreBuilder;
import com.divae.firstspirit.access.store.StoreMock.StoreBuilder;
import com.divae.firstspirit.access.store.templatestore.SectionTemplatesMock.SectionTemplatesBuilder;
import de.espirit.firstspirit.access.store.Store.Type;
import de.espirit.firstspirit.access.store.templatestore.SectionTemplates;
import de.espirit.firstspirit.access.store.templatestore.TemplateStoreRoot;

import java.util.function.Function;

import static com.divae.firstspirit.BuilderMock.build;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.mockito.Mockito.when;

public final class TemplateStoreRootMock {

	private TemplateStoreRootMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static TemplateStoreRootBuilder templateStoreRootWith(long id, ProjectBuilder project) {
		return new DefaultTemplateStoreRootBuilder(id, project);
	}

	public interface TemplateStoreRootBuilder extends StoreBuilder<TemplateStoreRoot, TemplateStoreRootBuilder> {
		TemplateStoreRootBuilder aSectionTemplates(Function<TemplateStoreRootBuilder, SectionTemplatesBuilder> function);
	}

	public static final class DefaultTemplateStoreRootBuilder extends DefaultStoreBuilder<TemplateStoreRoot, TemplateStoreRootBuilder, DefaultTemplateStoreRootBuilder> implements TemplateStoreRootBuilder {

		private DefaultTemplateStoreRootBuilder(long id, ProjectBuilder project) {
			super(id, TEMPLATESTORE, Type.TEMPLATESTORE, project);
		}

		@Override
		public final TemplateStoreRootBuilder aSectionTemplates(Function<TemplateStoreRootBuilder, SectionTemplatesBuilder> function) {
			SectionTemplates sectionTemplates = build(function.apply(getBuilder()));
			when(getBuildable().getSectionTemplates()).thenReturn(sectionTemplates);
			return getBuilder();
		}
	}
}
