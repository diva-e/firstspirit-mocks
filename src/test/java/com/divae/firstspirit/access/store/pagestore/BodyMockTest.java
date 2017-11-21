package com.divae.firstspirit.access.store.pagestore;

import com.divae.firstspirit.MockTest;
import org.junit.Test;

import static com.divae.firstspirit.access.store.pagestore.BodyMock.bodyWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.PAGESTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class BodyMockTest extends MockTest {

    @Test
    public void testBodyWithStringLongUidTypeStoreBuilder() {
        String uid = "test";
        assertThat(bodyWith(uid, 2, PAGESTORE, null), is(notNullValue()));
    }

    @Test
    public void testBodyWithStringLongStoreBuilder() {
        String uid = "test";
        assertThat(bodyWith(uid, 2, null), is(notNullValue()));

    }

    @Override
    protected Class<?> getFactoryClass() {
        return BodyMock.class;
    }

}
