package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.templatestore.GomSourceProvider;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.templatestore.GomSourceProviderMock.gomSourceProviderWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GomSourceProviderMockTest extends MockTest {

    @Test
    public void testGomSourceProviderWith() {
        assertThat(gomSourceProviderWith("test", 2, null), is(notNullValue()));
    }

    @Test
    public void testGomSourceProviderWithName() {
        assertThat(gomSourceProviderWith(gomSourceProviderWith("test", 2, null)), is(notNullValue()));
    }

    @Test
    public void testGomSourceProviderWithUidType() {
        assertThat(gomSourceProviderWith("test", 2, TEMPLATESTORE, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return GomSourceProviderMock.class;
    }

    @Test
    public void testAGomSource() {
        GomSourceProvider gomSourceProvider = build(gomSourceProviderWith("test", 2, null).aGomSource("gomSource"));
        assertThat(gomSourceProvider.getGomSource(), is("gomSource"));
    }
}
