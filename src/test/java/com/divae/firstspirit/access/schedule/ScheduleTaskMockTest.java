package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.schedule.ScheduleTask;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.schedule.ScheduleTaskMock.scheduleTaskWith;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ScheduleTaskMockTest extends MockTest {

	@Test
	public void testScheduleTaskWith() {
		assertThat(scheduleTaskWith("test"), is(notNullValue()));
	}

	@Override
	protected Class<?> getFactoryClass() {
		return ScheduleTaskMock.class;
	}


	@Test
	public void testDefaults() {
		String name = "test";
		ScheduleTask scheduleTask = build(scheduleTaskWith(name));
		assertThat(scheduleTask.getName(), is(name));
	}
}
