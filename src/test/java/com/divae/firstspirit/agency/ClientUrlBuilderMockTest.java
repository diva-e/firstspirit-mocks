package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.TruncatedIDProviderBuilder;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.project.Project;
import de.espirit.firstspirit.access.store.IDProvider;
import org.junit.Test;

import java.util.Locale;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.store.IDProviderMock.idProviderWith;
import static com.divae.firstspirit.agency.ClientUrlBuilderMock.clientUrlBuilderWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.CONTENTSTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ClientUrlBuilderMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return ClientUrlBuilderMock.class;
	}

	@Test
	public void testAProject() {
		ProjectBuilder projectBuilder = projectWith("project", 0, languageWith("DE"));
		Project project = build(projectBuilder);
		assertThat(build(clientUrlBuilderWith().aProject(projectBuilder)).project(project), is(notNullValue()));
	}

	@Test
	public void testAnElement() {
		TruncatedIDProviderBuilder<IDProvider> idProviderBuilder = idProviderWith("idProvider", 2, CONTENTSTORE, null);
		IDProvider idProvider = build(idProviderBuilder);
		assertThat(build(clientUrlBuilderWith().anElement(idProviderBuilder)).element(idProvider), is(notNullValue()));
	}

	@Test
	public void testALanguage() {
		LanguageBuilder languageBuilder = languageWith("DE");
		Language language = build(languageBuilder);
		assertThat(build(clientUrlBuilderWith().aLanguage(languageBuilder)).language(language), is(notNullValue()));
	}

	@Test
	public void testALocale() {
		Locale locale = new Locale("DE");
		assertThat(build(clientUrlBuilderWith().aLocale(locale)).locale(locale), is(notNullValue()));
	}

	@Test
	public void testCreateUrl() {
		String url = "url";
		assertThat(build(clientUrlBuilderWith().createsUrl(url)).createUrl(), is(url));
	}
}
