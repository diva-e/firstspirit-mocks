package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.agency.ModuleAdminAgent.ModuleResult;

public final class ModuleResultMock {

    private ModuleResultMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static ModuleResultBuilder moduleResultWith() {
        return new DefaultModuleResultBuilder();
    }

    public interface ModuleResultBuilder extends Builder<ModuleResult, ModuleResultBuilder> {
    }

    private static final class DefaultModuleResultBuilder extends DefaultBuilder<ModuleResult, ModuleResultBuilder, DefaultModuleResultBuilder> implements ModuleResultBuilder {

        private DefaultModuleResultBuilder() {
        }
    }
}
