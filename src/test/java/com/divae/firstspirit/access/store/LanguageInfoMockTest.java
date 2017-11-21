package com.divae.firstspirit.access.store;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import de.espirit.firstspirit.access.store.LanguageInfo;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.store.LanguageInfoMock.languageInfoWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class LanguageInfoMockTest extends MockTest {

    @Test
    public void testLanguageInfoWith() {
        assertThat(languageInfoWith(languageWith("DE"), null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return LanguageInfoMock.class;
    }

    @Test
    public void testADisplayNamed() {
        String displayName = "test";
        LanguageInfo languageInfo = build(languageInfoWith(languageWith("DE"), null).aDisplayName(displayName));
        assertThat(languageInfo.getDisplayName(), is(displayName));
    }

    @Test
    public void testDefaultLanguage() {
        String displayName = "test";
        LanguageBuilder languageBuilder = languageWith("DE");
        LanguageInfo languageInfo = build(languageInfoWith(languageBuilder, null).aDisplayName(displayName));
        assertThat(languageInfo.getLanguage(), is(build(languageBuilder)));
    }
}
