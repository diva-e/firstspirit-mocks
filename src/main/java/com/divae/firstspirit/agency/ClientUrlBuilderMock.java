package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.agency.ClientUrlAgent.ClientUrlBuilder;

import java.util.Locale;

import static org.mockito.Mockito.when;

public final class ClientUrlBuilderMock {

    private ClientUrlBuilderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends ClientUrlBuilder<T>> TruncatedClientUrlBuilderBuilder<T> clientUrlBuilderWith() {
        return new TrunctedDefaultClientUrlBuilderBuilder<>();
    }

    public interface ClientUrlBuilderBuilder<T extends ClientUrlBuilder<T>, TBUILDER extends ClientUrlBuilderBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
        TBUILDER aProject(ProjectBuilder project);

        <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TBUILDER anElement(OTBUILDER idProvider);

        TBUILDER aLanguage(LanguageBuilder language);

        TBUILDER aLocale(Locale locale);

        TBUILDER createsUrl(String string);
    }

    public static class DefaultClientUrlBuilderBuilder<T extends ClientUrlBuilder<T>, EBUILDER extends ClientUrlBuilderBuilder<T, EBUILDER>, TBUILDER extends DefaultClientUrlBuilderBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements ClientUrlBuilderBuilder<T, EBUILDER> {

        protected DefaultClientUrlBuilderBuilder() {
        }

        @Override
        public final EBUILDER aProject(ProjectBuilder project) {
            when(getBuildable().project(getBuildable(project))).thenReturn(getBuildable());
            return getInterfaceBuilder();
        }

        @Override
        public final <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> EBUILDER anElement(OTBUILDER idProvider) {
            when(getBuildable().element(getBuildable(idProvider))).thenReturn(getBuildable());
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER aLanguage(LanguageBuilder language) {
            when(getBuildable().language(getBuildable(language))).thenReturn(getBuildable());
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER aLocale(Locale locale) {
            when(getBuildable().locale(locale)).thenReturn(getBuildable());
            return getInterfaceBuilder();
        }

        @Override
        public final EBUILDER createsUrl(String string) {
            when(getBuildable().createUrl()).thenReturn(string);
            return getInterfaceBuilder();
        }

    }

    public interface TruncatedClientUrlBuilderBuilder<T extends ClientUrlBuilder<T>> extends ClientUrlBuilderBuilder<T, TruncatedClientUrlBuilderBuilder<T>> {
    }

    private static final class TrunctedDefaultClientUrlBuilderBuilder<T extends ClientUrlBuilder<T>> extends DefaultClientUrlBuilderBuilder<T, TruncatedClientUrlBuilderBuilder<T>, TrunctedDefaultClientUrlBuilderBuilder<T>> implements TruncatedClientUrlBuilderBuilder<T> {

        protected TrunctedDefaultClientUrlBuilderBuilder() {
        }
    }
}