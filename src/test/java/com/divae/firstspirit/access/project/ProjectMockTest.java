package com.divae.firstspirit.access.project;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.UserServiceMock.UserServiceBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.UserService;
import de.espirit.firstspirit.access.project.Project;
import de.espirit.firstspirit.access.project.Resolution;
import de.espirit.firstspirit.access.project.TemplateSet;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.UserServiceMock.userServiceWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.project.ResolutionMock.resolutionWith;
import static com.divae.firstspirit.access.project.TemplateSetMock.templateSetWith;
import static com.divae.firstspirit.storage.RevisionMock.revisionWith;
import static java.lang.Boolean.TRUE;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ProjectMockTest extends MockTest {

	@Test
	public void testProjectWith() {
		assertThat(projectWith("test", 0, languageWith("DE")), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return ProjectMock.class;
	}

	@Test
	public void testAnOriginalResolution() {
		Project project = build(projectWith("test", 0, languageWith("DE")).anOriginalResolution(() -> resolutionWith("test")));
		assertThat(project.getOriginalResolution().getUid(), is("test"));
	}

	@Test
	public void testDefaults() {
		Project project = build(projectWith("test", 0, languageWith("DE")));
		Language masterLanguage = project.getMasterLanguage();
		assertThat(masterLanguage, is(notNullValue()));
		List<Language> languages = project.getLanguages();
		assertThat(languages.size(), is(1));
		assertThat(languages.get(0), is(masterLanguage));
		assertThat(project.getName(), is("test"));
		assertThat(project.getId(), is(0L));
	}

	@Test
	public void testLanguages() {
		LanguageBuilder languageBuilder = languageWith("DE");
		Project project = build(projectWith("test", 0, languageBuilder).languages(singletonList(languageBuilder)));
		Language language = build(languageBuilder);
		assertThat(project.getLanguages().contains(language), is(TRUE));
	}

	@Test
	public void testAnUserService() {
		ProjectBuilder projectBuilder = projectWith("test", 0, languageWith("DE"));
		UserServiceBuilder userServiceBuilder = userServiceWith(projectBuilder);
		Project project = build(projectBuilder.anUserService(userServiceBuilder));
		UserService userService = build(userServiceBuilder);
		assertThat(project.getUserService(), is(userService));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAnUserServiceWithDifferentProjectName() {
		ProjectBuilder projectBuilder = projectWith("project1", 0, languageWith("DE"));
		build(projectWith("project2", 0, languageWith("DE")).anUserService(userServiceWith(projectBuilder)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAnUserServiceWithDifferentProjectId() {
		ProjectBuilder projectBuilder = projectWith("project", 0, languageWith("DE"));
		build(projectWith("project", 1, languageWith("DE")).anUserService(userServiceWith(projectBuilder)));
	}

	@Test
	public void testTemplateSets() {
		Project project = build(projectWith("test", 0, languageWith("DE")).templateSets(() -> singletonList(templateSetWith("test"))));
		List<TemplateSet> templateSets = project.getTemplateSets();
		assertThat(templateSets.size(), is(1));
		TemplateSet templateSet = templateSets.get(0);
		assertThat(templateSet.getUid(), is("test"));
	}

	@Test
	public void testResolutions() {
		Project project = build(projectWith("test", 0, languageWith("DE")).resolutions(() -> singletonList(resolutionWith("100x150"))));
		List<Resolution> resolutions = project.getResolutions();
		assertThat(resolutions.size(), is(1));
		Resolution resolution = resolutions.get(0);
		assertThat(resolution.getUid(), is("100x150"));
	}

	@Test
	public void testARevision() {
		Date revisionDate = new Date();
		Project project = build(projectWith("test", 0, languageWith("DE")).aRevision(() -> revisionWith(1L), revisionDate));
		assertThat(project.getRevision(revisionDate).getId(), is(1L));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWrongId() {
		projectWith("test", -1, languageWith("DE"));
	}
}
