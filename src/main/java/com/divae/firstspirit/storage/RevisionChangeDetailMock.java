package com.divae.firstspirit.storage;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.storage.ChangeType;
import de.espirit.firstspirit.storage.RevisionChangeDetail;

import static org.mockito.Mockito.when;

public final class RevisionChangeDetailMock {

    private RevisionChangeDetailMock() {
        throw new UnsupportedOperationException("Don't use default constructor");
    }

    public static <T extends RevisionChangeDetail> TruncatedRevisionChangeDetailBuilder<T> revisionChangeDetailWith() {
        return new TruncatedDefaultRevisionChangeDetailBuilder<>();
    }

    public interface RevisionChangeDetailBuilder<T extends RevisionChangeDetail, TBUILDER extends RevisionChangeDetailBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
        TBUILDER aChangeType(ChangeType changeType);
    }

    public static class DefaultRevisionChangeDetailBuilder<T extends RevisionChangeDetail, EBUILDER extends RevisionChangeDetailBuilder<T, EBUILDER>, TBUILDER extends DefaultRevisionChangeDetailBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements RevisionChangeDetailBuilder<T, EBUILDER> {

        protected DefaultRevisionChangeDetailBuilder() {
        }

        @Override
        public final EBUILDER aChangeType(ChangeType changeType) {
            when(getBuildable().getChangeType()).thenReturn(changeType);
            return getInterfaceBuilder();
        }
    }

    public interface TruncatedRevisionChangeDetailBuilder<T extends RevisionChangeDetail> extends RevisionChangeDetailBuilder<T, TruncatedRevisionChangeDetailBuilder<T>> {
    }

    private static final class TruncatedDefaultRevisionChangeDetailBuilder<T extends RevisionChangeDetail> extends DefaultRevisionChangeDetailBuilder<T, TruncatedRevisionChangeDetailBuilder<T>, TruncatedDefaultRevisionChangeDetailBuilder<T>> implements TruncatedRevisionChangeDetailBuilder<T> {

        private TruncatedDefaultRevisionChangeDetailBuilder() {
        }
    }
}
