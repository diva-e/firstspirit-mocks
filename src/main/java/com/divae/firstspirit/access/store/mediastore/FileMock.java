package com.divae.firstspirit.access.store.mediastore;

import com.divae.firstspirit.access.store.StoreElementMock.DefaultStoreElementBuilder;
import com.divae.firstspirit.access.store.StoreElementMock.StoreElementBuilder;
import com.divae.firstspirit.access.store.mediastore.MediaMock.MediaBuilder;
import de.espirit.firstspirit.access.store.mediastore.File;

import java.io.IOException;
import java.io.InputStream;

import static org.mockito.Mockito.when;

public final class FileMock {

    private FileMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static FileBuilder fileWith(String name, MediaBuilder parent) {
        return new DefaultFileBuilder(name, parent);
    }

    public interface FileBuilder extends StoreElementBuilder<File, FileBuilder> {
        FileBuilder anInputStream(InputStream stream) throws IOException;

        FileBuilder anExtension(String fileExtension);

        FileBuilder aCrc(long crc);
    }

    public static final class DefaultFileBuilder extends DefaultStoreElementBuilder<File, FileBuilder, DefaultFileBuilder> implements FileBuilder {

        private DefaultFileBuilder(String name, MediaBuilder parent) {
            super(name, parent);
        }

        @Override
        public final FileBuilder anInputStream(InputStream stream) throws IOException {
            when(getBuildable().getInputStream()).thenReturn(stream);
            return getBuilder();
        }

        @Override
        public final FileBuilder anExtension(String fileExtension) {
            when(getBuildable().getExtension()).thenReturn(fileExtension);
            return getBuilder();
        }

        @Override
        public final FileBuilder aCrc(long crc) {
            when(getBuildable().getCrc()).thenReturn(crc);
            return getBuilder();
        }

    }
}
