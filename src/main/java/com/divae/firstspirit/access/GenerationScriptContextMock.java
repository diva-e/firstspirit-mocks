package com.divae.firstspirit.access;

import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.project.ProjectScriptContextMock.DefaultProjectScriptContextBuilder;
import com.divae.firstspirit.access.project.ProjectScriptContextMock.ProjectScriptContextBuilder;
import de.espirit.firstspirit.access.GenerationScriptContext;

public final class GenerationScriptContextMock {

	private GenerationScriptContextMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends GenerationScriptContext> TruncatedGenerationScriptContextBuilder<T> generationScriptContextWith(ProjectBuilder project) {
		return new TruncatedDefaultGenerationScriptContextBuilder<>(project);
	}

	public interface GenerationScriptContextBuilder<T extends GenerationScriptContext, TBUILDER extends GenerationScriptContextBuilder<T, TBUILDER>> extends ProjectScriptContextBuilder<T, TBUILDER> {
	}

	public static class DefaultGenerationScriptContextBuilder<T extends GenerationScriptContext, EBUILDER extends GenerationScriptContextBuilder<T, EBUILDER>, TBUILDER extends DefaultGenerationScriptContextBuilder<T, EBUILDER, TBUILDER>> extends DefaultProjectScriptContextBuilder<T, EBUILDER, TBUILDER> implements GenerationScriptContextBuilder<T, EBUILDER> {

		protected DefaultGenerationScriptContextBuilder(ProjectBuilder project) {
			super(project);
		}
	}

	public interface TruncatedGenerationScriptContextBuilder<T extends GenerationScriptContext> extends GenerationScriptContextBuilder<T, TruncatedGenerationScriptContextBuilder<T>> {
	}

	private static final class TruncatedDefaultGenerationScriptContextBuilder<T extends GenerationScriptContext> extends DefaultGenerationScriptContextBuilder<T, TruncatedGenerationScriptContextBuilder<T>, TruncatedDefaultGenerationScriptContextBuilder<T>> implements TruncatedGenerationScriptContextBuilder<T> {

		TruncatedDefaultGenerationScriptContextBuilder(ProjectBuilder project) {
			super(project);
		}
	}

}
