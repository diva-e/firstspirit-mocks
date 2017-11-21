package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.schedule.ScheduleTask;

import static org.mockito.Mockito.when;

public final class ScheduleTaskMock {

    private ScheduleTaskMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends ScheduleTask> TruncatedScheduleTaskBuilder<T> scheduleTaskWith(String name) {
        return new DefaultTruncatedScheduleTaskBuilder<>(name);
    }

    public interface ScheduleTaskBuilder<T extends ScheduleTask, TBUILDER extends ScheduleTaskBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
    }

    public static class DefaultScheduleTaskBuilder<T extends ScheduleTask, EBUILDER extends ScheduleTaskBuilder<T, EBUILDER>, TBUILDER extends DefaultScheduleTaskBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements ScheduleTaskBuilder<T, EBUILDER> {

        protected DefaultScheduleTaskBuilder(String name) {
            super(name);
            withName(name);
        }

        private void withName(String name) {
            when(getBuildable().getName()).thenReturn(name);
        }
    }

    public interface TruncatedScheduleTaskBuilder<T extends ScheduleTask> extends ScheduleTaskBuilder<T, TruncatedScheduleTaskBuilder<T>> {
    }

    private static final class DefaultTruncatedScheduleTaskBuilder<T extends ScheduleTask> extends DefaultScheduleTaskBuilder<T, TruncatedScheduleTaskBuilder<T>, DefaultTruncatedScheduleTaskBuilder<T>> implements TruncatedScheduleTaskBuilder<T> {

        private DefaultTruncatedScheduleTaskBuilder(String name) {
            super(name);
        }
    }
}
