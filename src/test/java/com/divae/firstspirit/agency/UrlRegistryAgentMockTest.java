package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.generate.path.IDProviderKeyMock;
import de.espirit.firstspirit.agency.UrlRegistryAgent;
import de.espirit.firstspirit.generate.path.IDProviderKey;
import org.junit.Test;

import java.util.Collections;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.agency.UrlRegistryAgentMock.urlRegistryAgentWith;
import static com.divae.firstspirit.generate.path.IDProviderKeyMock.idProviderKeyWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UrlRegistryAgentMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return UrlRegistryAgentMock.class;
    }

    @Test
    public void testEntries() {
        String path = "path";
        IDProviderKeyMock.IDProviderKeyBuilder idProviderKeyBuilder = idProviderKeyWith();
        UrlRegistryAgent urlRegistryAgent = build(urlRegistryAgentWith().entries(Collections.singletonList(idProviderKeyBuilder), path));
        IDProviderKey idProviderKey = build(idProviderKeyBuilder);
        assertThat(urlRegistryAgent.getEntries(path).get(0), is(idProviderKey));
    }
}
