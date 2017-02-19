package com.divae.firstspirit.access.project;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.project.ProjectScriptContext;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.project.ProjectScriptContextMock.projectScriptContextWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ProjectScriptContextMockTest extends MockTest {

	@Test
	public void testProjectScriptContextProjectWith() {
		assertThat(projectScriptContextWith(projectWith("project", 0, languageWith("DE"))), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return ProjectScriptContextMock.class;
	}

	@Test
	public void testDefaults() {
		ProjectScriptContext projectScriptContext = build(projectScriptContextWith(projectWith("test", 0, languageWith("DE"))));
		assertThat(projectScriptContext.getProject(), is(notNullValue()));
	}
}
