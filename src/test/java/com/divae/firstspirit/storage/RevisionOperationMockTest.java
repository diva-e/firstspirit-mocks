package com.divae.firstspirit.storage;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.storage.RevisionOperation;
import org.junit.Test;

import java.util.Collection;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.storage.RevisionOperationMock.revisionOperationWith;
import static de.espirit.firstspirit.storage.RevisionOperation.OperationType.CREATE;
import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RevisionOperationMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return RevisionOperationMock.class;
    }

    @Test
    public void testAType() {
        RevisionOperation<Object> revisionOperation = build(revisionOperationWith().aType(CREATE));
        assertThat(revisionOperation.getType(), is(CREATE));
    }

    @Test
    public void testElements() {
        Collection<Object> elements = emptyList();
        RevisionOperation<Object> revisionOperation = build(revisionOperationWith().elements(elements));
        assertThat(revisionOperation.getElements(), is(elements));
    }
}
