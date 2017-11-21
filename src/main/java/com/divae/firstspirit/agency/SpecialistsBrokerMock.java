package com.divae.firstspirit.agency;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.agency.SpecialistTypeMock.SpecialistTypeBuilder;
import de.espirit.firstspirit.agency.SpecialistsBroker;

import static org.mockito.Mockito.when;

public final class SpecialistsBrokerMock {

    private SpecialistsBrokerMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends SpecialistsBroker> TruncatedSpecialistsBrokerBuilder<T> specialistsBrokerWith() {
        return new TruncatedDefaultSpecialistsBrokerBuilder<>();
    }

    public interface SpecialistsBrokerBuilder<T extends SpecialistsBroker, TBUILDER extends SpecialistsBrokerBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
        <S> TBUILDER requestSpecialist(S instance, SpecialistTypeBuilder<S> specialistType);

        <S> TBUILDER requireSpecialist(S instance, SpecialistTypeBuilder<S> specialistType);
    }

    public static class DefaultSpecialistsBrokerBuilder<T extends SpecialistsBroker, EBUILDER extends SpecialistsBrokerBuilder<T, EBUILDER>, TBUILDER extends DefaultSpecialistsBrokerBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements SpecialistsBrokerBuilder<T, EBUILDER> {

        protected DefaultSpecialistsBrokerBuilder() {
        }

        @Override
        public final <S> EBUILDER requestSpecialist(S instance, SpecialistTypeBuilder<S> specialistType) {
            when(getBuildable().requestSpecialist(getBuildable(specialistType))).thenReturn(instance);
            return getInterfaceBuilder();
        }

        @Override
        public final <S> EBUILDER requireSpecialist(S instance, SpecialistTypeBuilder<S> specialistType) {
            when(getBuildable().requireSpecialist(getBuildable(specialistType))).thenReturn(instance);
            return getInterfaceBuilder();
        }
    }

    public interface TruncatedSpecialistsBrokerBuilder<T extends SpecialistsBroker> extends SpecialistsBrokerBuilder<T, TruncatedSpecialistsBrokerBuilder<T>> {
    }

    private static final class TruncatedDefaultSpecialistsBrokerBuilder<T extends SpecialistsBroker> extends DefaultSpecialistsBrokerBuilder<T, TruncatedSpecialistsBrokerBuilder<T>, TruncatedDefaultSpecialistsBrokerBuilder<T>> implements TruncatedSpecialistsBrokerBuilder<T> {

        private TruncatedDefaultSpecialistsBrokerBuilder() {
        }
    }
}
