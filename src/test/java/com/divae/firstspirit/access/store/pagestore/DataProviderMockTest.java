package com.divae.firstspirit.access.store.pagestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.forms.FormDataMock;
import de.espirit.firstspirit.access.store.pagestore.DataProvider;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.pagestore.DataProviderMock.dataProviderWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.GLOBALSTORE;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.PAGESTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class DataProviderMockTest extends MockTest {

    @Test
    public void testDataProviderWithName() {
        assertThat(dataProviderWith("test", 2, null), is(notNullValue()));
    }

    @Test
    public void testDataProviderWithDataProvider() {
        assertThat(dataProviderWith(dataProviderWith("test", 2, null)), is(notNullValue()));
    }

    @Test
    public void testDataProviderWithUid() {
        assertThat(dataProviderWith("test", 2, GLOBALSTORE, null), is(notNullValue()));
    }

    @Test
    public void testDataProviderWithNamePageStoreRoot() {
        assertThat(dataProviderWith("test", 2, null), is(notNullValue()));
    }

    @Test
    public void testDataProviderWithUidPageStoreRoot() {
        assertThat(dataProviderWith("test", 2, PAGESTORE, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return DataProviderMock.class;
    }


    @Test
    public void testAFormData() {
        DataProvider dataProvider = build(dataProviderWith("uid", 2, null).aFormData(FormDataMock::formDataWith));
        assertThat(dataProvider.getFormData(), is(notNullValue()));
    }
}
