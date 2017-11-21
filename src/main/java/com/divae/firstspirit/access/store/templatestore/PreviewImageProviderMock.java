package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.access.store.IDProviderMock.DefaultIDProviderBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.store.IDProvider;
import de.espirit.firstspirit.access.store.templatestore.PreviewImageProvider;

import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;

public final class PreviewImageProviderMock {

    private PreviewImageProviderMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends PreviewImageProvider, OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedPreviewImageProviderBuilder<T> previewImageProviderWith(String uid, long id, OTBUILDER parent) {
        return new TruncatedDefaultPreviewImageProviderBuilder<>(uid, id, parent);
    }

    public interface PreviewImageProviderBuilder<T extends PreviewImageProvider, TBUILDER extends PreviewImageProviderBuilder<T, TBUILDER>> extends IDProviderBuilder<T, TBUILDER> {
    }

    public static class DefaultPreviewImageProviderBuilder<T extends PreviewImageProvider, EBUILDER extends PreviewImageProviderBuilder<T, EBUILDER>, TBUILDER extends DefaultPreviewImageProviderBuilder<T, EBUILDER, TBUILDER>> extends DefaultIDProviderBuilder<T, EBUILDER, TBUILDER> implements PreviewImageProviderBuilder<T, EBUILDER> {

        protected <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> DefaultPreviewImageProviderBuilder(String uid, long id, OTBUILDER parent) {
            super(uid, id, TEMPLATESTORE, parent);
        }
    }

    public interface TruncatedPreviewImageProviderBuilder<T extends PreviewImageProvider> extends PreviewImageProviderBuilder<T, TruncatedPreviewImageProviderBuilder<T>> {
    }

    private static final class TruncatedDefaultPreviewImageProviderBuilder<T extends PreviewImageProvider> extends DefaultPreviewImageProviderBuilder<T, TruncatedPreviewImageProviderBuilder<T>, TruncatedDefaultPreviewImageProviderBuilder<T>> implements TruncatedPreviewImageProviderBuilder<T> {

        private <OT extends IDProvider, OTBUILDER extends IDProviderBuilder<OT, OTBUILDER>> TruncatedDefaultPreviewImageProviderBuilder(String uid, long id, OTBUILDER parent) {
            super(uid, id, parent);
        }
    }
}
