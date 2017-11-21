package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.agency.MultiFormValidationReport;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.agency.MultiFormValidationReportMock.multiFormValidationReportWith;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiFormValidationReportMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return MultiFormValidationReportMock.class;
    }

    @Test
    public void testIsValid() {
        MultiFormValidationReport multiFormValidationReport = build(multiFormValidationReportWith().isValid(true));
        assertThat(multiFormValidationReport.isValid(), is(TRUE));
    }


}
