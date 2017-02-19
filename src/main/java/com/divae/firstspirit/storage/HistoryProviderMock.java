package com.divae.firstspirit.storage;

import com.divae.firstspirit.BuilderMock;
import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.storage.RevisionMock.RevisionBuilder;
import de.espirit.firstspirit.storage.HistoryProvider;
import de.espirit.firstspirit.storage.Revision;

import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;
import static org.mockito.Mockito.when;

public final class HistoryProviderMock {

	private HistoryProviderMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static <T extends HistoryProvider, TBUILDER extends HistoryProviderBuilder<T, TBUILDER>> TruncatedHistoryProviderBuilder<T> historyProviderWith(TBUILDER historyProvider) {
		return new TruncatedDefaultHistoryProviderBuilder<>(historyProvider);
	}

	public static <T extends HistoryProvider> TruncatedHistoryProviderBuilder<T> historyProviderWith() {
		return new TruncatedDefaultHistoryProviderBuilder<>();
	}


	public interface HistoryProviderBuilder<T extends HistoryProvider, TBUILDER extends HistoryProviderBuilder<T, TBUILDER>> extends Builder<T, TBUILDER> {
		TBUILDER aHistory(Supplier<List<RevisionBuilder>> supplier);
	}

	public static class DefaultHistoryProviderBuilder<T extends HistoryProvider, EBUILDER extends HistoryProviderBuilder<T, EBUILDER>, TBUILDER extends DefaultHistoryProviderBuilder<T, EBUILDER, TBUILDER>> extends DefaultBuilder<T, EBUILDER, TBUILDER> implements HistoryProviderBuilder<T, EBUILDER> {

		protected DefaultHistoryProviderBuilder() {
		}

		protected <OTBUILDER extends Builder<T, OTBUILDER>> DefaultHistoryProviderBuilder(OTBUILDER historyProvider) {
			super(historyProvider);
		}

		@Override
		public final EBUILDER aHistory(Supplier<List<RevisionBuilder>> supplier) {
			List<Revision> revisions = supplier.get().stream().map(BuilderMock::build).collect(toList());
			when(getBuildable().getHistory()).thenReturn(revisions);
			return getInterfaceBuilder();
		}
	}

	public interface TruncatedHistoryProviderBuilder<T extends HistoryProvider> extends HistoryProviderBuilder<T, TruncatedHistoryProviderBuilder<T>> {
	}

	private static final class TruncatedDefaultHistoryProviderBuilder<T extends HistoryProvider> extends DefaultHistoryProviderBuilder<T, TruncatedHistoryProviderBuilder<T>, TruncatedDefaultHistoryProviderBuilder<T>> implements TruncatedHistoryProviderBuilder<T> {

		TruncatedDefaultHistoryProviderBuilder() {
		}

		<TBUILDER extends HistoryProviderBuilder<T, TBUILDER>> TruncatedDefaultHistoryProviderBuilder(TBUILDER historyProvider) {
			super(historyProvider);
		}
	}
}
