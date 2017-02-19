package com.divae.firstspirit.access;

import com.divae.firstspirit.access.GenerationScriptContextMock.DefaultGenerationScriptContextBuilder;
import com.divae.firstspirit.access.GenerationScriptContextMock.GenerationScriptContextBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import de.espirit.firstspirit.access.GenerationContext;

public class GenerationContextMock {

	private GenerationContextMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static GenerationContextBuilder generationContextWith(ProjectBuilder project) {
		return new DefaultGenerationContextBuilder(project);
	}

	public interface GenerationContextBuilder extends GenerationScriptContextBuilder<GenerationContext, GenerationContextBuilder> {
	}

	public static final class DefaultGenerationContextBuilder extends DefaultGenerationScriptContextBuilder<GenerationContext, GenerationContextBuilder, DefaultGenerationContextBuilder> implements GenerationContextBuilder {

		private DefaultGenerationContextBuilder(ProjectBuilder project) {
			super(project);
		}
	}
}
