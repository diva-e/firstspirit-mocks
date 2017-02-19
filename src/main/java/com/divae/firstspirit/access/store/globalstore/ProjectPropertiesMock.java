package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.globalstore.GlobalStoreRootMock.GlobalStoreRootBuilder;
import com.divae.firstspirit.access.store.pagestore.DataProviderMock.DataProviderBuilder;
import com.divae.firstspirit.access.store.pagestore.DataProviderMock.DefaultDataProviderBuilder;
import com.divae.firstspirit.access.store.templatestore.TemplateProviderMock.TemplateProviderBuilder;
import de.espirit.firstspirit.access.store.globalstore.ProjectProperties;
import de.espirit.firstspirit.access.store.templatestore.PageTemplate;

public final class ProjectPropertiesMock {

	private ProjectPropertiesMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static ProjectPropertiesBuilder projectPropertiesWith(String name, long id, GlobalStoreRootBuilder parent) {
		return new DefaultProjectPropertiesBuilder(name, id, parent);
	}

	public interface ProjectPropertiesBuilder extends DataProviderBuilder<ProjectProperties, ProjectPropertiesBuilder>, IDProviderBuilder<ProjectProperties, ProjectPropertiesBuilder>, TemplateProviderBuilder<PageTemplate, ProjectProperties, ProjectPropertiesBuilder> {
	}

	public static final class DefaultProjectPropertiesBuilder extends DefaultDataProviderBuilder<ProjectProperties, ProjectPropertiesBuilder, DefaultProjectPropertiesBuilder> implements ProjectPropertiesBuilder {

		private DefaultProjectPropertiesBuilder(String name, long id, GlobalStoreRootBuilder parent) {
			super(name, id, parent);
		}

	}
}
