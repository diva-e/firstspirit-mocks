package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.MockTest;
import com.divae.firstspirit.access.schedule.GenerateTaskMock.GenerateTaskBuilder;
import de.espirit.firstspirit.access.schedule.GenerateTask;
import de.espirit.firstspirit.access.schedule.TaskResult;
import org.junit.Test;

import static com.divae.firstspirit.BuilderMock.build;
import static com.divae.firstspirit.access.schedule.GenerateTaskMock.generateTaskWith;
import static com.divae.firstspirit.access.schedule.TaskResultMock.taskResultWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TaskResultMockTest extends MockTest {

    @Override
    protected Class<?> getFactoryClass() {
        return TaskResultMock.class;
    }

    @Test
    public void testATask() {
        GenerateTaskBuilder generateTaskBuilder = generateTaskWith("test");
        TaskResult taskResult = build(taskResultWith().aTask(generateTaskBuilder));
        GenerateTask generateTask = build(generateTaskBuilder);
        assertThat(taskResult.getTask(), is(generateTask));
    }

    @Test
    public void testAnErrorCount() {
        TaskResult taskResult = build(taskResultWith().anErrorCount(1));
        assertThat(taskResult.getErrorCount(), is(1));
    }

    @Test
    public void testAWarningCount() {
        TaskResult taskResult = build(taskResultWith().aWarningCount(1));
        assertThat(taskResult.getWarningCount(), is(1));
    }
}
