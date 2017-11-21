package com.divae.firstspirit.access.store.mediastore;

import com.divae.firstspirit.access.project.ResolutionMock.ResolutionBuilder;
import com.divae.firstspirit.access.store.StoreElementMock.DefaultStoreElementBuilder;
import com.divae.firstspirit.access.store.StoreElementMock.StoreElementBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaMock.MediaBuilder;
import de.espirit.firstspirit.access.store.mediastore.Picture;

import java.io.IOException;
import java.io.InputStream;

import static org.mockito.Mockito.when;

public final class PictureMock {

    private PictureMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static PictureBuilder pictureWith(String name, MediaBuilder parent) {
        return new DefaultPictureBuilder(name, parent);
    }

    public interface PictureBuilder extends StoreElementBuilder<Picture, PictureBuilder> {
        PictureBuilder anInputStream(InputStream inputStream, ResolutionBuilder resolution) throws IOException;
    }

    public static final class DefaultPictureBuilder extends DefaultStoreElementBuilder<Picture, PictureBuilder, DefaultPictureBuilder> implements PictureBuilder {

        private DefaultPictureBuilder(String name, MediaBuilder parent) {
            super(name, parent);
        }

        @Override
        public final PictureBuilder anInputStream(InputStream inputStream, ResolutionBuilder resolution) throws IOException {
            when(getBuildable().getInputStream(getBuildable(resolution))).thenReturn(inputStream);
            return getBuilder();
        }
    }
}
