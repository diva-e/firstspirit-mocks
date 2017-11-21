package com.divae.firstspirit.storage;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.storage.RevisionChangeDetail;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.storage.RevisionChangeDetailMock.revisionChangeDetailWith;
import static de.espirit.firstspirit.storage.ChangeType.CHILDREN;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RevisionChangeDetailMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return RevisionChangeDetailMock.class;
    }


    @Test
    public void testAChangeType() {
        RevisionChangeDetail revisionChangeDetail = build(revisionChangeDetailWith().aChangeType(CHILDREN));
        assertThat(revisionChangeDetail.getChangeType(), is(CHILDREN));
    }
}
