package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.agency.ModuleResultMock.ModuleResultBuilder;
import de.espirit.firstspirit.agency.ModuleAdminAgent;
import de.espirit.firstspirit.agency.ModuleAdminAgent.ModuleResult;
import de.espirit.firstspirit.server.module.ModuleException;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class ModuleAdminAgentMock {

	private ModuleAdminAgentMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static ModuleAdminAgentBuilder moduleAdminAgentWith() {
		return new DefaultModuleAdminAgentBuilder();
	}

	public interface ModuleAdminAgentBuilder extends Builder<ModuleAdminAgent, ModuleAdminAgentBuilder> {
		ModuleAdminAgentBuilder install(Supplier<ModuleResultBuilder> supplier, InputStream fsmStream, boolean updateUsages) throws ModuleException, IOException;
	}

	public static final class DefaultModuleAdminAgentBuilder extends DefaultBuilder<ModuleAdminAgent, ModuleAdminAgentBuilder, DefaultModuleAdminAgentBuilder> implements ModuleAdminAgentBuilder {

		private DefaultModuleAdminAgentBuilder() {
		}

		@Override
		public final ModuleAdminAgentBuilder install(Supplier<ModuleResultBuilder> supplier, InputStream fsmStream, boolean updateUsages) throws ModuleException, IOException {
			ModuleResult moduleResult = build(supplier.get());
			when(getBuildable().install(fsmStream, updateUsages)).thenReturn(moduleResult);
			return getBuilder();
		}
	}
}
