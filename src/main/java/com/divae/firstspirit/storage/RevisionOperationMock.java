package com.divae.firstspirit.storage;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import de.espirit.firstspirit.storage.RevisionOperation;
import de.espirit.firstspirit.storage.RevisionOperation.OperationType;

import java.util.Collection;

import static org.mockito.Mockito.when;

public final class RevisionOperationMock {

	private RevisionOperationMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <OT, T extends RevisionOperation<OT>> TruncatedRevisionOperationBuilder<OT, T> revisionOperationWith() {
		return new TruncatedDefaultRevisionOperationBuilder<>();
	}

	public interface RevisionOperationBuilder<OT, T extends RevisionOperation<OT>, TBUILDER extends RevisionOperationBuilder<OT, T, TBUILDER>> extends Builder<T, TBUILDER> {
		TBUILDER aType(OperationType operationType);

		TBUILDER elements(Collection<OT> elements);
	}

	public static class DefaultRevisionOperationBuilder<OT, T extends RevisionOperation<OT>, EBUILDER extends RevisionOperationBuilder<OT, T, EBUILDER>, TBUILDER extends DefaultRevisionOperationBuilder<OT, T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements RevisionOperationBuilder<OT, T, EBUILDER> {

		protected DefaultRevisionOperationBuilder() {
		}

		@Override
		public final EBUILDER aType(OperationType operationType) {
			when(getBuildable().getType()).thenReturn(operationType);
			return getInterfaceBuilder();
		}

		@Override
		public final EBUILDER elements(Collection<OT> elements) {
			when(getBuildable().getElements()).thenReturn(elements);
			return getInterfaceBuilder();
		}
	}

	public interface TruncatedRevisionOperationBuilder<OT, T extends RevisionOperation<OT>> extends RevisionOperationBuilder<OT, T, TruncatedRevisionOperationBuilder<OT, T>> {
	}

	private static final class TruncatedDefaultRevisionOperationBuilder<OT, T extends RevisionOperation<OT>> extends DefaultRevisionOperationBuilder<OT, T, TruncatedRevisionOperationBuilder<OT, T>, TruncatedDefaultRevisionOperationBuilder<OT, T>> implements TruncatedRevisionOperationBuilder<OT, T> {

		TruncatedDefaultRevisionOperationBuilder() {
		}
	}
}
