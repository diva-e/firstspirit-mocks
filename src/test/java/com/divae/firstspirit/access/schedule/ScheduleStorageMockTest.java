package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import de.espirit.firstspirit.access.schedule.ScheduleEntry;
import de.espirit.firstspirit.access.schedule.ScheduleEntryControl;
import de.espirit.firstspirit.access.schedule.ScheduleStorage;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.schedule.ScheduleEntryControlMock.scheduleEntryControlWith;
import static com.divae.firstspirit.access.schedule.ScheduleEntryMock.scheduleEntryWith;
import static com.divae.firstspirit.access.schedule.ScheduleStorageMock.scheduleStorageWith;
import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ScheduleStorageMockTest extends MockTest {

	@Override
	protected Class<?> getFactoryClass() {
		return ScheduleStorageMock.class;
	}

	@Test
	public void testScheduleEntries() {
		ProjectBuilder project = projectWith("test", 0, languageWith("DE"));
		ScheduleStorage scheduleStorage = build(scheduleStorageWith().scheduleEntries(() -> singletonMap(project, singletonList(scheduleEntryWith(0L, project)))));
		List<ScheduleEntry> scheduleEntries = scheduleStorage.getScheduleEntries(build(project));
		assertThat(scheduleEntries.size(), is(1));
		assertThat(scheduleEntries.get(0).getId(), is(0L));
	}

	@Test
	public void testRunningEntries() {
		ScheduleStorage scheduleStorage = build(scheduleStorageWith().runningEntries(singletonList(scheduleEntryControlWith(0L))));
		List<ScheduleEntryControl> scheduleEntryControls = scheduleStorage.getRunningEntries();
		assertThat(scheduleEntryControls.size(), is(1));
		assertThat(scheduleEntryControls.get(0).getId(), is(0L));
	}

	@Test
	public void testAHistory() {
		ProjectBuilder project = projectWith("test", 0, languageWith("DE"));
		Date fromDate = new Date();
		Date untilDate = new Date();
		int maxCount = 1;
		ScheduleStorage scheduleStorage = build(scheduleStorageWith().aHistory(() -> singletonMap(project, singletonList(scheduleEntryControlWith(0L).aScheduleEntry(scheduleEntryWith(0L, project)))), fromDate, untilDate, maxCount));
		List<ScheduleEntryControl> scheduleEntryControls = scheduleStorage.getHistory(fromDate, untilDate, maxCount, build(project));
		assertThat(scheduleEntryControls.size(), is(1));
		assertThat(scheduleEntryControls.get(0).getId(), is(0L));
	}
}
