package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.IDProvider.UidType;
import de.espirit.firstspirit.access.store.templatestore.ChannelSourceProvider;

public final class ChannelSourceProviderMock {

    private ChannelSourceProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends ChannelSourceProvider, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedChannelSourceProviderBuilder<T> channelSourceProviderWith(String uid, long id, UidType uidType, OTBUILDER parent) {
        return new TruncatedDefaultChannelSourceProviderBuilder<>(uid, id, uidType, parent);
    }

    public static <T extends ChannelSourceProvider, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedChannelSourceProviderBuilder<T> channelSourceProviderWith(String name, long id, OTBUILDER parent) {
        return new TruncatedDefaultChannelSourceProviderBuilder<>(name, id, parent);
    }

    public interface ChannelSourceProviderBuilder<T extends ChannelSourceProvider, TBUILDER extends ChannelSourceProviderBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
    }

    public static class DefaultChannelSourceProviderBuilder<T extends ChannelSourceProvider, EBUILDER extends ChannelSourceProviderBuilder<T, EBUILDER>, TBUILDER extends DefaultChannelSourceProviderBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements ChannelSourceProviderBuilder<T, EBUILDER> {

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultChannelSourceProviderBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultChannelSourceProviderBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
        }
    }

    public interface TruncatedChannelSourceProviderBuilder<T extends ChannelSourceProvider> extends ChannelSourceProviderBuilder<T, TruncatedChannelSourceProviderBuilder<T>> {
    }

    private static final class TruncatedDefaultChannelSourceProviderBuilder<T extends ChannelSourceProvider> extends DefaultChannelSourceProviderBuilder<T, TruncatedChannelSourceProviderBuilder<T>, TruncatedDefaultChannelSourceProviderBuilder<T>> implements TruncatedChannelSourceProviderBuilder<T> {

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultChannelSourceProviderBuilder(String uid, long id, UidType uidType, OTBUILDER parent) {
            super(uid, id, uidType, parent);
        }

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultChannelSourceProviderBuilder(String name, long id, OTBUILDER parent) {
            super(name, id, parent);
        }
    }
}
