package com.divae.firstspirit.access.store.sitestore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.sitestore.StartNode;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.sitestore.StartNodeMock.startNodeWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.SITESTORE_LEAF;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartNodeMockTest extends MockTest {

    @Test
    public void testStartNodeWithStringLongSiteStoreRoot() {
        assertThat(startNodeWith("test", 2, SITESTORE_LEAF, null), is(notNullValue()));
    }

    @Test
    public void testStartNodeWithStartNode() {
        assertThat(startNodeWith(startNodeWith("test", 2, SITESTORE_LEAF, null)), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return StartNodeMock.class;
    }

    @Test
    public void testDefaults() {
        StartNode startNode = build(startNodeWith("test", 2, SITESTORE_LEAF, null));
        assertThat(startNode.getStore(), is(nullValue()));
    }

    @Test
    public void testIsStartNode() {
        StartNode startNode = build(startNodeWith("test", 2, SITESTORE_LEAF, null).isStartNode(true));
        assertThat(startNode.isStartNode(), is(TRUE));
    }
}
