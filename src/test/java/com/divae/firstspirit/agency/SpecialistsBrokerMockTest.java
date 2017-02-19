package com.divae.firstspirit.agency;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.agency.SpecialistTypeMock.SpecialistTypeBuilder;
import de.espirit.firstspirit.agency.SpecialistType;
import de.espirit.firstspirit.agency.SpecialistsBroker;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.agency.SpecialistsBrokerMock.specialistsBrokerWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SpecialistsBrokerMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return SpecialistsBrokerMock.class;
	}

	@Test
	public void testRequestSpecialist() {
		SpecialistTypeBuilder<String> specialistTypeBuilder = SpecialistTypeMock.specialistTypeWith();
		String instance = "test";
		SpecialistsBroker specialistsBroker = build(specialistsBrokerWith().requestSpecialist(instance, specialistTypeBuilder));
		SpecialistType<String> specialistType = build(specialistTypeBuilder);
		assertThat(specialistsBroker.requestSpecialist(specialistType), is(instance));
	}

	@Test
	public void testRequireSpecialist() {
		SpecialistTypeBuilder<String> specialistTypeBuilder = SpecialistTypeMock.specialistTypeWith();
		String instance = "test";
		SpecialistsBroker specialistsBroker = build(specialistsBrokerWith().requireSpecialist(instance, specialistTypeBuilder));
		SpecialistType<String> specialistType = build(specialistTypeBuilder);
		assertThat(specialistsBroker.requireSpecialist(specialistType), is(instance));
	}
}
