package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.schedule.ScheduleEntryMock.ScheduleEntryBuilder;
import de.espirit.firstspirit.access.schedule.ScheduleEntry;
import de.espirit.firstspirit.access.schedule.ScheduleEntryControl;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.schedule.ScheduleEntryControlMock.scheduleEntryControlWith;
import static com.divae.firstspirit.access.schedule.ScheduleEntryMock.scheduleEntryWith;
import static com.divae.firstspirit.access.schedule.ScheduleEntryStateMock.scheduleEntryStateWith;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ScheduleEntryControlMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return ScheduleEntryControlMock.class;
	}

	@Test
	public void testAScheduleEntryScheduleEntry() {
		ScheduleEntryBuilder scheduleEntryBuilder = scheduleEntryWith(0L, projectWith("test", 0, languageWith("DE")));
		ScheduleEntryControl scheduleEntryControl = build(scheduleEntryControlWith(0L).aScheduleEntry(scheduleEntryBuilder));
		ScheduleEntry scheduleEntry = build(scheduleEntryBuilder);
		assertThat(scheduleEntryControl.getScheduleEntry(), is(scheduleEntry));
	}

	@Test
	public void testAState() {
		ScheduleEntryControl scheduleEntryControl = build(scheduleEntryControlWith(0L).aState(() -> scheduleEntryStateWith(0L)));
		assertThat(scheduleEntryControl.getState().getId(), is(0L));
	}

	@Test
	public void testIsRunning() {
		ScheduleEntryControl scheduleEntryControl = build(scheduleEntryControlWith(0L).isRunning(true));
		assertThat(scheduleEntryControl.isRunning(), is(TRUE));
	}
}
