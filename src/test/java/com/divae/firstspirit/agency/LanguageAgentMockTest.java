package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.LanguageMock;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.agency.LanguageAgent;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.agency.LanguageAgentMock.languageAgentWith;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LanguageAgentMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return LanguageAgentMock.class;
    }

    @Test
    public void testLanguages() {
        LanguageMock.LanguageBuilder languageBuilder = languageWith("DE");
        LanguageAgent languageAgent = build(languageAgentWith().languages(singletonList(languageBuilder)));
        Language language = build(languageBuilder);
        assertThat(languageAgent.getLanguages(), is(singletonList(language)));
    }
}
