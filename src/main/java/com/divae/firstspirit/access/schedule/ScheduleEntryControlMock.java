package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.schedule.ScheduleEntryMock.ScheduleEntryBuilder;
import com.divae.firstspirit.access.schedule.ScheduleEntryStateMock.ScheduleEntryStateBuilder;
import de.espirit.firstspirit.access.schedule.ScheduleEntryControl;
import de.espirit.firstspirit.access.schedule.ScheduleEntryState;

import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class ScheduleEntryControlMock {

	private ScheduleEntryControlMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static ScheduleEntryControlBuilder scheduleEntryControlWith(long id) {
		return new DefaultScheduleEntryControlBuilder(id);
	}

	public interface ScheduleEntryControlBuilder extends Builder<ScheduleEntryControl, ScheduleEntryControlBuilder> {
		ScheduleEntryControlBuilder aScheduleEntry(ScheduleEntryBuilder scheduleEntry);

		ScheduleEntryControlBuilder aState(Supplier<ScheduleEntryStateBuilder> supplier);

		ScheduleEntryControlBuilder isRunning(boolean isRunning);
	}

	public static final class DefaultScheduleEntryControlBuilder extends DefaultBuilder<ScheduleEntryControl, ScheduleEntryControlBuilder, DefaultScheduleEntryControlBuilder> implements ScheduleEntryControlBuilder {

		private DefaultScheduleEntryControlBuilder(long id) {
			super(id);
			anId(id);
		}

		@Override
		public final ScheduleEntryControlBuilder aScheduleEntry(ScheduleEntryBuilder scheduleEntry) {
			when(getBuildable().getScheduleEntry()).thenReturn(getBuildable(scheduleEntry));
			return getBuilder();
		}

		@Override
		public final ScheduleEntryControlBuilder aState(Supplier<ScheduleEntryStateBuilder> supplier) {
			ScheduleEntryState scheduleEntryState = build(supplier.get());
			when(getBuildable().getState()).thenReturn(scheduleEntryState);
			return getBuilder();
		}

		@Override
		public final ScheduleEntryControlBuilder isRunning(boolean isRunning) {
			when(getBuildable().isRunning()).thenReturn(isRunning);
			return getBuilder();
		}

		private void anId(long id) {
			when(getBuildable().getId()).thenReturn(id);
		}
	}
}
