package com.divae.firstspirit.access.link;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.forms.FormDataMock;
import de.espirit.firstspirit.access.link.Link;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.link.LinkMock.linkWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class LinkMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return LinkMock.class;
    }

    @Test
    public void testAFormData() {
        Link link = build(linkWith().aFormData(FormDataMock::formDataWith));
        assertThat(link.getFormData(), is(notNullValue()));
    }
}
