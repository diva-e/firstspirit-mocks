package com.divae.firstspirit.access.project;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.LanguageMock.LanguageBuilder;
import com.divae.firstspirit.access.UserServiceMock.UserServiceBuilder;
import com.divae.firstspirit.access.project.ResolutionMock.ResolutionBuilder;
import com.divae.firstspirit.access.project.TemplateSetMock.TemplateSetBuilder;
import com.divae.firstspirit.storage.RevisionMock.RevisionBuilder;
import de.espirit.firstspirit.access.Language;
import de.espirit.firstspirit.access.UserService;
import de.espirit.firstspirit.access.project.Project;
import de.espirit.firstspirit.access.project.Resolution;
import de.espirit.firstspirit.access.project.TemplateSet;
import de.espirit.firstspirit.storage.Revision;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class ProjectMock {

	private ProjectMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static ProjectBuilder projectWith(String name, long id, LanguageBuilder language) {
		return new DefaultProjectBuilder(name, id, language);
	}

	public interface ProjectBuilder extends Builder<Project, ProjectBuilder> {
		ProjectBuilder anOriginalResolution(Supplier<ResolutionBuilder> supplier);

		ProjectBuilder languages(List<LanguageBuilder> languages);

		ProjectBuilder anUserService(UserServiceBuilder userService);

		ProjectBuilder templateSets(Supplier<List<TemplateSetBuilder>> supplier);

		ProjectBuilder resolutions(Supplier<List<ResolutionBuilder>> supplier);

		ProjectBuilder aRevision(Supplier<RevisionBuilder> supplier, Date revisionDate);
	}

	public static final class DefaultProjectBuilder extends DefaultBuilder<Project, ProjectBuilder, DefaultProjectBuilder> implements ProjectBuilder {

		private DefaultProjectBuilder(String name, long id, LanguageBuilder language) {
			withMasterLanguage(language::isMasterLanguage);
			withId(id);
			withName(name);
		}

		@Override
		public final ProjectBuilder anOriginalResolution(Supplier<ResolutionBuilder> supplier) {
			Resolution resolution = build(supplier.get());
			when(getBuildable().getOriginalResolution()).thenReturn(resolution);
			return getBuilder();
		}

		private void withMasterLanguage(Supplier<LanguageBuilder> supplier) {
			LanguageBuilder masterLanguageBuilder = supplier.get().isMasterLanguage();
			languages(singletonList(masterLanguageBuilder));
			Language language = getBuildable(masterLanguageBuilder);
			when(getBuildable().getMasterLanguage()).thenReturn(language);
		}

		@Override
		public final ProjectBuilder languages(List<LanguageBuilder> languages) {
			List<Language> projectLanguages = new ArrayList<>(getBuildable().getLanguages());
			projectLanguages.addAll(languages.stream().map(DefaultBuilder::getBuildable).collect(toList()));
			when(getBuildable().getLanguages()).thenReturn(projectLanguages);
			return getBuilder();
		}

		private void withName(String name) {
			when(getBuildable().getName()).thenReturn(name);
		}

		@Override
		public final ProjectBuilder anUserService(UserServiceBuilder userService) {
			UserService buildable = getBuildable(userService);
			if (!getBuildable().equals(buildable.getProject())) {
				throw new IllegalArgumentException("UserService project has not this project. Please correct this.");
			}
			when(getBuildable().getUserService()).thenReturn(buildable);
			return getBuilder();
		}

		@Override
		public final ProjectBuilder templateSets(Supplier<List<TemplateSetBuilder>> supplier) {
			List<TemplateSet> templateSets = supplier.get().stream().map(BuilderMock::build).collect(toList());
			when(getBuildable().getTemplateSets()).thenReturn(templateSets);
			return getBuilder();
		}

		@Override
		public final ProjectBuilder resolutions(Supplier<List<ResolutionBuilder>> supplier) {
			List<Resolution> resolutions = supplier.get().stream().map(BuilderMock::build).collect(toList());
			when(getBuildable().getResolutions()).thenReturn(resolutions);
			return getBuilder();
		}

		private void withId(long id) {
			if (id < 0) {
				throw new IllegalArgumentException("Id [" + id + "] is negative. Please choose another value.");
			}
			when(getBuildable().getId()).thenReturn(id);
		}

		@Override
		public final ProjectBuilder aRevision(Supplier<RevisionBuilder> supplier, Date revisionDate) {
			Revision revision = build(supplier.get());
			when(getBuildable().getRevision(revisionDate)).thenReturn(revision);
			return getBuilder();
		}
	}

}
