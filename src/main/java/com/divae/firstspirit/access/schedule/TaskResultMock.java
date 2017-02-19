package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.schedule.ScheduleTaskMock.ScheduleTaskBuilder;
import de.espirit.firstspirit.access.schedule.ScheduleTask;
import de.espirit.firstspirit.access.schedule.TaskResult;

import static org.mockito.Mockito.when;

public final class TaskResultMock {

	private TaskResultMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static TaskResultBuilder taskResultWith() {
		return new DefaultTaskResultBuilder();
	}

	public interface TaskResultBuilder extends Builder<TaskResult, TaskResultBuilder> {
		<T extends ScheduleTask, TBUILDER extends ScheduleTaskBuilder<T, TBUILDER>> TaskResultBuilder aTask(TBUILDER scheduleTask);

		TaskResultBuilder anErrorCount(int errorCount);

		TaskResultBuilder aWarningCount(int warningCount);
	}

	public static final class DefaultTaskResultBuilder extends DefaultBuilder<TaskResult, TaskResultBuilder, DefaultTaskResultBuilder> implements TaskResultBuilder {

		private DefaultTaskResultBuilder() {
		}

		@Override
		public final <T extends ScheduleTask, TBUILDER extends ScheduleTaskBuilder<T, TBUILDER>> TaskResultBuilder aTask(TBUILDER scheduleTask) {
			when(getBuildable().getTask()).thenReturn(getBuildable(scheduleTask));
			return getBuilder();
		}

		@Override
		public final TaskResultBuilder anErrorCount(int errorCount) {
			when(getBuildable().getErrorCount()).thenReturn(errorCount);
			return getBuilder();
		}

		@Override
		public final TaskResultBuilder aWarningCount(int warningCount) {
			when(getBuildable().getWarningCount()).thenReturn(warningCount);
			return getBuilder();
		}
	}
}
