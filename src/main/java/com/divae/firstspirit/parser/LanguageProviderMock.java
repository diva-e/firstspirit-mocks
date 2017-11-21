package com.divae.firstspirit.parser;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.parser.LanguageProvider;

public final class LanguageProviderMock {

    private LanguageProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static LanguageProviderBuilder languageProviderWith() {
        return new DefaultLanguageProviderBuilder();
    }

    public interface LanguageProviderBuilder extends Builder<LanguageProvider, LanguageProviderBuilder> {
    }

    private static final class DefaultLanguageProviderBuilder extends DefaultBuilder<LanguageProvider, LanguageProviderBuilder, DefaultLanguageProviderBuilder> implements LanguageProviderBuilder {

        private DefaultLanguageProviderBuilder() {
        }
    }
}
