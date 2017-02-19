package com.divae.firstspirit.storage;

import com.divae.firstspirit.storage.RevisionChangeDetailMock.DefaultRevisionChangeDetailBuilder;
import com.divae.firstspirit.storage.RevisionChangeDetailMock.RevisionChangeDetailBuilder;
import de.espirit.firstspirit.storage.DataChangeDetail;
import de.espirit.firstspirit.storage.DataChangeDetail.ChangeFlag;

import static org.mockito.Mockito.when;

public final class DataChangeDetailMock {

	private DataChangeDetailMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static DataChangeDetailBuilder dataChangeDetailWith() {
		return new DefaultDataChangeDetailBuilder();
	}

	public interface DataChangeDetailBuilder extends RevisionChangeDetailBuilder<DataChangeDetail, DataChangeDetailBuilder> {
		DataChangeDetailBuilder aChangeFlag(ChangeFlag changeFlag);
	}

	public static final class DefaultDataChangeDetailBuilder extends DefaultRevisionChangeDetailBuilder<DataChangeDetail, DataChangeDetailBuilder, DefaultDataChangeDetailBuilder> implements DataChangeDetailBuilder {

		private DefaultDataChangeDetailBuilder() {
		}

		@Override
		public final DataChangeDetailBuilder aChangeFlag(ChangeFlag changeFlag) {
			when(getBuildable().getChangeFlag()).thenReturn(changeFlag);
			return getBuilder();
		}
	}
}
