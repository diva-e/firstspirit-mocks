package com.divae.firstspirit.access.project;

import com.divae.firstspirit.access.ScriptContextMock.DefaultScriptContextBuilder;
import com.divae.firstspirit.access.ScriptContextMock.ScriptContextBuilder;
import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import de.espirit.firstspirit.access.project.ProjectScriptContext;

import static org.mockito.Mockito.when;


public final class ProjectScriptContextMock {

    private ProjectScriptContextMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends ProjectScriptContext> TruncatedProjectScriptContextBuilder<T> projectScriptContextWith(ProjectBuilder project) {
        return new DefaultTruncatedProjectScriptContextBuilder<>(project);
    }

    public interface ProjectScriptContextBuilder<T extends ProjectScriptContext, TBUILDER extends ProjectScriptContextBuilder<T, TBUILDER>> extends ScriptContextBuilder<T, TBUILDER> {
    }

    public static class DefaultProjectScriptContextBuilder<T extends ProjectScriptContext, EBUILDER extends ProjectScriptContextBuilder<T, EBUILDER>, TBUILDER extends DefaultProjectScriptContextBuilder<T, EBUILDER, TBUILDER>> extends DefaultScriptContextBuilder<T, EBUILDER, TBUILDER> implements ProjectScriptContextBuilder<T, EBUILDER> {

        protected DefaultProjectScriptContextBuilder(ProjectBuilder project) {
            withProject(project);
        }

        private void withProject(ProjectBuilder project) {
            when(getBuildable().getProject()).thenReturn(getBuildable(project));
        }
    }

    public interface TruncatedProjectScriptContextBuilder<T extends ProjectScriptContext> extends ProjectScriptContextBuilder<T, TruncatedProjectScriptContextBuilder<T>> {
    }

    private static final class DefaultTruncatedProjectScriptContextBuilder<T extends ProjectScriptContext> extends DefaultProjectScriptContextBuilder<T, TruncatedProjectScriptContextBuilder<T>, DefaultTruncatedProjectScriptContextBuilder<T>> implements TruncatedProjectScriptContextBuilder<T> {

        private DefaultTruncatedProjectScriptContextBuilder(ProjectBuilder project) {
            super(project);
        }
    }
}
