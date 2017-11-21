package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.schedule.ScheduleEntryControlMock.ScheduleEntryControlBuilder;
import com.divae.firstspirit.access.schedule.ScheduleEntryMock.ScheduleEntryBuilder;
import de.espirit.firstspirit.access.schedule.ScheduleEntry;
import de.espirit.firstspirit.access.schedule.ScheduleEntryControl;
import de.espirit.firstspirit.access.schedule.ScheduleStorage;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class ScheduleStorageMock {

    private ScheduleStorageMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static ScheduleStorageBuilder scheduleStorageWith() {
        return new DefaultScheduleStorageBuilder();
    }

    public interface ScheduleStorageBuilder extends Builder<ScheduleStorage, ScheduleStorageBuilder> {
        ScheduleStorageBuilder scheduleEntries(Supplier<Map<ProjectBuilder, List<ScheduleEntryBuilder>>> supplier);

        ScheduleStorageBuilder runningEntries(List<ScheduleEntryControlBuilder> scheduleEntryControls);

        ScheduleStorageBuilder aHistory(Supplier<Map<ProjectBuilder, List<ScheduleEntryControlBuilder>>> supplier, Date fromDate, Date untilDate, int maxCount);
    }

    public static final class DefaultScheduleStorageBuilder extends DefaultBuilder<ScheduleStorage, ScheduleStorageBuilder, DefaultScheduleStorageBuilder> implements ScheduleStorageBuilder {

        private DefaultScheduleStorageBuilder() {
        }

        @Override
        public final ScheduleStorageBuilder scheduleEntries(Supplier<Map<ProjectBuilder, List<ScheduleEntryBuilder>>> supplier) {
            supplier.get().forEach((project, scheduleEntryControlBuilders) -> {
                List<ScheduleEntry> scheduleEntries = scheduleEntryControlBuilders.stream().map(BuilderMock::build).collect(toList());
                when(getBuildable().getScheduleEntries(getBuildable(project))).thenReturn(scheduleEntries);
            });
            return getBuilder();
        }

        @Override
        public final ScheduleStorageBuilder runningEntries(List<ScheduleEntryControlBuilder> scheduleEntryControls) {
            when(getBuildable().getRunningEntries()).thenReturn(scheduleEntryControls.stream().map(DefaultBuilder::getBuildable).collect(toList()));
            return getBuilder();
        }

        @Override
        public final ScheduleStorageBuilder aHistory(Supplier<Map<ProjectBuilder, List<ScheduleEntryControlBuilder>>> supplier, Date fromDate, Date untilDate, int maxCount) {
            supplier.get().forEach((project, scheduleEntryControlBuilders) -> {
                List<ScheduleEntryControl> scheduleEntryControls = scheduleEntryControlBuilders.stream().map(BuilderMock::build).collect(toList());
                when(getBuildable().getHistory(fromDate, untilDate, maxCount, getBuildable(project))).thenReturn(scheduleEntryControls);
            });
            return getBuilder();
        }

    }
}
