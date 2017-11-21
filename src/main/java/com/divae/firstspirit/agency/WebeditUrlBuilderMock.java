package com.divae.firstspirit.agency;

import com.divae.firstspirit.agency.ClientUrlBuilderMock.ClientUrlBuilderBuilder;
import com.divae.firstspirit.agency.ClientUrlBuilderMock.DefaultClientUrlBuilderBuilder;
import de.espirit.firstspirit.agency.ClientUrlAgent.WebeditUrlBuilder;

public final class WebeditUrlBuilderMock {

    private WebeditUrlBuilderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static WebeditUrlBuilderBuilder webeditUrlBuilderWith() {
        return new DefaultWebeditUrlBuilderBuilder();
    }

    public interface WebeditUrlBuilderBuilder extends ClientUrlBuilderBuilder<WebeditUrlBuilder, WebeditUrlBuilderBuilder> {
    }

    private static final class DefaultWebeditUrlBuilderBuilder extends DefaultClientUrlBuilderBuilder<WebeditUrlBuilder, WebeditUrlBuilderBuilder, DefaultWebeditUrlBuilderBuilder> implements WebeditUrlBuilderBuilder {

        private DefaultWebeditUrlBuilderBuilder() {
        }
    }
}
