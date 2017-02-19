package com.divae.firstspirit.access.admin;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import de.espirit.firstspirit.access.admin.ProjectStorage;
import de.espirit.firstspirit.access.project.Project;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

public final class ProjectStorageMock {

	private ProjectStorageMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static ProjectStorageBuilder projectStorageWith() {
		return new DefaultProjectStorageBuilder();
	}

	public interface ProjectStorageBuilder extends Builder<ProjectStorage, ProjectStorageBuilder> {
		ProjectStorageBuilder projects(Supplier<ProjectBuilder[]> supplier);
	}

	public static final class DefaultProjectStorageBuilder extends DefaultBuilder<ProjectStorage, ProjectStorageBuilder, DefaultProjectStorageBuilder> implements ProjectStorageBuilder {

		private DefaultProjectStorageBuilder() {
		}

		@Override
		public final ProjectStorageBuilder projects(Supplier<ProjectBuilder[]> supplier) {
			Project[] projects = Stream.of(supplier.get()).map(BuilderMock::build).toArray(Project[]::new);
			when(getBuildable().getProjects()).thenReturn(projects);
			return getBuilder();
		}
	}
}
