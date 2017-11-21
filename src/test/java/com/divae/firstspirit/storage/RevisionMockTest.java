package com.divae.firstspirit.storage;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.storage.RevisionMetaDataMock.RevisionMetaDataBuilder;
import de.espirit.firstspirit.storage.Revision;
import de.espirit.firstspirit.storage.RevisionMetaData;
import org.junit.Test;

import java.io.IOException;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.storage.RevisionMetaDataMock.revisionMetaDataWith;
import static com.divae.firstspirit.storage.RevisionMock.revisionWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class RevisionMockTest extends MockTest {

    @Test
    public void testRevisionWith() {
        assertThat(revisionWith(1L), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return RevisionMock.class;
    }

    @Test
    public void testDefaults() {
        Revision revision = build(revisionWith(1L));
        assertThat(revision.getId(), is(1L));
    }

    @Test
    public void testAnEditor() {
        Revision revision = build(revisionWith(1L).anEditor("test"));
        assertThat(revision.getEditor(), is("test"));
    }

    @Test
    public void testAMetaData() throws IOException {
        RevisionMetaDataBuilder revisionMetaDataBuilder = revisionMetaDataWith();
        Revision revision = build(revisionWith(1L).aMetaData(() -> revisionMetaDataBuilder));
        RevisionMetaData revisionMetaData = build(revisionMetaDataBuilder);
        assertThat(revision.getMetaData(), is(revisionMetaData));
    }
}
