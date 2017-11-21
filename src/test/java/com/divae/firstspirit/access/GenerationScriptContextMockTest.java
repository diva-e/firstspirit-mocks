package com.divae.firstspirit.access;

import com.divae.firstspirit.MockTest;
import org.junit.Test;

import static com.divae.firstspirit.access.GenerationScriptContextMock.generationScriptContextWith;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GenerationScriptContextMockTest extends MockTest {

    @Test
    public void testGenerationScriptContextWith() {
        assertThat(generationScriptContextWith(projectWith("project", 0, languageWith("DE"))), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return GenerationScriptContextMock.class;
    }
}
