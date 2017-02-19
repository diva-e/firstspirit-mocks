package com.divae.firstspirit.access;

import com.divae.firstspirit.access.project.ProjectMock.ProjectBuilder;
import com.divae.firstspirit.access.project.ProjectScriptContextMock.DefaultProjectScriptContextBuilder;
import com.divae.firstspirit.access.project.ProjectScriptContextMock.ProjectScriptContextBuilder;
import de.espirit.firstspirit.access.GuiScriptContext;

public final class GuiScriptContextMock {

	private GuiScriptContextMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends GuiScriptContext> TruncatedGuiScriptContextBuilder<T> guiScriptContextWith(ProjectBuilder project) {
		return new TruncatedDefaultGuiScriptContextBuilder<>(project);
	}

	public interface GuiScriptContextBuilder<T extends GuiScriptContext, TBUILDER extends GuiScriptContextBuilder<T, TBUILDER>> extends ProjectScriptContextBuilder<T, TBUILDER> {
	}

	public static class DefaultGuiScriptContextBuilder<T extends GuiScriptContext, EBUILDER extends GuiScriptContextBuilder<T, EBUILDER>, TBUILDER extends DefaultGuiScriptContextBuilder<T, EBUILDER, TBUILDER>> extends DefaultProjectScriptContextBuilder<T, EBUILDER, TBUILDER> implements GuiScriptContextBuilder<T, EBUILDER> {

		protected DefaultGuiScriptContextBuilder(ProjectBuilder project) {
			super(project);
		}
	}

	public interface TruncatedGuiScriptContextBuilder<T extends GuiScriptContext> extends GuiScriptContextBuilder<T, TruncatedGuiScriptContextBuilder<T>> {
	}

	private static final class TruncatedDefaultGuiScriptContextBuilder<T extends GuiScriptContext> extends DefaultGuiScriptContextBuilder<T, TruncatedGuiScriptContextBuilder<T>, TruncatedDefaultGuiScriptContextBuilder<T>> implements TruncatedGuiScriptContextBuilder<T> {

		TruncatedDefaultGuiScriptContextBuilder(ProjectBuilder project) {
			super(project);
		}
	}
}