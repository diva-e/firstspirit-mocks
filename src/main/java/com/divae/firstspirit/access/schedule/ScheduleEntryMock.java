package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.schedule.ScheduleEntryControlMock.ScheduleEntryControlBuilder;
import com.divae.firstspirit.access.schedule.ScheduleTaskMock.ScheduleTaskBuilder;
import de.espirit.firstspirit.access.schedule.ScheduleEntry;
import de.espirit.firstspirit.access.schedule.ScheduleEntryControl;
import de.espirit.firstspirit.access.schedule.ScheduleEntryRunningException;
import de.espirit.firstspirit.access.schedule.ScheduleTask;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class ScheduleEntryMock {

	private ScheduleEntryMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static ScheduleEntryBuilder scheduleEntryWith(long id, ProjectBuilder project) {
		return new DefaultScheduleEntryBuilder(id, project);
	}

	public interface ScheduleEntryBuilder extends Builder<ScheduleEntry, ScheduleEntryBuilder> {
		ScheduleEntryBuilder aName(String name);

		ScheduleEntryBuilder aScheduleEntryControlAfterExecute(Supplier<ScheduleEntryControlBuilder> supplier) throws ScheduleEntryRunningException;

		<T extends ScheduleTask, TBUILDER extends ScheduleTaskBuilder<T, TBUILDER>> ScheduleEntryBuilder tasks(List<TBUILDER> scheduleTasks);

		ScheduleEntryBuilder withScheduleEntryControlAfterExecute(Supplier<ScheduleEntryControlBuilder> supplier) throws ScheduleEntryRunningException;
	}

	public static final class DefaultScheduleEntryBuilder extends DefaultBuilder<ScheduleEntry, ScheduleEntryBuilder, DefaultScheduleEntryBuilder> implements ScheduleEntryBuilder {

		@SuppressWarnings("unchecked")
		private DefaultScheduleEntryBuilder(long id, ProjectBuilder project) {
			super(id);
			anId(id);
			tasks(Collections.<ScheduleTaskBuilder>emptyList());
			withProject(project);
		}

		@Override
		public final ScheduleEntryBuilder aName(String name) {
			when(getBuildable().getName()).thenReturn(name);
			return getBuilder();
		}

		@Override
		public final ScheduleEntryBuilder aScheduleEntryControlAfterExecute(Supplier<ScheduleEntryControlBuilder> supplier) throws ScheduleEntryRunningException {
			ScheduleEntryControl scheduleEntryControl = build(supplier.get().aScheduleEntry(getBuilder()));
			when(getBuildable().execute()).thenReturn(scheduleEntryControl);
			return getBuilder();
		}

		private void withProject(ProjectBuilder project) {
			when(getBuildable().getProject()).thenReturn(getBuildable(project));
		}

		private void anId(long id) {
			when(getBuildable().getId()).thenReturn(id);
		}

		@Override
		public final <T extends ScheduleTask, TBUILDER extends ScheduleTaskBuilder<T, TBUILDER>> ScheduleEntryBuilder tasks(List<TBUILDER> scheduleTasks) {
			when(getBuildable().getTasks()).thenReturn(scheduleTasks.stream().map(DefaultBuilder::getBuildable).collect(toList()));
			return getBuilder();
		}

		@Override
		public final ScheduleEntryBuilder withScheduleEntryControlAfterExecute(Supplier<ScheduleEntryControlBuilder> supplier) throws ScheduleEntryRunningException {
			ScheduleEntryControl scheduleEntryControl = build(supplier.get().aScheduleEntry(getBuilder()));
			when(getBuildable().execute()).thenReturn(scheduleEntryControl);
			return getBuilder();
		}

	}

}
