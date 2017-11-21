package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.access.store.globalstore.GCAPageMock.GCAPageBuilder;
import com.divae.firstspirit.access.store.pagestore.BodyMock.BodyBuilder;
import com.divae.firstspirit.access.store.pagestore.BodyMock.DefaultBodyBuilder;
import de.espirit.firstspirit.access.store.globalstore.GCABody;

public final class GCABodyMock {

    private GCABodyMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static GCABodyBuilder gcaBodyWith(String name, long id, GCAPageBuilder parent) {
        return new DefaultGCABodyBuilder(name, id, parent);
    }

    public interface GCABodyBuilder extends BodyBuilder<GCABody, GCABodyBuilder> {
    }

    private static final class DefaultGCABodyBuilder extends DefaultBodyBuilder<GCABody, GCABodyBuilder, DefaultGCABodyBuilder> implements GCABodyBuilder {

        private DefaultGCABodyBuilder(String name, long id, GCAPageBuilder parent) {
            super(name, id, parent);
        }
    }
}
