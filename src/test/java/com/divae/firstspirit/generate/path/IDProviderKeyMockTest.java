package com.divae.firstspirit.generate.path;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.generate.path.IDProviderKey;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.generate.path.IDProviderKeyMock.idProviderKeyWith;
import static java.lang.Long.valueOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class IDProviderKeyMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return IDProviderKeyMock.class;
    }

    @Test
    public void testANodeId() {
        long nodeId = 0L;
        IDProviderKey idProviderKey = build(idProviderKeyWith().aNodeId(nodeId));
        assertThat(idProviderKey.getNodeId(), is(valueOf(nodeId)));
    }


}
