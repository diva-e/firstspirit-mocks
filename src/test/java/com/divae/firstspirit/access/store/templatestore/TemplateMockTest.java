package com.divae.firstspirit.access.store.templatestore;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.store.templatestore.Template;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.templatestore.TemplateMock.templateWith;
import static de.espirit.firstspirit.access.store.IDProvider.UidType.TEMPLATESTORE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TemplateMockTest extends MockTest {

    @Test
    public void testTemplateWith() {
        assertThat(templateWith("test", 2, TEMPLATESTORE, null), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return TemplateMock.class;
    }

    @Test
    public void testWithGomSource() {
        Template template = build(templateWith("test", 2, TEMPLATESTORE, null).aGomSource("gomSource"));
        assertThat(template.getGomSource(), is("gomSource"));
    }
}
