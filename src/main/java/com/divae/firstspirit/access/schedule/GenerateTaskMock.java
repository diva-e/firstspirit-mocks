package com.divae.firstspirit.access.schedule;

import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.schedule.ScheduleTaskMock.DefaultScheduleTaskBuilder;
import com.divae.firstspirit.access.schedule.ScheduleTaskMock.ScheduleTaskBuilder;
import com.divae.firstspirit.access.store.IDProviderMock.IDProviderBuilder;
import de.espirit.firstspirit.access.schedule.GenerateTask;
import de.espirit.firstspirit.access.store.IDProvider;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class GenerateTaskMock {

	private GenerateTaskMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static GenerateTaskBuilder generateTaskWith(String name) {
		return new DefaultGenerateTaskBuilder(name);
	}

	public interface GenerateTaskBuilder extends ScheduleTaskBuilder<GenerateTask, GenerateTaskBuilder> {
		<T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> GenerateTaskBuilder startNodes(List<TBUILDER> startNodes);
	}

	public static final class DefaultGenerateTaskBuilder extends DefaultScheduleTaskBuilder<GenerateTask, GenerateTaskBuilder, DefaultGenerateTaskBuilder> implements GenerateTaskBuilder {

		private DefaultGenerateTaskBuilder(String name) {
			super(name);
		}

		@Override
		public final <T extends IDProvider, TBUILDER extends IDProviderBuilder<T, TBUILDER>> GenerateTaskBuilder startNodes(List<TBUILDER> startNodes) {
			List<IDProvider> idProviders = startNodes.stream().map(DefaultBuilder::getBuildable).collect(toList());
			when(getBuildable().getStartNodes()).thenReturn(idProviders);
			return getBuilder();
		}
	}
}
