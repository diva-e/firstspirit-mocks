package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.forms.FormMock;
import de.espirit.firstspirit.agency.FormsAgent;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.agency.FormsAgentMock.formsAgentWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class FormsAgentMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return FormsAgentMock.class;
    }

    @Test
    public void testAForm() {
        FormsAgent formsAgent = build(formsAgentWith().aForm(FormMock::formWith, "test"));
        assertThat(formsAgent.getForm("test"), is(notNullValue()));
    }
}
