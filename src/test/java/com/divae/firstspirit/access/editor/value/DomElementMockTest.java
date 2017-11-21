package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.editor.value.DomElement;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.editor.value.DomElementMock.domElementWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DomElementMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return DomElementMock.class;
    }

    @Test
    public void testDefaults() {
        DomElement domElement = build(domElementWith());
        domElement.parseHtml("html");
        assertThat(domElement.toText(true), is("html"));
    }

    @Test
    public void testToText() {
        DomElement domElement = build(domElementWith().toText("html", true));
        assertThat(domElement.toText(true), is("html"));
    }
}