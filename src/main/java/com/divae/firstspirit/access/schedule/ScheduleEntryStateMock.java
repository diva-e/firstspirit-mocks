package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.schedule.TaskResultMock.TaskResultBuilder;
import de.espirit.firstspirit.access.schedule.ScheduleEntryState;
import de.espirit.firstspirit.access.schedule.TaskResult;

import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public class ScheduleEntryStateMock {

	private ScheduleEntryStateMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static ScheduleEntryStateBuilder scheduleEntryStateWith(long id) {
		return new DefaultScheduleEntryStateBuilder(id);
	}

	public interface ScheduleEntryStateBuilder extends Builder<ScheduleEntryState, ScheduleEntryStateBuilder> {
		ScheduleEntryStateBuilder taskResults(Supplier<List<TaskResultBuilder>> supplier);
	}

	public static final class DefaultScheduleEntryStateBuilder extends DefaultBuilder<ScheduleEntryState, ScheduleEntryStateBuilder, DefaultScheduleEntryStateBuilder> implements ScheduleEntryStateBuilder {

		private DefaultScheduleEntryStateBuilder(long id) {
			super(id);
			anId(id);
		}

		@Override
		public final ScheduleEntryStateBuilder taskResults(Supplier<List<TaskResultBuilder>> supplier) {
			List<TaskResult> templateSets = supplier.get().stream().map(BuilderMock::build).collect(toList());
			when(getBuildable().getTaskResults()).thenReturn(templateSets);
			return getBuilder();
		}

		private void anId(long id) {
			when(getBuildable().getId()).thenReturn(id);
		}

	}
}
