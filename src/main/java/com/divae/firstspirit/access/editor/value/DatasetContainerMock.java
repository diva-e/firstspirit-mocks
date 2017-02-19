package com.divae.firstspirit.access.editor.value;

import com.divae.firstspirit.BuilderMock.Builder;
import com.divae.firstspirit.BuilderMock.DefaultBuilder;
import com.divae.firstspirit.access.store.contentstore.DatasetMock.DatasetBuilder;
import de.espirit.firstspirit.access.editor.value.DatasetContainer;

import java.util.UUID;

import static org.mockito.Mockito.when;

public final class DatasetContainerMock {

	private DatasetContainerMock() {
		throw new UnsupportedOperationException("Don't use default constructor");
	}

	public static DatasetContainerBuilder datasetContainerWith(UUID gid) {
		return new DefaultDatasetContainerBuilder(gid);
	}

	public interface DatasetContainerBuilder extends Builder<DatasetContainer, DatasetContainerBuilder> {
		DatasetContainerBuilder aDataset(DatasetBuilder dataset);
	}

	public static final class DefaultDatasetContainerBuilder extends DefaultBuilder<DatasetContainer, DatasetContainerBuilder, DefaultDatasetContainerBuilder> implements DatasetContainerBuilder {

		private DefaultDatasetContainerBuilder(UUID gid) {
			super(gid);
			anGid(gid);
		}

		@Override
		public final DatasetContainerBuilder aDataset(DatasetBuilder dataset) {
			when(getBuildable().getDataset()).thenReturn(getBuildable(dataset));
			return getBuilder();
		}

		private void anGid(UUID gid) {
			when(getBuildable().getGid()).thenReturn(gid);
		}
	}
}
