package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.MockTest;
import de.espirit.firstspirit.access.schedule.ScheduleEntryState;
import de.espirit.firstspirit.access.schedule.TaskResult;
import org.junit.Test;

import java.util.List;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.schedule.ScheduleEntryStateMock.scheduleEntryStateWith;
import static com.divae.firstspirit.access.schedule.TaskResultMock.taskResultWith;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ScheduleEntryStateMockTest extends MockTest {

    @Test
    public void testScheduleEntryStateWith() {
        assertThat(scheduleEntryStateWith(0L), is(notNullValue()));
    }

    @Override
    protected Class<?> getFactoryClass() {
        return ScheduleEntryStateMock.class;
    }

    @Test
    public void testTaskResults() {
        ScheduleEntryState scheduleEntryState = build(scheduleEntryStateWith(0L).taskResults(() -> singletonList(taskResultWith())));
        List<TaskResult> taskResults = scheduleEntryState.getTaskResults();
        assertThat(taskResults.size(), is(1));
        assertThat(taskResults.get(0), is(notNullValue()));
    }
}
