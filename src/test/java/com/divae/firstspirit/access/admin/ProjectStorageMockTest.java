package com.divae.firstspirit.access.admin;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.admin.ProjectStorage;
import de.espirit.firstspirit.access.project.Project;
import org.junit.Test;

import java.util.List;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.admin.ProjectStorageMock.projectStorageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProjectStorageMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return ProjectStorageMock.class;
	}

	@Test
	public void testProjects() {
		ProjectStorage projectStorage = build(projectStorageWith().projects(() -> new ProjectBuilder[]{projectWith("test", 0, languageWith("DE"))}));
		assertThat(projectStorage.getProjects().length, is(1));
		Project project = projectStorage.getProjects()[0];
		assertThat(project.getName(), is("test"));
		assertThat(project.getId(), is(0L));
		List<Language> languages = project.getLanguages();
		assertThat(languages.size(), is(1));
		assertThat(languages.get(0).getAbbreviation(), is("DE"));
	}
}
