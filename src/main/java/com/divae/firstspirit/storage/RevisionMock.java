package com.divae.firstspirit.storage;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.storage.RevisionMetaDataMock.RevisionMetaDataBuilder;
import de.espirit.firstspirit.storage.Revision;
import de.espirit.firstspirit.storage.RevisionMetaData;

import java.io.IOException;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class RevisionMock {

    private RevisionMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static RevisionBuilder revisionWith(long id) {
        return new DefaultRevisionBuilder(id);
    }

    public interface RevisionBuilder extends Builder<Revision, RevisionBuilder> {
        RevisionBuilder anEditor(String editor);

        RevisionBuilder aMetaData(Supplier<RevisionMetaDataBuilder> supplier) throws IOException;
    }

    public static final class DefaultRevisionBuilder extends DefaultBuilder<Revision, RevisionBuilder, DefaultRevisionBuilder> implements RevisionBuilder {

        private DefaultRevisionBuilder(long id) {
            withId(id);
        }

        private void withId(long id) {
            when(getBuildable().getId()).thenReturn(id);
        }

        @Override
        public final RevisionBuilder anEditor(String editor) {
            when(getBuildable().getEditor()).thenReturn(editor);
            return getBuilder();
        }

        @Override
        public final RevisionBuilder aMetaData(Supplier<RevisionMetaDataBuilder> supplier) throws IOException {
            RevisionMetaData revisionMetaData = build(supplier.get());
            when(getBuildable().getMetaData()).thenReturn(revisionMetaData);
            return getBuilder();
        }

    }
}
