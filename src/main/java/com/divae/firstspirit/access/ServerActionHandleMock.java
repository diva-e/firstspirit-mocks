package com.divae.firstspirit.access;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.ActionProgressMock.ActionProgressBuilder;
import de.espirit.firstspirit.access.ActionProgress;
import de.espirit.firstspirit.access.ServerActionHandle;

import java.io.Serializable;
import java.util.function.Supplier;

import static com.divae.firstspirit.BuilderMock.build;
import static org.mockito.Mockito.when;

public final class ServerActionHandleMock {

	private ServerActionHandleMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends ActionProgress, R extends Serializable> ServerActionHandleBuilder<T, R> serverActionHandleWith() {
		return new DefaultServerActionHandleBuilder<>();
	}

	public interface ServerActionHandleBuilder<T extends ActionProgress, R extends Serializable> extends Builder<ServerActionHandle<T, R>, ServerActionHandleBuilder<T, R>> {
		<OTBUILDER extends ActionProgressBuilder<T, OTBUILDER>> ServerActionHandleBuilder<T, R> aProgress(Supplier<OTBUILDER> supplier, boolean removeActionIfFinished);

		ServerActionHandleBuilder<T, R> aResult(R result, boolean removeAction) throws Exception;
	}

	public static final class DefaultServerActionHandleBuilder<T extends ActionProgress, R extends Serializable> extends DefaultBuilder<ServerActionHandle<T, R>, ServerActionHandleBuilder<T, R>, DefaultServerActionHandleBuilder<T, R>> implements ServerActionHandleBuilder<T, R> {

		private DefaultServerActionHandleBuilder() {
		}

		@Override
		public final <OTBUILDER extends ActionProgressBuilder<T, OTBUILDER>> ServerActionHandleBuilder<T, R> aProgress(Supplier<OTBUILDER> supplier, boolean removeActionIfFinished) {
			T actionProgress = build(supplier.get());
			when(getBuildable().getProgress(removeActionIfFinished)).thenReturn(actionProgress);
			return getBuilder();
		}

		@Override
		public final ServerActionHandleBuilder<T, R> aResult(R result, boolean removeAction) throws Exception {
			when(getBuildable().getResult(removeAction)).thenReturn(result);
			return getBuilder();
		}
	}
}
