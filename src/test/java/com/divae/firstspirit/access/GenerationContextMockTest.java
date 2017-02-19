package com.divae.firstspirit.access;

import com.divae.firstspirit.MockTest;
import org.junit.Test;

import static com.divae.firstspirit.access.GenerationContextMock.generationContextWith;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GenerationContextMockTest extends MockTest {

	@Test
	public void testGenerationContextWith() {
		assertThat(generationContextWith(projectWith("project", 0, languageWith("DE"))), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return GenerationContextMock.class;
	}

}
