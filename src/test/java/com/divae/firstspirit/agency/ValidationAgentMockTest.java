package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.agency.MultiFormValidationReportMock.MultiFormValidationReportBuilder;
import de.espirit.firstspirit.access.store.mediastore.Media;
import de.espirit.firstspirit.agency.MultiFormValidationReport;
import de.espirit.firstspirit.agency.ValidationAgent;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.store.mediastore.MediaMock.mediaWith;
import static com.divae.firstspirit.agency.MultiFormValidationReportMock.multiFormValidationReportWith;
import static com.divae.firstspirit.agency.ValidationAgentMock.validationAgentWith;
import static de.espirit.firstspirit.agency.ValidationAgent.ValidationScope.RELEASE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidationAgentMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return ValidationAgentMock.class;
    }

    @Test
    public void testAReleaseValidation() {
        Media media = build(mediaWith("test", 2, null));
        MultiFormValidationReportBuilder multiFormValidationReportBuilder = multiFormValidationReportWith().isValid(true);
        ValidationAgent validationAgent = build(validationAgentWith().aReleaseValidation(multiFormValidationReportBuilder, media));
        MultiFormValidationReport multiFormValidationReport = build(multiFormValidationReportBuilder);
        assertThat(validationAgent.validate(media, RELEASE), is(multiFormValidationReport));
    }
}
