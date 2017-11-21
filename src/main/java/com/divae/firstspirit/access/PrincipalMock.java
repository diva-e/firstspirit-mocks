package com.divae.firstspirit.access;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.access.Principal;

import static org.mockito.Mockito.when;

public final class PrincipalMock {

    private PrincipalMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends Principal> TruncatedPrincipalBuilder<T> principalWith(long id) {
        return new TruncatedDefaultPrincipalBuilder<>(id);
    }

    public interface PrincipalBuilder<T extends Principal, TBUILDER extends PrincipalBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
    }

    public static class DefaultPrincipalBuilder<T extends Principal, EBUILDER extends PrincipalBuilder<T, EBUILDER>, TBUILDER extends DefaultPrincipalBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements PrincipalBuilder<T, EBUILDER> {

        protected DefaultPrincipalBuilder(long id) {
            super(id);
            anId(id);
        }

        private void anId(long id) {
            when(getBuildable().getId()).thenReturn(id);
        }
    }

    public interface TruncatedPrincipalBuilder<T extends Principal> extends PrincipalBuilder<T, TruncatedPrincipalBuilder<T>> {
    }

    private static final class TruncatedDefaultPrincipalBuilder<T extends Principal> extends DefaultPrincipalBuilder<T, TruncatedPrincipalBuilder<T>, TruncatedDefaultPrincipalBuilder<T>> implements TruncatedPrincipalBuilder<T> {

        private TruncatedDefaultPrincipalBuilder(long id) {
            super(id);
        }
    }
}
