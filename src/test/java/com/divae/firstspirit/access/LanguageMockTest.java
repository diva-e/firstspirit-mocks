package com.divae.firstspirit.access;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.Language;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class LanguageMockTest extends MockTest {

    @Test
    public void testLanguageWith() {
        assertThat(languageWith("test"), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return LanguageMock.class;
    }

    @Test
    public void testDefaults() {
        String abbreviation = "test";
        Language language = build(languageWith(abbreviation));
        assertThat(language.getAbbreviation(), is(abbreviation));
    }

    @Test
    public void testIsMasterLanguage() {
        Language language = build(languageWith("test").isMasterLanguage());
        assertThat(language.isMasterLanguage(), is(TRUE));
    }
}
