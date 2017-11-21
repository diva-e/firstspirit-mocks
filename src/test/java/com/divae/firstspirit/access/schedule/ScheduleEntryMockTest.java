package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.schedule.GenerateTask;
import de.espirit.firstspirit.access.schedule.ScheduleEntry;
import de.espirit.firstspirit.access.schedule.ScheduleEntryRunningException;
import de.espirit.firstspirit.access.schedule.ScheduleTask;
import org.junit.Test;

import java.util.List;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.LanguageMock.languageWith;
import static com.divae.firstspirit.access.project.ProjectMock.projectWith;
import static com.divae.firstspirit.access.schedule.GenerateTaskMock.generateTaskWith;
import static com.divae.firstspirit.access.schedule.ScheduleEntryControlMock.scheduleEntryControlWith;
import static com.divae.firstspirit.access.schedule.ScheduleEntryMock.scheduleEntryWith;
import static java.lang.Boolean.TRUE;
import static java.lang.Integer.valueOf;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ScheduleEntryMockTest extends MockTest {

    @Test
    public void testScheduleEntryProjectWith() {
        assertThat(scheduleEntryWith(0L, projectWith("test", 0, languageWith("DE"))), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return ScheduleEntryMock.class;
    }

    @Test
    public void testDefaults() {
        ScheduleEntry scheduleEntry = build(scheduleEntryWith(0L, projectWith("test", 0, languageWith("DE"))));
        assertThat(scheduleEntry.getTasks().isEmpty(), is(TRUE));
        assertThat(scheduleEntry.getProject(), is(notNullValue()));
    }

    @Test
    public void testANameString() {
        String name = "test";
        ScheduleEntry scheduleEntry = build(scheduleEntryWith(0L, projectWith("test", 0, languageWith("DE"))).aName(name));
        assertThat(scheduleEntry.getName(), is(name));
    }

    @Test
    public void testAScheduleEntryControlAfterExecuteScheduleEntryControl() throws ScheduleEntryRunningException {
        ScheduleEntry scheduleEntry = build(scheduleEntryWith(0L, projectWith("test", 0, languageWith("DE"))).aScheduleEntryControlAfterExecute(() -> scheduleEntryControlWith(0L)));
        assertThat(scheduleEntry.execute().getId(), is(0L));
    }

    @Test
    public void testTasks() {
        GenerateTaskMock.GenerateTaskBuilder generateTaskBuilder = generateTaskWith("test");
        ScheduleEntry scheduleEntry = build(scheduleEntryWith(0L, projectWith("test", 0, languageWith("DE"))).tasks(singletonList(generateTaskBuilder)));
        GenerateTask generateTask = build(generateTaskBuilder);
        List<ScheduleTask> tasks = scheduleEntry.getTasks();
        assertThat(tasks.size(), is(valueOf(1)));
        assertThat(tasks.get(0), is(generateTask));
    }

    @Test
    public void testWithScheduleEntryControlAfterExecuteTBUILDER() throws ScheduleEntryRunningException {
        ScheduleEntry scheduleEntry = build(scheduleEntryWith(0L, projectWith("test", 0, languageWith("DE"))).withScheduleEntryControlAfterExecute(() -> scheduleEntryControlWith(0L)));
        assertThat(scheduleEntry.execute().getId(), is(0L));
    }
}
