package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.or.SessionMock;
import de.espirit.firstspirit.access.store.templatestore.Schema;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.templatestore.SchemaMock.schemaWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SchemaMockTest extends MockTest {

    @Test
    public void testSchemaWith() {
        assertThat(schemaWith("test", 2, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return SchemaMock.class;
    }

    @Test
    public void testASession() {
        Schema schema = build(schemaWith("test", 2, null).aSession(SessionMock::sessionWith));
        assertThat(schema.getSession(), is(notNullValue()));
    }

    @Test
    public void testASessionBooleanTrue() {
        Schema schema = build(schemaWith("test", 2, null).aSession(SessionMock::sessionWith, true));
        assertThat(schema.getSession(true), is(notNullValue()));
    }

    @Test
    public void testASessionBooleanFalse() {
        Schema schema = build(schemaWith("test", 2, null).aSession(SessionMock::sessionWith, false));
        assertThat(schema.getSession(false), is(notNullValue()));
    }
}
