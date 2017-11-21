package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import com.divae.firstspirit.access.store.StoreElementMock.DefaultStoreElementBuilder;
import com.divae.firstspirit.access.store.StoreElementMock.StoreElementBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.sitestore.Content2Params;

import static org.mockito.Mockito.when;

public final class Content2ParamsMock {

    private Content2ParamsMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> Content2ParamsBuilder content2ParamsWith(String name, TBUILDER parent) {
        return new DefaultContent2ParamsBuilder(name, parent);
    }

    public interface Content2ParamsBuilder extends StoreElementBuilder<Content2Params, Content2ParamsBuilder> {
        Content2ParamsBuilder aSitemapVariableName(String sitemapVariableName);
    }

    public static final class DefaultContent2ParamsBuilder extends DefaultStoreElementBuilder<Content2Params, Content2ParamsBuilder, DefaultContent2ParamsBuilder> implements Content2ParamsBuilder {

        private <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> DefaultContent2ParamsBuilder(String name, TBUILDER parent) {
            super(name, parent);
        }

        @Override
        public final Content2ParamsBuilder aSitemapVariableName(String sitemapVariableName) {
            when(getBuildable().getSitemapVariableName()).thenReturn(sitemapVariableName);
            return getBuilder();
        }

    }
}
