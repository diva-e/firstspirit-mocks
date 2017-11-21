package com.divae.firstspirit.access.store.globalstore;

import com.divae.firstspirit.MockTest;
import org.junit.Test;

import static com.divae.firstspirit.access.store.globalstore.UserPropertiesMock.userPropertiesWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class UserPropertiesMockTest extends MockTest {

    @Test
    public void testUserPropertiesWith() {
        assertThat(userPropertiesWith("ui", 2, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return UserPropertiesMock.class;
    }

}
