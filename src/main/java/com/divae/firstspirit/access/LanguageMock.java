package com.divae.firstspirit.access;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.Language;

import static java.lang.Boolean.TRUE;
import static org.mockito.Mockito.when;

public final class LanguageMock {

    private LanguageMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static LanguageBuilder languageWith(String abbreviation) {
        return new DefaultLanguageBuilder(abbreviation);
    }

    public interface LanguageBuilder extends Builder<Language, LanguageBuilder> {
        LanguageBuilder isMasterLanguage();
    }

    public static final class DefaultLanguageBuilder extends DefaultBuilder<Language, LanguageBuilder, DefaultLanguageBuilder> implements LanguageBuilder {

        private DefaultLanguageBuilder(String abbreviation) {
            super(abbreviation);
            when(getBuildable().getAbbreviation()).thenReturn(abbreviation);
        }

        @Override
        public final LanguageBuilder isMasterLanguage() {
            when(getBuildable().isMasterLanguage()).thenReturn(TRUE);
            return getBuilder();
        }
    }
}
